package commands;

import java.util.List;

import commands.interfaces.ICommand;
import commands.invoker.InvokerCommand;
import model.Map;


public class CommandFunction implements ICommand{
	private String nameFunction;
	private List<InvokerCommand> invokersCommands;

	public CommandFunction(String nameFunction) {//, List<InvokerCommand> invokersCommands
		this.nameFunction = nameFunction;
		this.invokersCommands = invokersCommands;
	}
	
	@Override
	public void executeCommand(Map map) {
		for(InvokerCommand invokerCommand: this.invokersCommands) {
			invokerCommand.executeCommand(map);
		}
	}

	public String getNameFunction() {
		return nameFunction;
	}

	public List<InvokerCommand> getInvokersCommands() {
		return invokersCommands;
	}
}
