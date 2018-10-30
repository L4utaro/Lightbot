package validators;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

import validators.interfaces.IValidatorInstructions;

public class ValidatorJson implements IValidatorInstructions {
	private List<String> instrucctionsValids;

	public ValidatorJson() {
		this.instrucctionsValids = new ArrayList<String>();
		this.instrucctionsValids.add("avanzar");
		this.instrucctionsValids.add("derecha");
		this.instrucctionsValids.add("izquierda");
		this.instrucctionsValids.add("luz");
	}

	public boolean validateInstructionsOfJsonArray(JSONArray actionsJson, List<String> namesOfFunctions) {
		if(namesOfFunctions!=null) {
			this.instrucctionsValids.addAll(namesOfFunctions);
		} if(actionsJson==null) {
			return false;
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
}