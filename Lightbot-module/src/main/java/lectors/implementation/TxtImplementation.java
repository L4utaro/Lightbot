package lectors.implementation;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

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

	public TxtImplementation(String routeTxt) {
		this.lectorTxt = new LectorTxt(routeTxt);
		this.lectorTxt.readFile();
		this.actionsJson = (JSONArray) this.lectorTxt.getListOfJson("actions");
		this.validatorTxt = new ValidatorTxt();
		this.invokerCommands = new ArrayList<InvokerCommand>();
	}

	public void createColecctionOfActions() {
		if (this.validatorTxt.validateInstructionsOfJsonArray(this.actionsJson)) {
			for (int i = 0; i < this.actionsJson.size(); i++) {
				addAction(actionsJson.get(i).toString());
			}
		} else {
			throw new IllegalArgumentException("The actions.txt contains wrong parameters");
		}
	}

	public void addAction(String action) {
		if (action.equals("move")) {
			this.invokerCommands.add(new InvokerCommand(new CommandMove()));
		} else if (action.equals("left")) {
			this.invokerCommands.add(new InvokerCommand(new CommandLeft()));
		} else if (action.equals("right")) {
			this.invokerCommands.add(new InvokerCommand(new CommandRight()));
		} else if (action.equals("light")) {
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
