package model;

import java.awt.Point;
import java.util.List;

import board.Builder;
import enums.LightStatus;
import enums.TypeOfBox;
import model.interfaces.IObjectGraphic;

public class Map implements Cloneable {
	private Board board;

	public Map(Builder builder) {
		board = builder.getBoard();
	}

	public Board getBoard() {
		return board;
	}

	public Box getBox(Point pointBox) {
		return board.getBox(pointBox);
	}

	public void addBoxAvatar(Point pointBox, TypeOfBox typeOfBox, IObjectGraphic objectGraphic) {
		board.addBoxAvatar(pointBox, typeOfBox, objectGraphic);
	}

	public void addBoxLight(Point pointBox, TypeOfBox typeOfBox, LightStatus lightStatus) {
		board.addBoxLight(pointBox, typeOfBox, lightStatus);
	}

	public void deleteBox(Point pointBox) {
		board.deleteBox(pointBox);
	}

	public Size getLimitsBoard() {
		return board.getLimitsBoard();
	}

	public boolean isOcupatePosition(Point point) {
		return this.board.isOcupatePosition(point);
	}

	public Point getAvatarPos() {
		return this.board.getAvatarPos();
	}

	public List<Point> getListOfLightPos() {
		return this.board.getListOfLightPos();
	}

	public void setAvatarPos(Point avatarPos) {
		this.board.setAvatarPos(avatarPos);
	}

	public void addBoxObjectGraphic(Point pointBox, IObjectGraphic objectGraphic) {
		this.board.getBoxes()[pointBox.x - 1][pointBox.y - 1].setObjectGraphic(objectGraphic);
	}

	public void deleteObjectGraphic(Point position) {
		getBox(position).setObjectGraphic(null);
	}

	public void moveObjectGraphic(Point oldPosition, Point newPosition) {
		addBoxObjectGraphic(newPosition, getBox(oldPosition).getObjectGraphic());
		deleteBox(oldPosition);
		setAvatarPos(newPosition);
	}

	 public Object clone() throws CloneNotSupportedException{
	    return super.clone();
	 }
}
