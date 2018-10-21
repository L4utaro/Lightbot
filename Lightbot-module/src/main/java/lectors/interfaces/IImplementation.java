package lectors.interfaces;

import java.util.List;

import org.json.simple.JSONArray;

import commands.invoker.InvokerCommand;

public interface IImplementation {

	public void createColecctionOfActions();

	public void addAction(String action);

	public List<InvokerCommand> getInvokerCommands();

	public JSONArray getActionsJson();
}
