package commands.invoker;

import commands.interfaces.ICommand;
import model.Map;

public class InvokerCommand {
	private ICommand command;
	private Double timeOfSleep;

	public InvokerCommand(ICommand command) {
		this.command = command;
		this.timeOfSleep = 1.5;
	}

	public void setCommand(ICommand command) {
		this.command = command;
	}

	public ICommand getCommand() {
		return command;
	}

	public void executeCommand(Map map) {
		try {
			this.command.executeCommand(map);
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
