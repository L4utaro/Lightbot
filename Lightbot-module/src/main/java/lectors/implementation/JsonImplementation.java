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
import validators.ValidatorJson;

public class JsonImplementation {
	private LectorJson lectorJson;
	private JSONArray actionsJson;
	private ValidatorJson validatorJson;
	private List<InvokerCommand> invokerCommands;

	public JsonImplementation(String routeJson) {
		this.lectorJson = new LectorJson(routeJson);
		this.actionsJson = (JSONArray) this.lectorJson.getListOfJson("actions");
		this.validatorJson = new ValidatorJson();
		this.invokerCommands = new ArrayList<InvokerCommand>();
	}

	public void createColecctionOfActions() {
		if (this.validatorJson.validateInstructionsOfJsonArray(this.actionsJson)) {
			for (int i = 0; i < this.actionsJson.size(); i++) {
				addAction(actionsJson.get(i).toString());
			}
		} else {
			throw new IllegalArgumentException("The actions.json contains wrong parameters");
		}
	}

	public void addAction(String action) {
		if (action.equals("avanzar")) {
			this.invokerCommands.add(new InvokerCommand(new CommandMove()));
		} else if (action.equals("izquierda")) {
			this.invokerCommands.add(new InvokerCommand(new CommandLeft()));
		} else if (action.equals("derecha")) {
			this.invokerCommands.add(new InvokerCommand(new CommandRight()));
		} else if (action.equals("luz")) {
			this.invokerCommands.add(new InvokerCommand(new CommandLight()));
		}
	}
	
	public List<InvokerCommand> getInvokerCommands() {
		return invokerCommands;
	}
}
