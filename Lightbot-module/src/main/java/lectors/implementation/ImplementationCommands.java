package lectors.implementation;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import configuration.Constants;
import enums.Orientation;
import lectors.LectorJson;
import model.Command;
import model.interfaces.ICommand;
import validators.ValidatorCommandJson;

public class ImplementationCommands {
	private List<String> namesCommands;
	private List<ICommand> commands;
	private LectorJson lectorJson;
	private ValidatorCommandJson validatorCommandJson;

	public ImplementationCommands() {
		this.commands = new ArrayList<>();
		this.namesCommands = new ArrayList<>();
		this.validatorCommandJson = new ValidatorCommandJson();
		this.lectorJson = new LectorJson(Constants.ROUTE_COMMANDS);
		this.namesCommands.addAll(this.lectorJson.getNamesOfArrays());
	}

	public void createCommands() {
		for (String nameCommand : namesCommands) {
			this.commands.add(createCommand(nameCommand, this.lectorJson.getObjectJson(nameCommand)));
		}
	}

	private Command createCommand(String nameCommand, JSONObject objectJson) {
		if (!this.validatorCommandJson.thereAreAllTheParametersFine(this.lectorJson, objectJson)) {
			throw new IllegalArgumentException("The parameters of the action are wrong!");
		}
		return new Command(nameCommand, this.lectorJson.getValueFromJSON(objectJson, "mode").toString(),
				createPointsPosition(this.lectorJson.getValueFromJSON(objectJson, "positions")),
				createInteger(this.lectorJson.getValueFromJSON(objectJson, "movePosition")),
				createOrientation(this.lectorJson.getValueFromJSON(objectJson, "orientation")),
				createString(this.lectorJson.getValueFromJSON(objectJson, "turn")),
				createString(this.lectorJson.getValueFromJSON(objectJson, "light")));
	}

	private String createString(Object stringFromJSON) {
		return stringFromJSON == null ? null : stringFromJSON.toString();
	}

	private Integer createInteger(Object stringFromJSON) {
		return stringFromJSON == null ? null : Integer.parseInt(stringFromJSON.toString());
	}

	private List<Point> createPointsPosition(Object object) {
		return object == null ? null : loadPositionsOfPoint((String) object.toString());
	}

	private Orientation createOrientation(Object object) {
		return (object == null || object.toString().isEmpty()) ? null : newOrientation(object);
	}

	private Orientation newOrientation(Object object) {
		String objectString = object.toString().toUpperCase();
		if (objectString.equals("LEFT")) {
			return Orientation.LEFT;
		} else if (objectString.equals("RIGHT")) {
			return Orientation.RIGHT;
		} else if (objectString.equals("RIGHT")) {
			return Orientation.UP;
		}
		return Orientation.DOWN;
	}

	private List<Point> loadPositionsOfPoint(String object) {
		List<String> stringPoint = createStringPoints(object);
		List<Point> positions = new ArrayList<Point>();
		for (String stringP : stringPoint) {
			if (!stringP.isEmpty()) {
				String point[] = stringP.split(",");
				positions.add(new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1])));
			}
		}
		return positions;
	}

	private List<String> createStringPoints(String object) {
		List<String> strings = new ArrayList<>();
		String points[] = object.split("\"");
		for (int i = 0; i < points.length; i++) {
			if (!(points[i].length() == 1)) {
				strings.add(points[i]);
			}
		}
		return strings;
	}

	public List<ICommand> getCommands() {
		return commands;
	}
}
