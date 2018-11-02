package commands;

import commands.interfaces.ICommand;
import enums.Orientation;
import model.Avatar;
import model.Map;

public class CommandRight implements ICommand {

	public void executeCommand(Map map) {
		((Avatar) map.getBox(map.getAvatarPos()).getObjectGraphic()).setOrientation(
				getNewOrientation(((Avatar) map.getBox(map.getAvatarPos()).getObjectGraphic()).getOrientation()));
	}

	public Orientation getNewOrientation(Orientation orientation) {
		switch(orientation) {
		case UP:
			return Orientation.RIGHT;
		case LEFT:
			return Orientation.UP;
		case DOWN:
			return Orientation.LEFT;
		case RIGHT:
			return Orientation.DOWN;
		}
		return orientation;
	}
}
