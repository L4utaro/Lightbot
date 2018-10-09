package commands;

import commands.interfaces.ICommand;
import model.Map;

public class CommandLight implements ICommand{

	public void executeCommand(Map map) {
		map.getBox(map.getAvatarPos()).changeStateLight();
	}

}
