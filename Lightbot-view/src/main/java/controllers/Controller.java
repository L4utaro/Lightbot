package controllers;

import java.awt.Event;
import java.io.IOException;

import configuration.Constants;
import modelo.Game;
import views.ViewMap;
import views.ViewMapConsole;

public class Controller {
	private Game gameModelo;
	private ViewMap viewMap;
	private ViewMapConsole viewMapConsole;
	
	public Controller() {
	}
	
	public void initialize() throws IOException {
		this.gameModelo = new Game(Constants.ROUTE_MAP_PROPERTIES, Constants.ROUTE_JSON_ACTIONS_5);
		this.viewMap = new ViewMap();
		this.viewMapConsole = new ViewMapConsole();
		this.gameModelo.addObserver(this.viewMap);
		this.gameModelo.addObserver(this.viewMapConsole);
		this.gameModelo.run();
	}
	
	public void handleEvent(Event e) {
		
	}
	
	public void update() {
		
	}
}
