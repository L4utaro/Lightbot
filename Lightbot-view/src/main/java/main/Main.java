package main;

import java.io.IOException;

import controllers.Controller;

public class Main {

	public static void main(String[] args) throws IOException {
		Controller controller = new Controller();
		controller.initialize();
	}

}
