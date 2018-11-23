package main;

import java.io.IOException;

import classProperties.RoutesProperties;
import configuration.Constants;
import controllers.ControllerGames;

public class Main {

	public static void main(String[] args) throws IOException {
		RoutesProperties routeProperties = new RoutesProperties(Constants.ROUTE_ROUTES_CONFIGURATION_PROPERTIES);
		ControllerGames controller = new ControllerGames(routeProperties.getRoutesConfiguration().getRouteFolderOfActions());
		controller.initGames();
		controller.runGames();
	}
}
