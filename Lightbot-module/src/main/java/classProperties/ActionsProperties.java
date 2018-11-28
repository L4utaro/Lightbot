package classProperties;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import configuration.Constants;

public class ActionsProperties {
	private Properties properties;
	private ActionsConfiguration actionsConfiguration;

	public ActionsProperties(String route_properties) throws IOException {
		this.properties = new Properties();
		loadProperties(route_properties);
		loadDataProperties();
	}

	public void loadDataProperties() {
		List<String> avanzar = loadActionsOfString(Constants.NAME_AVANZAR_PROPERTIES);
		List<String> derecha = loadActionsOfString(Constants.NAME_DERECHA_PROPERTIES);
		List<String> izquierda = loadActionsOfString(Constants.NAME_IZQUIERDA_PROPERTIES);
		List<String> luz = loadActionsOfString(Constants.NAME_LUZ_PROPERTIES);
		this.actionsConfiguration = new ActionsConfiguration(avanzar, derecha, izquierda, luz);
	}

	public List<String> loadActionsOfString(String parameter) {
		List<String> actionsNames = new ArrayList<String>();
		String string = "{}(), ";
		List<Character> leters = string.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
		String nameAction = "";
		for (int i = 0; i < properties.getProperty(parameter).length(); i++) {
			char leter = properties.getProperty(parameter).charAt(i);
			if (leters.contains(leter)) {
				if (!nameAction.isEmpty()) {
					actionsNames.add(nameAction);
					nameAction = "";
				}
			} else {
				nameAction = nameAction + leter;
			}
		}
		return actionsNames;
	}

	public void loadProperties(String route_properties) throws IOException {
		try {
			this.properties.load(new FileReader(route_properties));
		} catch (IOException e) {
			throw new IOException("no se encontro el archivo" + route_properties, e);
		}
	}

	public ActionsConfiguration getActionsConfiguration() {
		return actionsConfiguration;
	}
}
