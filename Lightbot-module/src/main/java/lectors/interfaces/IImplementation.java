package lectors.interfaces;

import java.util.List;

import org.json.simple.JSONArray;

import commands.invoker.InvokerCommand;

public interface IImplementation {

	public List<InvokerCommand> createColecctionOfActions(String nameFunction);

	public void addAction(String action, List<InvokerCommand> invokerCommands);

	public List<InvokerCommand> getInvokerCommands();

	public JSONArray getActionsJson();
	
	public void createMapFunction();
}
