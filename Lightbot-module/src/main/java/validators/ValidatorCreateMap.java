package validators;

import java.awt.Point;

import classProperties.MapProperties;
import enums.TypeOfBox;
import model.Map;
import validators.interfaces.IValidator;

public class ValidatorCreateMap implements IValidator {
	private Map map;
	private MapProperties mapProperties;

	public ValidatorCreateMap(Map map, MapProperties mapProperties) {
		this.map = map;
		this.mapProperties = mapProperties;
	}

	public boolean isValidMap() {
		return (isAValidSizeBoard() && isAValidAvatarPosition() && isAValidLights() && isAValidRoad());
	}

	public boolean isAValidRoad() {
		for(Point pos: this.mapProperties.getElectionMap().getPosOfPathPossible()) {
			if(this.map.getBox(pos).getTypeOfBox().equals(TypeOfBox.NO_WALK)) {
				return false;
			}
		}
		return true;
	}

	public boolean isAValidLights() {
		for(Point pos: this.mapProperties.getElectionMap().getPosLight()) {
			if(this.map.getBox(pos).getLightStatus() == null) {
				return false;
			}
		}
		return true;
	}

	public boolean isAValidAvatarPosition() {
		return this.map.getAvatarPos().equals(this.mapProperties.getElectionMap().getPosAvatar());
	}

	public boolean isAValidSizeBoard() {
		return this.map.getLimitsBoard().x == this.mapProperties.getElectionMap().getMapSize().x
				&& this.map.getLimitsBoard().y == this.mapProperties.getElectionMap().getMapSize().y;
	}
}
