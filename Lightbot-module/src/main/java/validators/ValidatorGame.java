package validators;

import java.awt.Point;

import enums.LightStatus;
import enums.TypeOfBox;
import model.Map;

public class ValidatorGame implements IValidator {
	private Map map;

	public ValidatorGame(Map map) {
		this.map = map;
	}

	public boolean isAvatarIsOutOfPathPossible() {
		return (this.map.getBox(this.map.getAvatarPos()).getTypeOfBox() == TypeOfBox.NO_WALK);
	}

	public boolean allLightsAreTurnedOn(Map map) {
		for (Point pointLight : map.getBoard().getListOfLightPos()) {
			if (map.getBox(pointLight).getLightStatus() == LightStatus.OFF) {
				return false;
			}
		}
		return true;
	}

}
