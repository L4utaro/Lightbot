package controllers;

import java.awt.Event;
import java.io.IOException;

import configuration.Constants;
import modelo.Game;
import views.ViewPlayer;

public class Controller {
	private Game gameModelo;
	private ViewPlayer viewPlayer;
	
	public Controller() {
	}
	//primero chequeo cuantos juegos hay, es decir cantidad de archivos en la carpeta ...
	public void initialize() throws IOException {
		this.gameModelo = new Game(Constants.ROUTE_MAP_PROPERTIES, Constants.ROUTE_JSON_ACTIONS_5);
		this.viewPlayer = new ViewPlayer();
		this.gameModelo.addObserver(this.viewPlayer);
		this.gameModelo.addObserver(this.viewPlayer.getViewMap());
		this.gameModelo.addObserver(this.viewPlayer.getViewMapConsole());
		this.gameModelo.init();
		this.viewPlayer.draw();
		this.gameModelo.run();
	}
	
	public void handleEvent(Event e) {
		
	}
	
	public void update() {
		
	}
}
