package board;

import java.awt.Point;
import java.util.List;

import enums.LightStatus;
import enums.TypeOfBox;
import model.Board;
import model.interfaces.IObjectGraphic;
import validators.ValidatorBoard;

public class AddBox {
	private Board board;
	private ValidatorBoard validatorBoard;

	public AddBox(Board board) {
		this.board = board;
		this.validatorBoard = new ValidatorBoard(this.board);
		autoCompleteBoxesEmpty();
	}

	public void addBoxesWalk(List<Point> posOfPathPossible) {
		for (Point position : posOfPathPossible) {
			if (!this.validatorBoard.isValidPositionForBox(position)) {
				throw new IllegalArgumentException("It is not a valid box to add an ObjectGraphic");
			}
			addBoxWalk(position);
		}
	}

	public void autoCompleteBoxesEmpty() {
		for (int y = 1; y <= this.board.getBoxes()[0].length; y++) {
			for (int x = 1; x <= this.board.getBoxes().length; x++) {
				addBoxNoWalk(new Point(x, y));
			}
		}
	}

	public void addObjectGraphic(Point position, IObjectGraphic objectGraphic) {
		if (!this.validatorBoard.isValidPositionForBox(position)
				|| !this.validatorBoard.isValidPositionForObjectGraphic(position)) {
			throw new IllegalArgumentException("It is not a valid box to add an ObjectGraphic");
		}
		this.board.addBoxAvatar(position, TypeOfBox.WALK, objectGraphic);
	}

	public void addBoxWalk(Point position) {
		this.board.addBox(position, TypeOfBox.WALK);
	}

	public void addBoxNoWalk(Point position) {
		this.board.addBox(position, TypeOfBox.NO_WALK);
	}

	public void addLights(List<Point> posOfLights, LightStatus light) {
		for (Point position : posOfLights) {
			if (!this.validatorBoard.isValidPositionForBox(position)
					|| !this.validatorBoard.isValidPositionForObjectGraphic(position)) {
				throw new IllegalArgumentException("It is not a valid box to add an Light");
			}
			this.board.addBoxLight(position, TypeOfBox.WALK,  light);
		}
	}
	
	public boolean validatePositions(List<Point> positionsOfStructure) {
		for (Point pos : positionsOfStructure) {
			if (this.board.isOcupatePosition(pos)) {
				return false;
			}
		}
		return true;
	}

	public Board getBoard() {
		return board;
	}
}