package model;

import model.interfaces.ICommand;

public class CommandFunction implements ICommand {
	private String nameFunction;

	public CommandFunction(String nameFunction) {
		this.nameFunction = nameFunction;
	}

	public String getNameFunction() {
		return nameFunction;
	}

	public void setNameFunction(String nameFunction) {
		this.nameFunction = nameFunction;
	}
}
