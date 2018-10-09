package validators;

import java.awt.Point;

import enums.LightStatus;
import model.Map;

public class ValidatorGame implements IValidator{
//	private ValidatorPathOfObjectGraphic validatorPathOfObjectGraphic;
//	private Map map;
//	
//	public ValidatorGame(Map map) {
//		this.validatorPathOfObjectGraphic = new ValidatorPathOfObjectGraphic(map);
//		this.map = map;
//	}
//	
//	public boolean avatarIsOutOfPathPossible() {
//		return this.validatorPathOfObjectGraphic.validatePositionForObjectGraphic(newPosition);
//	}

	public boolean allLightsAreTurnedOn(Map map) {
			for(Point pointLight : map.getBoard().getListOfLightPos()){
				if(map.getBox(pointLight).getLightStatus() == LightStatus.OFF){
					return false;
				}
			}
		return true;
	}

}

