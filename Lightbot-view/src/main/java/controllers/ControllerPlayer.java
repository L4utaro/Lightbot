package controllers;

import enums.StateGame;
import model.Player;
import views.ViewPlayer;

public class ControllerPlayer {
	private Player player;
	private ControllerPanelPlayer controllerPlanelPlayer;
	
	public ControllerPlayer(String routeMap, String routeActions) {
		this.player = new Player(routeMap, routeActions);
		this.controllerPlanelPlayer = new ControllerPanelPlayer();
	}
	
	public void createGame() {
		this.player.getGame().addObserver(this.controllerPlanelPlayer.getPanelPlayer());
		this.player.getGame().addObserver(this.controllerPlanelPlayer.getPanelPlayer().getPanelMap());
		this.player.getGame().addObserver(this.controllerPlanelPlayer.getPanelPlayer().getPanelMapConsole());
		this.player.getGame().addObserver(this.controllerPlanelPlayer.getPanelPlayer().getPanelInstructions());
		this.player.getGame().init();
		this.controllerPlanelPlayer.getPanelPlayer().draw();
	}
	
	public void runGame() {
		try {
			this.player.getGame().run();
			System.out.println(this.controllerPlanelPlayer.getStateGame());
		} catch (IllegalArgumentException e) {
			this.controllerPlanelPlayer.getPanelPlayer().setMessage(e.getMessage());
			this.controllerPlanelPlayer.getPanelPlayer().draw();
		}
	}

	public ViewPlayer getViewPlayer() {
		return controllerPlanelPlayer.getPanelPlayer();
	}
}
