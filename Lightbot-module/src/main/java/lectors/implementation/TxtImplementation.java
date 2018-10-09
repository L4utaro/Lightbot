package lectors.implementation;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

import commands.CommandLeft;
import commands.CommandLight;
import commands.CommandMove;
import commands.CommandRight;
import commands.interfaces.ICommand;
import lectors.LectorTxt;
import validators.ValidatorTxt;

public class TxtImplementation {
	private LectorTxt lectorTxt;
	private JSONArray actionsJson;
	private ValidatorTxt validatorTxt;
	private List<ICommand> actionsCommand;

	public TxtImplementation(String routeTxt) {
		this.lectorTxt = new LectorTxt(routeTxt);
		this.lectorTxt.readFile();
		this.actionsJson = (JSONArray) this.lectorTxt.getListOfJson("actions");
		this.validatorTxt = new ValidatorTxt();
		this.actionsCommand = new ArrayList<ICommand>();
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
		if (action.equals("move"))
			this.actionsCommand.add(new CommandMove());
		else if (action.equals("left"))
			this.actionsCommand.add(new CommandLeft());
		else if (action.equals("right"))
			this.actionsCommand.add(new CommandRight());
		else if (action.equals("light"))
			this.actionsCommand.add(new CommandLight());
	}

	public List<ICommand> getActionsCommand() {
		return actionsCommand;
	}
}
