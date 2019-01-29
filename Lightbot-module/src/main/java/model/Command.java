package model;

import java.awt.Point;
import java.util.List;

import enums.Orientation;

public class Command {

	private String name;
	
	private Avatar avatar;
	
	private List<Point> pointsPositions;
	
	private Orientation newOrientation;

	public Command(String name, Avatar avatar, List<Point> pointsPositions, Orientation newOrientation) {
		super();
		this.name = name;
		this.avatar = avatar;
		this.pointsPositions = pointsPositions;
		this.newOrientation = newOrientation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public List<Point> getPointsPositions() {
		return pointsPositions;
	}

	public void setPointsPositions(List<Point> pointsPositions) {
		this.pointsPositions = pointsPositions;
	}

	public Orientation getNewOrientation() {
		return newOrientation;
	}

	public void setNewOrientation(Orientation newOrientation) {
		this.newOrientation = newOrientation;
	}
}
