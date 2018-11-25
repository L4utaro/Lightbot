package classProperties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class RoutesProperties {
	private Properties properties;
	private RoutesConfiguration routesConfiguration;

	public RoutesProperties(String route_properties) throws IOException {
		this.properties = new Properties();
		loadProperties(route_properties);
		loadDataProperties();
	}

	public void loadDataProperties() {
		String routeFolderActions = this.properties.getProperty("routeFolderActions");
		routesConfiguration = new RoutesConfiguration(routeFolderActions);
	}

	public void loadProperties(String route_properties) throws IOException {
		try {
			this.properties.load(new FileReader(route_properties));
		} catch (IOException e) {
			throw new IOException("no se encontro el archivo" + route_properties, e);
		}
	}

	public RoutesConfiguration getRoutesConfiguration() {
		return routesConfiguration;
	}
}
