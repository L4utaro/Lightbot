package lectors.implementation;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

import commands.CommandLeft;
import commands.CommandLight;
import commands.CommandMove;
import commands.CommandRight;
import commands.invoker.InvokerCommand;
import lectors.LectorJson;
import lectors.LectorTxt;
import lectors.interfaces.ILector;
import validators.ValidatorJson;
import validators.ValidatorTxt;
import validators.interfaces.IValidatorInstructions;

public class Implementation{
	private ILector lector;
	private IValidatorInstructions validatorLector;
	private JSONArray actionsJson;
	private List<InvokerCommand> invokerCommands;
	
	public Implementation(String route) {
		this.invokerCommands = new ArrayList<InvokerCommand>();
		if(route.charAt(route.length()-1) == 'n') {
			implementationJson(route);
		} else {
			implementationTxt(route);
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

	public void createColecctionOfActions() {
		if (this.validatorLector.validateInstructionsOfJsonArray(this.actionsJson)) {
			for (int i = 0; i < this.actionsJson.size(); i++) {
				addAction(actionsJson.get(i).toString());
			}
		} else {
			throw new IllegalArgumentException("The actions.txt contains wrong parameters");
		}
	}

	public void addAction(String action) {
		if (action.equals("avanzar") || action.equals("move")) {
			this.invokerCommands.add(new InvokerCommand(new CommandMove()));
		} else if (action.equals("izquierda") || action.equals("left")) {
			this.invokerCommands.add(new InvokerCommand(new CommandLeft()));
		} else if (action.equals("derecha") || action.equals("right")) {
			this.invokerCommands.add(new InvokerCommand(new CommandRight()));
		} else if (action.equals("luz") || action.equals("light")) {
			this.invokerCommands.add(new InvokerCommand(new CommandLight()));
		}
	}

	public List<InvokerCommand> getInvokerCommands() {
		return invokerCommands;
	}

	public JSONArray getActionsJson() {
		return actionsJson;
	}
}
