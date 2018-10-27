package commands.invoker;

import commands.interfaces.ICommand;
import model.Map;

public class InvokerCommand {
	private ICommand command;

	public InvokerCommand(ICommand command) {
		this.command = command;
	}

	public void setCommand(ICommand command) {
		this.command = command;
	}

	public void executeCommand(Map map) {
		try {
			this.command.executeCommand(map);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
