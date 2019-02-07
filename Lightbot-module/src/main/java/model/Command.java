package model;

import java.awt.Point;
import java.util.List;

import commands.ExecuteCommand;
import enums.Orientation;
import model.interfaces.ICommand;

public class Command implements ICommand{

	private String name;

	private String mode;

	private List<Point> pointsPositions;

	private Integer movePositions;

	private Orientation orientation;

	private String turn;

	private String light;
	
	public Command(String name, String mode, List<Point> pointsPositions, Integer movePositions,
			Orientation newOrientation, String turn, String light) {
		this.name = name;
		this.mode = mode;
		this.pointsPositions = pointsPositions;
		this.movePositions = movePositions;
		this.orientation = newOrientation;
		this.turn = turn;
		this.light = light;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public List<Point> getPointsPositions() {
		return pointsPositions;
	}

	public void setPointsPositions(List<Point> pointsPositions) {
		this.pointsPositions = pointsPositions;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation newOrientation) {
		this.orientation = newOrientation;
	}

	public Integer getMovePositions() {
		return movePositions;
	}

	public void setMovePositions(Integer movePositions) {
		this.movePositions = movePositions;
	}

	public String getGirar() {
		return turn;
	}

	public void setGirar(String girar) {
		this.turn = girar;
	}

	public String getLight() {
		return light;
	}

	public void setLight(String light) {
		this.light = light;
	}

	@Override
	public String toString() {
		return "Command [name=" + name + ", mode=" + mode + ", pointsPositions=" + pointsPositions + ", movePositions="
				+ movePositions + ", newOrientation=" + orientation + ", turn=" + turn + ", light=" + light + "]";
	}
}
