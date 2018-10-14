package classProperties;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import main.Constants;
import validators.ValidatorProperties;

public class MapProperties {
	private Properties properties;
	private ElectionMap electionMap;
	private ValidatorProperties validatorProperties;

	public MapProperties(String route_properties) {
		this.properties = new Properties();
		loadProperties(route_properties);
		this.validatorProperties = new ValidatorProperties(this.properties);
		validateProperties();
		loadDataProperties();
	}

	public void validateProperties() {
		if(!this.validatorProperties.isAValidProperties()) {
			throw new IllegalArgumentException("the properties no contains all parameters");
		}
	}

	public void loadDataProperties() {
		Point mapSize = getPointOfProperties(Constants.NAME_SIZEMAP_PROPERTIES);
		Point posAvatar = getPointOfProperties(Constants.NAME_POSAVATAR_PROPERTIES);
		List<Point> posLight = loadPositionsOfPoint(Constants.NAME_POSLIGHT_PROPERTIES);
		List<Point> posOfPathPossible = loadPositionsOfPoint(Constants.NAME_PATHPOSSIBLE_PROPERTIES);
		this.electionMap = new ElectionMap(mapSize, posAvatar, posLight, posOfPathPossible);
	}
	
	public List<Point> loadPositionsOfPoint(String parameter) {
		List<Point> posOfPathPossible = new ArrayList<Point>();
		for (int i = 1; i < properties.getProperty(parameter).length() - 2; i++) {
			posOfPathPossible.add(new Point(properties.getProperty(parameter).charAt(i + 1) - '0',
					properties.getProperty(parameter).charAt(i + 3) - '0'));
			i += 6;
		}
		return posOfPathPossible;
	}

	public Point getPointOfProperties(String parameter) {
		return new Point(properties.getProperty(parameter).charAt(1) - '0',
				properties.getProperty(parameter).charAt(3) - '0');
	}

	public void loadProperties(String route_properties) {
		try {
			this.properties.load(new FileReader(route_properties));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ElectionMap getElectionMap() {
		return electionMap;
	}
}
