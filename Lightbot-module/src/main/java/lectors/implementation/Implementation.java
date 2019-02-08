package lectors.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;

import commands.invoker.InvokerCommand;
import lectors.LectorJson;
import lectors.LectorTxt;
import lectors.interfaces.ILector;
import model.Command;
import model.CommandFunction;
import model.interfaces.ICommand;
import validators.ValidatorJson;
import validators.ValidatorTxt;
import validators.interfaces.IValidatorInstructions;

public class Implementation {
	private DefaultFunctions defaultFunctions;
	private ILector lector;
	private IValidatorInstructions validatorLector;
	private JSONArray actionsJson;
	private List<String> namesOfFunctions;
	private List<String> namesOfCommands;
	private List<ICommand> commands;
	
	public Implementation(String route, String routeDefaultFunctions, List<ICommand> commands) {
		this.namesOfFunctions = new ArrayList<String>();
		this.namesOfCommands = new ArrayList<String>();
		this.commands = commands;
		addDeaultFunctionsIfThereExists(routeDefaultFunctions);
		if (route.charAt(route.length() - 1) == 'n') {
			implementationJson(route);
		} else {
			implementationTxt(route);
		}
		this.namesOfCommands.addAll(getNamesOfCommands());
		this.namesOfFunctions.addAll(getNamesOfFunctions());
	}

	private void addDeaultFunctionsIfThereExists(String routeDefaultFunctions) {
		if(routeDefaultFunctions != null) {
			this.defaultFunctions = new DefaultFunctions(routeDefaultFunctions, this.commands);
			this.defaultFunctions.createFunctionsDefaulf();
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

	public List<String> getNamesOfCommands() {
		List<String> namesCommands = new ArrayList<>();
		this.commands.stream().forEach(command -> { 
			if(((Command) command).getName() != null) {
				namesCommands.add(((Command) command).getName());
			}
		});
		return namesCommands;
	}
	
	public Map<String, List<InvokerCommand>> getAllFunctionsDefaults() {
		return this.defaultFunctions.getAllFunctions();
	}
	
	public Map<String, List<InvokerCommand>> getAllFunctions() {
		Map<String, List<InvokerCommand>> functions = new HashMap<String, List<InvokerCommand>>();
		functions.putAll(this.defaultFunctions.getAllFunctions());
		functions.put("actions",createColecctionOfActions(this.namesOfFunctions));
		for (String nameFunction : this.namesOfFunctions) {
			if (!nameFunction.equals("actions")) {
				this.actionsJson = (JSONArray) this.lector.getListOfJson(nameFunction);
				functions.put(nameFunction, createColecctionOfActions(null));
			}
		}
		return functions;
	}

	public List<InvokerCommand> createColecctionOfActions(List<String> namesOfFunctions) {
		List<InvokerCommand> invokerCommands = new ArrayList<InvokerCommand>();
		if (this.validatorLector.validateInstructionsOfJsonArray(this.actionsJson, namesOfFunctions, this.namesOfCommands, this.defaultFunctions.getNamesOfFunctions())) {
			for (int i = 0; i < this.actionsJson.size(); i++) {
				addAction(actionsJson.get(i).toString(), invokerCommands);
			}
		} else {
			throw new IllegalArgumentException("The actions contains wrong parameters");
		}
		return invokerCommands;
	}

	public void addAction(String action, List<InvokerCommand> invokerCommands) {
		invokerCommands.add( new InvokerCommand( this.commands.stream().filter(command -> 
		((Command) command).getName().equals(action)).findAny().orElse(new CommandFunction(action))));
	}

	public JSONArray getActionsJson() {
		return actionsJson;
	}
}
