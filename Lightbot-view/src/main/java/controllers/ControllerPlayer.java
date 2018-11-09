package controllers;

import model.Player;
import views.PanelPlayer;

public class ControllerPlayer {
	private Player player;
	private PanelPlayer viewPlayer;
	
	public ControllerPlayer(String routeMap, String routeActions) {
		this.player = new Player(routeMap, routeActions);
	}
	
	public void createGame() {
		this.viewPlayer = new PanelPlayer();
		this.player.getGame().addObserver(this.viewPlayer);
		this.player.getGame().addObserver(this.viewPlayer.getPanelMap());
		this.player.getGame().addObserver(this.viewPlayer.getPanelMapConsole());
		this.player.getGame().addObserver(this.viewPlayer.getPanelInstructions());
		this.player.getGame().init();
		this.viewPlayer.draw();
	}
	
	public void runGame() {
		try {
			this.player.getGame().run();
		} catch (IllegalArgumentException e) {
			this.viewPlayer.setMessage(e.getMessage());
			this.viewPlayer.draw();
		}
	}

	public PanelPlayer getViewPlayer() {
		return viewPlayer;
	}
}
