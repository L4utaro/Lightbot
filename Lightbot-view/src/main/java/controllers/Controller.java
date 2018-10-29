package controllers;

import java.awt.Event;
import java.io.IOException;

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
		this.gameModelo = new Game();
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
