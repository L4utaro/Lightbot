package validators;

import java.util.ArrayList;

import java.util.List;

import org.json.simple.JSONArray;

import validators.interfaces.IValidatorInstructions;

public class ValidatorTxt implements IValidatorInstructions{
	private List<String> instrucctionsValids;

	public ValidatorTxt() {}
	
	public boolean validateInstructionsOfJsonArray(JSONArray actionsJson, List<String> namesOfFunctions, List<String> namesOfCommands, List<String> namesOfFunctionsDefault) {
		refreshInstructionsValids();
		this.instrucctionsValids.addAll(namesOfCommands);
		if(namesOfFunctions!=null) {
			this.instrucctionsValids.addAll(namesOfFunctions);
		} if(actionsJson==null) {
			return false;
		}
		if(namesOfFunctionsDefault!=null) {
			this.instrucctionsValids.addAll(namesOfFunctionsDefault);
		}
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
	
	public void refreshInstructionsValids() {
		this.instrucctionsValids = new ArrayList<String>();
		this.instrucctionsValids.add("move");
		this.instrucctionsValids.add("right");
		this.instrucctionsValids.add("left");
		this.instrucctionsValids.add("light");
	}
}
