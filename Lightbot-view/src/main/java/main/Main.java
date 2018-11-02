package main;

import java.io.IOException;

import controllers.ControllerGames;

public class Main {

	public static void main(String[] args) throws IOException {
		ControllerGames controller = new ControllerGames();
		controller.initGames();
	}

}
