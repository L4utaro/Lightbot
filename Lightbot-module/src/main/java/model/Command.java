package model;

import java.awt.Point;
import java.util.List;

import commands.ExecuteCommand;
import enums.Orientation;

public class Command {

	private String name;

	private String mode;

	private List<Point> pointsPositions;

	private Integer movePositions;

	private Orientation newOrientation;

	private String turn;

	private String light;

	private ExecuteCommand executeCommand;
	
	public Command(String name, String mode, List<Point> pointsPositions, Integer movePositions,
			Orientation newOrientation, String turn, String light) {
		this.name = name;
		this.mode = mode;
		this.pointsPositions = pointsPositions;
		this.movePositions = movePositions;
		this.newOrientation = newOrientation;
		this.turn = turn;
		this.light = light;
		this.executeCommand = new ExecuteCommand(this);
	}

	public void executeCommand(Map map) {
		this.executeCommand(map);
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

	public Orientation getNewOrientation() {
		return newOrientation;
	}

	public void setNewOrientation(Orientation newOrientation) {
		this.newOrientation = newOrientation;
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

	public ExecuteCommand getExecuteCommand() {
		return executeCommand;
	}

	public void setExecuteCommand(ExecuteCommand executeCommand) {
		this.executeCommand = executeCommand;
	}

	@Override
	public String toString() {
		return "Command [name=" + name + ", mode=" + mode + ", pointsPositions=" + pointsPositions + ", movePositions="
				+ movePositions + ", newOrientation=" + newOrientation + ", turn=" + turn + ", light=" + light + "]";
	}
}
