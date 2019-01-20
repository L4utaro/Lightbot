package lectors.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;

import classProperties.ActionsProperties;
import commands.CommandFunction;
import commands.CommandLeft;
import commands.CommandLight;
import commands.CommandMove;
import commands.CommandRight;
import commands.invoker.InvokerCommand;
import configuration.Constants;
import lectors.LectorJson;
import lectors.LectorTxt;
import lectors.interfaces.ILector;
import validators.ValidatorJson;
import validators.ValidatorTxt;
import validators.interfaces.IValidatorInstructions;

public class Implementation {
	private ILector lector;
	private IValidatorInstructions validatorLector;
	private JSONArray actionsJson;
	private List<String> namesOfFunctions;
	private ActionsProperties actionsProperties;
	
	public Implementation(String route) {
		if (route.charAt(route.length() - 1) == 'n') {
			implementationJson(route);
		} else {
			implementationTxt(route);
		}
		this.namesOfFunctions = new ArrayList<String>();
		this.namesOfFunctions = getNamesOfFunctions();
		try {
			this.actionsProperties = new ActionsProperties(Constants.ROUTE_CONFIGURATIONS_ACTIONS);
		} catch (IOException e) {
			throw new IllegalArgumentException("Actions configurations not found");
		}
	}

	public void implementationJson(String route) {
		this.lector = new LectorJson(route);
		this.actionsJson = (JSONArray) this.lector.getListOfJson("actions");
		this.validatorLector = new ValidatorJson();
	}

	public void implementationTxt(String route) {
		this.lector = new LectorTxt(route);
		this.actionsJson = (JSONArray) this.lector.getListOfJson("actions");
		this.validatorLector = new ValidatorTxt();
	}

	public List<String> getNamesOfFunctions() {
		return this.lector.getNamesOfArrays();
	}

	public Map<String, List<InvokerCommand>> getAllFunctions() {
		Map<String, List<InvokerCommand>> functions = new HashMap<String, List<InvokerCommand>>();
		functions.putAll(defaultFunciontions());
		functions.put("actions",createColecctionOfActions(this.namesOfFunctions));
		for (String nameFunction : this.namesOfFunctions) {
			if (!nameFunction.equals("actions")) {
				this.actionsJson = (JSONArray) this.lector.getListOfJson(nameFunction);
				functions.put(nameFunction, createColecctionOfActions(null));
			}
		}
		return functions;
	}

	private Map<? extends String, ? extends List<InvokerCommand>> defaultFunciontions() {
		//Constants.ROUTE_FUNCTIONS_MACRO
		return null;
	}

	public List<InvokerCommand> createColecctionOfActions(List<String> namesOfFunctions) {
		List<InvokerCommand> invokerCommands = new ArrayList<InvokerCommand>();
		if (this.validatorLector.validateInstructionsOfJsonArray(this.actionsJson, namesOfFunctions)) {
			for (int i = 0; i < this.actionsJson.size(); i++) {
				addAction(actionsJson.get(i).toString(), invokerCommands);
			}
		} else {
			throw new IllegalArgumentException("The actions contains wrong parameters");
		}
		return invokerCommands;
	}

	public void addAction(String action, List<InvokerCommand> invokerCommands) {
		if (this.actionsProperties.getActionsConfiguration().getAvanzar().contains(action)) {
			invokerCommands.add(new InvokerCommand(new CommandMove()));
		} else if (this.actionsProperties.getActionsConfiguration().getIzquierda().contains(action)) {
			invokerCommands.add(new InvokerCommand(new CommandLeft()));
		} else if (this.actionsProperties.getActionsConfiguration().getDerecha().contains(action)) {
			invokerCommands.add(new InvokerCommand(new CommandRight()));
		} else if (this.actionsProperties.getActionsConfiguration().getLuz().contains(action)) {
			invokerCommands.add(new InvokerCommand(new CommandLight()));
		} else {
			invokerCommands.add(new InvokerCommand(new CommandFunction(action)));
		}
	}

	public JSONArray getActionsJson() {
		return actionsJson;
	}
}
