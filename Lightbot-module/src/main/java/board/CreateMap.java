package board;

import java.io.IOException;

import classProperties.MapProperties;
import model.Map;
import validators.ValidatorCreateMap;

public class CreateMap {
	private Map map;
	private MapProperties mapProperties;
	private ValidatorCreateMap validatorCreateMap;
	
	public CreateMap (String route_properties) throws IOException {
		mapProperties = new MapProperties(route_properties);
		createMap();
		this.validatorCreateMap = new ValidatorCreateMap(this.map, this.mapProperties);
		validateMapAndProperties();
	}
	
	public void validateMapAndProperties() {
		if(!this.validatorCreateMap.isValidMap()) {
			throw new IllegalArgumentException("Is a invalid map");
		}
	}

	public void createMap() {
		map = new Builder(mapProperties.getMapConfiguration().getMapSize())
				.whitRoadPossible(mapProperties.getMapConfiguration().getPosOfPathPossible())
				.whitLights(mapProperties.getMapConfiguration().getPosLight())
				.whitAvatar(mapProperties.getMapConfiguration().getPosAvatar())
				.build();
	}

	public Map getMap() {
		return map;
	}

	public MapProperties getMapProperties() {
		return mapProperties;
	}

	public void setValidatorCreateMap(ValidatorCreateMap validatorCreateMap) {
		this.validatorCreateMap = validatorCreateMap;
	}
}
