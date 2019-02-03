package validators;

import org.json.simple.JSONObject;

import lectors.LectorJson;

public class ValidatorCommandJson {
	private LectorJson lectorJson;
	private JSONObject objectJson;

	public ValidatorCommandJson() {
	}

	public boolean thereAreAllTheParametersFine(LectorJson lectorJson, JSONObject objectJson) {
		this.lectorJson = lectorJson;
		this.objectJson = objectJson;
		System.out.println();
		return checkMode() && checkPositions() && checkOrientation() && checkLight();
	}

	private boolean checkLight() {
		Object object = this.lectorJson.getValueFromJSON(objectJson, "light");
		return object == null || (object.toString().toUpperCase().equals("ON-OFF")
				|| object.toString().toUpperCase().equals("OFF") || object.toString().toUpperCase().equals("ON"));
	}

	private boolean checkOrientation() {
		Object object = this.lectorJson.getValueFromJSON(objectJson, "orientation");
		if (object != null) {
			String orientation = object.toString().toUpperCase();
			return orientation.isEmpty() || orientation.equals("LEFT") || orientation.equals("RIGHT")
					|| orientation.equals("UP") || orientation.equals("DOWN");
		} else {
			String valueTurn = this.lectorJson.getValueFromJSON(objectJson, "turn").toString().toUpperCase();
			return valueTurn.equals("LEFT") || valueTurn.equals("RIGHT") || valueTurn.equals("UP")
					|| valueTurn.equals("DOWN");
		}
	}

	private boolean checkPositions() {
		Object object = this.lectorJson.getValueFromJSON(objectJson, "positions");
		if (object != null) {
			return object.toString().matches("^[0-9,\\-\"\\]\\[]+$");
		} else {
			String value = this.lectorJson.getValueFromJSON(objectJson, "movePosition").toString();
			return value.matches("^[0-9]+$");
		}
	}

	private boolean checkMode() {
		String mode = this.lectorJson.getValueFromJSON(this.objectJson, "mode").toString();
		return mode.toUpperCase().equals("SECUENCIAL") || mode.toUpperCase().equals("ALTERNATIVO");
	}

}
