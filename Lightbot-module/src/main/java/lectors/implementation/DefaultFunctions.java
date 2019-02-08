package lectors.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;

import commands.invoker.InvokerCommand;
import lectors.LectorJson;
import lectors.interfaces.ILector;
import model.Command;
import model.CommandFunction;
import model.interfaces.ICommand;
import validators.ValidatorJson;
import validators.interfaces.IValidatorInstructions;

public class DefaultFunctions {
	private ILector lector;
	private IValidatorInstructions validatorLector;
	private JSONArray actionsJson;
	private List<String> namesOfFunctions;
	private List<String> namesOfCommands;
	private Map<String, List<InvokerCommand>> functionsDefault;
	private List<ICommand> commands;
	
	public DefaultFunctions(String routeFunctionsDefault, List<ICommand> commands) {
		this.namesOfCommands = new ArrayList<String>();
		this.lector = new LectorJson(routeFunctionsDefault);
		this.commands = commands;
		this.actionsJson = (JSONArray) this.lector.getListOfJson("actions");
		this.validatorLector = new ValidatorJson();
		this.namesOfFunctions = new ArrayList<>();
		this.namesOfFunctions.addAll(this.lector.getNamesOfArrays());
		this.namesOfCommands.addAll(getNamesOfCommands());
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

	public List<String> getNamesOfCommands() {
		List<String> namesCommands = new ArrayList<>();
		this.commands.stream().forEach(command -> { 
			if(((Command) command).getName() != null) {
				namesCommands.add(((Command) command).getName());
			}
		});
		return namesCommands;
	}
	
	private List<InvokerCommand> createColecctionOfActions(Object object) {
		List<InvokerCommand> invokerCommands = new ArrayList<InvokerCommand>();
		if (this.validatorLector.validateInstructionsOfJsonArray(this.actionsJson, namesOfFunctions, this.namesOfCommands, null)) {
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
	
	public Map<String, List<InvokerCommand>> getAllFunctions() {
		return this.functionsDefault;
	}

	public List<String> getNamesOfFunctions() {
		return this.namesOfFunctions;
	}
}

