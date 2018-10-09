package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import enums.LightStatus;
import enums.TypeOfBox;
import model.interfaces.IObjectGraphic;

public class Board {
	private Box[][] boxes;
	private Point avatarPos;
	private List<Point> listOfLightPos;
	
	public Board(Point sizeBoard) {
		this.boxes = new Box[sizeBoard.x][sizeBoard.y];
		this.listOfLightPos = new ArrayList<Point>();
	}

	public Box[][] getBoxes() {
		return boxes;
	}

	public boolean isOcupatePosition(Point box) {
		if ((boxes.length < box.x) || (0 > box.x) || (boxes[0].length < box.y) || (0 > box.y)) {
			throw new IllegalArgumentException("No se puede acceder a la casilla, excede el limite del mapa");
		}
		return (boxes[box.x-1][box.y-1].getObjectGraphic() != null);
	}

	public Box getBox(Point pointBox) {
		return boxes[pointBox.x - 1][pointBox.y - 1];
	}

	public void deleteBox(Point pointBox) {
		boxes[pointBox.x - 1][pointBox.y - 1] = null;
	}


	public void addBoxAvatar(Point pointBox, TypeOfBox typeOfBox, IObjectGraphic objectGraphic) {
		this.avatarPos = pointBox;
		this.boxes[pointBox.x - 1][pointBox.y - 1] = new Box(typeOfBox, objectGraphic);
	}

	public void addBoxLight(Point pointBox, TypeOfBox typeOfBox,LightStatus lightStatus) {
		this.listOfLightPos.add(pointBox);
		this.boxes[pointBox.x - 1][pointBox.y - 1] = new Box(typeOfBox, lightStatus);
	}
	
	public void addBox(Point pointBox, TypeOfBox typeOfBox) {
		this.boxes[pointBox.x - 1][pointBox.y - 1] = new Box(typeOfBox);
	}

	public void printBoard() {
		String file = "";
		for (int y = 0; y < boxes[0].length; y++) {
			for (int x = 0; x < boxes.length; x++) {
				if (boxes[x][y] != null) {
					if (boxes[x][y].getTypeOfBox().equals(TypeOfBox.NO_WALK)) {
						file = file + "[ NO_WALK]";
					} else if (!(boxes[x][y].getObjectGraphic() == null)) {
						file = file + "[" +boxes[x][y].getObjectGraphic().getClass().getName() + "]";
					} else {
						file = file + "[ WALK]";
					}
				} else {
					file = file + "[ null]";
				}
			}
			System.out.println(file);
			file = "";
		}
	}
	
	public Point getLimitsBoard() {
		return new Point(boxes.length, boxes[0].length);
	}

	public Point getAvatarPos() {
		return avatarPos;
	}

	public void setAvatarPos(Point avatarPos) {
		this.avatarPos = avatarPos;
	}

	public List<Point> getListOfLightPos() {
		return listOfLightPos;
	}
}
