package commands.invoker;

import commands.ExecuteCommand;
//import commands.interfaces.ICommand;
import model.Command;
import model.Map;
import model.interfaces.ICommand;

public class InvokerCommand {
	private ICommand command;
	private Double timeOfSleep;
	private ExecuteCommand executeCommand;
	
	public InvokerCommand(ICommand command) {
		this.command = command;
		this.timeOfSleep = 1.5;
	}

	public void executeCommand(Map map) {
		try {
			this.executeCommand = new ExecuteCommand((Command)command);
			this.executeCommand.execute(map);
			Thread.sleep((long) (1000 * this.timeOfSleep));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public ICommand getCommand() {
		return command;
	}

	public void setCommand(ICommand command) {
		this.command = command;
	}

	public Double getTimeOfSleep() {
		return timeOfSleep;
	}

	public void setTimeOfSleep(Double timeOfSleep) {
		this.timeOfSleep = timeOfSleep;
	}
}
