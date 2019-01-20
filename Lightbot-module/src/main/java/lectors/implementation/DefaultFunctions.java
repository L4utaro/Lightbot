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
import lectors.interfaces.ILector;
import validators.ValidatorJson;
import validators.interfaces.IValidatorInstructions;

public class DefaultFunctions {
	private ILector lector;
	private IValidatorInstructions validatorLector;
	private JSONArray actionsJson;
	private List<String> namesOfFunctions;
	private ActionsProperties actionsProperties;
	private Map<String, List<InvokerCommand>> functionsDefault;
	
	public DefaultFunctions(String routeFunctionsDefault) {
		this.lector = new LectorJson(routeFunctionsDefault);
		this.actionsJson = (JSONArray) this.lector.getListOfJson("actions");
		this.validatorLector = new ValidatorJson();
		this.namesOfFunctions = new ArrayList<>();
		this.namesOfFunctions.addAll(this.lector.getNamesOfArrays());
		try {
			this.actionsProperties = new ActionsProperties(Constants.ROUTE_CONFIGURATIONS_ACTIONS);
		} catch (IOException e) {
			throw new IllegalArgumentException("Actions configurations not found");
		}
		createFunctionsDefaulf();
	}
	
	public void createFunctionsDefaulf() {
		this.functionsDefault = new HashMap<String, List<InvokerCommand>>();
		for (String nameFunction : this.namesOfFunctions) {
			if (!nameFunction.equals("actions")) {
				this.actionsJson = (JSONArray) this.lector.getListOfJson(nameFunction);
				functionsDefault.put(nameFunction, createColecctionOfActions(null));
			}
		}
	}
	
	private List<InvokerCommand> createColecctionOfActions(Object object) {
		List<InvokerCommand> invokerCommands = new ArrayList<InvokerCommand>();
		if (this.validatorLector.validateInstructionsOfJsonArray(this.actionsJson, namesOfFunctions, null)) {
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
	
	public Map<String, List<InvokerCommand>> getAllFunctions() {
		return this.functionsDefault;
	}

	public List<String> getNamesOfFunctions() {
		return this.namesOfFunctions;
	}
}

