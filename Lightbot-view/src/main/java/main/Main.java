package main;

import java.io.IOException;

import configuration.Constants;
import controllers.ControllerGames;

public class Main {

	public static void main(String[] args) throws IOException {
		ControllerGames controller = new ControllerGames(Constants.ROUTE_ACTIONS);
		controller.initGames();
	}

}
