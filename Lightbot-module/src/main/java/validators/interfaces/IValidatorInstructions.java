package validators.interfaces;

import java.util.List;

import org.json.simple.JSONArray;

public interface IValidatorInstructions {

	boolean validateInstructionsOfJsonArray(JSONArray actionsJson, List<String> namesOfFunctions, List<String> namesOfFunctionsDefault);

}
