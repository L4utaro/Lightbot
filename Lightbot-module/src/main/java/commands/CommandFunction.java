package commands;

import commands.interfaces.ICommand;
import model.Map;


public class CommandFunction implements ICommand{
	private String nameFunction;

	public CommandFunction(String nameFunction) {
		this.nameFunction = nameFunction;
	}
	
	@Override
	public void executeCommand(Map map) {
	}

	public String getNameFunction() {
		return nameFunction;
	}
}
