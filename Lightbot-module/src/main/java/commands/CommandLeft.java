package commands;

import model.Map;

import commands.interfaces.ICommand;
import enums.Orientation;
import model.Avatar;

public class CommandLeft implements ICommand {

	public void executeCommand(Map map) {
		((Avatar) map.getBox(map.getAvatarPos()).getObjectGraphic()).setOrientation(
				getNewOrientation(((Avatar) map.getBox(map.getAvatarPos()).getObjectGraphic()).getOrientation()));
	}

	public Orientation getNewOrientation(Orientation orientation) {
		switch(orientation) {
		case UP:
			return Orientation.LEFT;
		case LEFT:
			return Orientation.DOWN;
		case DOWN:
			return Orientation.RIGHT;
		case RIGHT:
			return Orientation.UP;
		}
		return orientation;
	}
}
