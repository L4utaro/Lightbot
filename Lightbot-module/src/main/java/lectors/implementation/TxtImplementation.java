package lectors.implementation;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

import commands.CommandFunction;
import commands.CommandLeft;
import commands.CommandLight;
import commands.CommandMove;
import commands.CommandRight;
import commands.invoker.InvokerCommand;
import lectors.LectorTxt;
import lectors.interfaces.IImplementation;
import validators.ValidatorTxt;

public class TxtImplementation implements IImplementation{
	private LectorTxt lectorTxt;
	private JSONArray actionsJson;
	private ValidatorTxt validatorTxt;
	private List<InvokerCommand> invokerCommands;
	private List<String> namesOfFunctions;

	public TxtImplementation(String routeTxt) {
		this.lectorTxt = new LectorTxt(routeTxt);
		this.lectorTxt.readFile();
		this.actionsJson = (JSONArray) this.lectorTxt.getListOfJson("actions");
		this.validatorTxt = new ValidatorTxt();
		this.invokerCommands = new ArrayList<InvokerCommand>();
		this.namesOfFunctions = new ArrayList<String>();
	}

	public void createMapFunction() {
		this.invokerCommands = this.createColecctionOfActions("actions");
	}
	
	public List<InvokerCommand> createColecctionOfActions(String nameFunction) {
		this.actionsJson = (JSONArray) this.lectorTxt.getListOfJson(nameFunction);
		List<InvokerCommand> invokerCommands = new ArrayList<>();
		this.namesOfFunctions = getNamesOfFunctions();
		if (this.validatorTxt.validateInstructionsOfJsonArray(this.actionsJson, this.namesOfFunctions)) {
			for (int i = 0; i < this.actionsJson.size(); i++) {
				addAction(actionsJson.get(i).toString(), invokerCommands);
			}
			return invokerCommands;
		} else {
			throw new IllegalArgumentException("The actions.txt contains wrong parameters");
		}
	}

	public List<String> getNamesOfFunctions() {
		return this.lectorTxt.getNamesOfArrays();
	}
	
	public void addAction(String action, List<InvokerCommand> invokerCommands) {
		if (action.equals("move")) {
			invokerCommands.add(new InvokerCommand(new CommandMove()));
		} else if (action.equals("left")) {
			invokerCommands.add(new InvokerCommand(new CommandLeft()));
		} else if (action.equals("right")) {
			invokerCommands.add(new InvokerCommand(new CommandRight()));
		} else if (action.equals("light")) {
			invokerCommands.add(new InvokerCommand(new CommandLight()));
		} else {
			invokerCommands.add(new InvokerCommand(new CommandFunction(action, createColecctionOfActions(action))));
		}
	}

	public List<InvokerCommand> getInvokerCommands() {
		return invokerCommands;
	}

	public JSONArray getActionsJson() {
		return actionsJson;
	}
}
