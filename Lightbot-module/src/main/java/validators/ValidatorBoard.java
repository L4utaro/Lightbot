package validators;

import java.awt.Point;

import enums.TypeOfBox;
import model.Board;
import validators.interfaces.IValidator;

public class ValidatorBoard implements IValidator {
	private Board board;

	public ValidatorBoard(Board board) {
		this.board = board;
	}

	public boolean isValidPositionForBox(Point position) {
		try {
			this.board.getBox(position);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean isValidPositionForObjectGraphic(Point position) {
		return !(this.board.getBox(position).getTypeOfBox().equals(TypeOfBox.NO_WALK));
	}
}
