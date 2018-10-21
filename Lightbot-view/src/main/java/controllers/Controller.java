package controllers;

import java.awt.Event;
import java.io.IOException;

import modelo.Game;
import views.ViewMap;

public class Controller {
	private Game gameModelo;
	private ViewMap viewMap;
	
	public Controller() {
	}
	
	public void initialize() throws IOException {
		this.gameModelo = new Game();
		this.viewMap = new ViewMap();
		this.gameModelo.addObserver(this.viewMap);
		this.gameModelo.run();
	}
	
	public void handleEvent(Event e) {
		
	}
	
	public void update() {
		
	}
}
