package validators;

import java.awt.Point;

import model.Map;

public class ValidatorPathOfObjectGraphic implements IValidator {
	private ValidatorBoard validatorBoard;

	public ValidatorPathOfObjectGraphic(Map map) {
		this.validatorBoard = new ValidatorBoard(map.getBoard());
	}

	public boolean validatePositionForObjectGraphic(Point newPosition) {
		return this.validatorBoard.isValidPositionForBox(newPosition)
				|| this.validatorBoard.isValidPositionForObjectGraphic(newPosition);
	}
}
