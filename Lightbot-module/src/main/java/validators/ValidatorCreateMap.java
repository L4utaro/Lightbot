package validators;

import java.awt.Point;

import classProperties.MapProperties;
import enums.LightStatus;
import enums.TypeOfBox;
import model.Avatar;
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
		return !(checkSizeBoard() && checkAvatarPosition() && checkLights() && checkRoad());
	}

	public boolean checkRoad() {
		for(Point pos: this.mapProperties.getElectionMap().getPosOfPathPossible()) {
			if(this.map.getBox(pos).getTypeOfBox().equals(TypeOfBox.WALK)) {
				return false;
			}
		}
		return true;
	}

	public boolean checkLights() {
		for(Point pos: this.mapProperties.getElectionMap().getPosLight()) {
			if(this.map.getBox(pos).getLightStatus().equals(LightStatus.OFF)) {
				return false;
			}
		}
		return true;
	}

	public boolean checkAvatarPosition() {
		return this.map.getBox(this.mapProperties.getElectionMap().getPosAvatar()).getObjectGraphic().equals(new Avatar());
	}

	public boolean checkSizeBoard() {
		return this.map.getLimitsBoard().x != this.mapProperties.getElectionMap().getMapSize().x
				&& this.map.getLimitsBoard().y != this.mapProperties.getElectionMap().getMapSize().y;
	}
}
