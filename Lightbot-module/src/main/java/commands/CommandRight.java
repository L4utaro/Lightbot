package commands;

import commands.interfaces.ICommand;
import model.Avatar;
import model.Map;

public class CommandRight implements ICommand {

	public void executeCommand(Map map) {
		makeChangeOfOrientation((Avatar) map.getBox(map.getAvatarPos()).getObjectGraphic());
	}

	public void makeChangeOfOrientation(Avatar avatar) {
		avatar.turnRight();
	}

}
