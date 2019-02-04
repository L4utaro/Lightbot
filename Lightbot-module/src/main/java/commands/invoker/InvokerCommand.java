package commands.invoker;

import commands.interfaces.ICommand;
import model.Command;
import model.Map;

public class InvokerCommand {
	private ICommand command2;
	private Command command;
	private Double timeOfSleep;

	public InvokerCommand(ICommand command) {
		this.command2 = command;
		this.timeOfSleep = 1.5;
	}

	public InvokerCommand(Command command) {
		this.command = command;
		this.timeOfSleep = 1.5;
	}

	public void setCommand(ICommand command) {
		this.command2 = command;
	}

	public ICommand getCommand() {
		return command2;
	}

	public void executeCommand(Map map) {
		try {
			this.command2.executeCommand(map);
			Thread.sleep((long) (1000 * this.timeOfSleep));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Double getTimeOfSleep() {
		return timeOfSleep;
	}

	public void setTimeOfSleep(Double timeOfSleep) {
		this.timeOfSleep = timeOfSleep;
	}
}
