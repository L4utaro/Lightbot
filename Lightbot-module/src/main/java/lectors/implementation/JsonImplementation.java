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
import lectors.LectorJson;
import lectors.interfaces.IImplementation;
import validators.ValidatorJson;

public class JsonImplementation implements IImplementation{
	private LectorJson lectorJson;
	private JSONArray actionsJson;
	private ValidatorJson validatorJson;
	private List<String> namesOfFunctions;
//	private Map<String, List<InvokerCommand>> allFunctions;
	private List<InvokerCommand> invokerCommands;
	
	public JsonImplementation(String routeJson) {
		this.lectorJson = new LectorJson(routeJson);
		this.namesOfFunctions = new ArrayList<String>();
		this.namesOfFunctions = getNamesOfFunctions();
//		this.allFunctions = new HashMap<String, List<InvokerCommand>>();
		this.validatorJson = new ValidatorJson();
		this.invokerCommands = new ArrayList<>();
	}
	
	public void createMapFunction() {
		//for(String nameFunction: namesOfFunctions) {
			//this.allFunctions.put(nameFunction, this.createColecctionOfActions(nameFunction));
		//}
		this.invokerCommands = this.createColecctionOfActions("actions");
		System.out.println(this.invokerCommands.size());
	}

	public List<InvokerCommand> createColecctionOfActions(String nameFunction) {
		this.actionsJson = (JSONArray) this.lectorJson.getListOfJson(nameFunction);
		System.out.println(this.actionsJson);
		List<InvokerCommand> invokerCommands = new ArrayList<>();
		if (this.validatorJson.validateInstructionsOfJsonArray(this.actionsJson, this.namesOfFunctions)) {
			for (int i = 0; i < this.actionsJson.size(); i++) {
				addAction(actionsJson.get(i).toString(), invokerCommands);
			}
			return invokerCommands;
		} else {
			throw new IllegalArgumentException("The actions.json contains wrong parameters");
		}
	}

	public List<String> getNamesOfFunctions() {
		return this.lectorJson.getNamesOfArrays();
	}

	public void addAction(String action, List<InvokerCommand> invokerCommands) {
		if (action.equals("avanzar")) {
			invokerCommands.add(new InvokerCommand(new CommandMove()));
		} else if (action.equals("izquierda")) {
			invokerCommands.add(new InvokerCommand(new CommandLeft()));
		} else if (action.equals("derecha")) {
			invokerCommands.add(new InvokerCommand(new CommandRight()));
		} else if (action.equals("luz")) {
			invokerCommands.add(new InvokerCommand(new CommandLight()));
		} else {
			invokerCommands.add(new InvokerCommand(new CommandFunction(action, createColecctionOfActions(action))));
		}
	}

	public JSONArray getActionsJson() {
		return actionsJson;
	}

	@Override
	public List<InvokerCommand> getInvokerCommands() {
		return this.invokerCommands;
	}
}
