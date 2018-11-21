package controllers;

import java.util.ArrayList;
import java.util.List;

import configuration.Constants;
import lectors.LectorFolder;
import validators.ValidatorRoutesActions;

public class ControllerGames {
	private LectorFolder lector;
	private ValidatorRoutesActions validatorRoutesActions;
	private List<Player> players;
	private ControllerPlayersView controllerPlayersView;

	public ControllerGames(String routeFolder) {
		this.lector = new LectorFolder(routeFolder);
		this.validatorRoutesActions = new ValidatorRoutesActions();
		this.controllerPlayersView = new ControllerPlayersView();
	}

	public void initGames() {
		List<String> routesActions = this.lector.getRoutesOfActions();
		if (this.validatorRoutesActions.areAValidsRoutes(routesActions)) {
			this.players = createPlayers(routesActions);
			initPlayers();
			this.controllerPlayersView.init(this.players);
		} else {
			throw new IllegalArgumentException("There are invalids files in the folder");
		}
	}

	public void initPlayers() {
		for (Player player : this.players) {
			player.createGame();
			player.getPanelPlayer().draw();
			player.getGame().addObserver(this.controllerPlayersView.getPlayersView());
		}
	}

	public List<Player> createPlayers(List<String> routesActions) {
		List<Player> players = new ArrayList<>();
		for (int i = 0; i < routesActions.size(); i++) {
			players.add(new Player(Constants.ROUTE_MAP_PROPERTIES, routesActions.get(i)));
		}
		return players;
	}

	public void runGames() {
		for (Player controllerPlayer : this.players) {
			controllerPlayer.runGame();
		}
		checkWinner();
	}
	
	public void checkWinner() {
		int minInstructions = this.players.get(0).getGame().getCantActions();
		String messageWinner = "";
		for(int i = 0; i < this.players.size(); i ++) {
			if(minInstructions >= this.players.get(i).getGame().getCantActions()
					&& this.players.get(i).getPanelPlayer().getMessage().equals("You win")) {
				minInstructions = this.players.get(i).getGame().getCantActions();
				messageWinner = "The winner is player: " + (i + 1);
			}
		}
		this.controllerPlayersView.drawWinner(messageWinner);
	}
}
