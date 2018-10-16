package validators;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

import validators.interfaces.IValidator;

public class ValidatorTxt implements IValidator{
	private List<String> instrucctionsValids;

	public ValidatorTxt() {
		this.instrucctionsValids = new ArrayList<String>();
		this.instrucctionsValids.add("move");
		this.instrucctionsValids.add("right");
		this.instrucctionsValids.add("left");
		this.instrucctionsValids.add("light");
	}
	
	public boolean validateInstructionsOfJsonArray(JSONArray actionsJson) {
		for (int i = 0; i < actionsJson.size(); i++) {
			if (!checkInstruction(actionsJson.get(i).toString())) {
				return false;
			}
		}
		return true;
	}

	public boolean checkInstruction(String instruction) {
		return this.instrucctionsValids.contains(instruction);
	}
}
