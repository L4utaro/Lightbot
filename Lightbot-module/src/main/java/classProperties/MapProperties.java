package classProperties;

import java.awt.Point;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import configuration.Constants;
import model.Size;
import validators.ValidatorProperties;

public class MapProperties {
	private Properties properties;
	private MapConfiguration mapConfiguration;
	private ValidatorProperties validatorProperties;

	public MapProperties(String route_properties) throws IOException {
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
		Size mapSize = geySizeOfProperties(Constants.NAME_SIZEMAP_PROPERTIES);
		Point posAvatar = getPointOfProperties(Constants.NAME_POSAVATAR_PROPERTIES);
		List<Point> posLight = loadPositionsOfPoint(Constants.NAME_POSLIGHT_PROPERTIES);
		List<Point> posOfPathPossible = loadPositionsOfPoint(Constants.NAME_PATHPOSSIBLE_PROPERTIES);
		this.mapConfiguration = new MapConfiguration(mapSize, posAvatar, posLight, posOfPathPossible);
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

	public Size geySizeOfProperties(String parameter) {
		return new Size(properties.getProperty(parameter).charAt(1) - '0',
				properties.getProperty(parameter).charAt(3) - '0');
	}
	
	public void loadProperties(String route_properties) throws IOException {
		try {
			this.properties.load(new FileReader(route_properties));
		} catch (IOException e) {
			throw new IOException("no se encontro el archivo" + route_properties, e);
		}
	}

	public MapConfiguration getMapConfiguration() {
		return mapConfiguration;
	}
}
