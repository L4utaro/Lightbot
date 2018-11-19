package controllers;

import java.util.ArrayList;
import java.util.List;

import configuration.Constants;
import lectors.LectorFolder;
import validators.ValidatorRoutesActions;

public class ControllerGames {
	private LectorFolder lector;
	private ValidatorRoutesActions validatorRoutesActions;
	private List<Player> controllerPlayers;
	private ControllerPlayersView controllerPlayersView;
	
	public ControllerGames(String routeFolder) {
		this.lector = new LectorFolder(routeFolder);
		this.validatorRoutesActions = new ValidatorRoutesActions();
		this.controllerPlayersView = new ControllerPlayersView();
	}
	
	public void initGames() {
		List<String> routesActions = this.lector.getRoutesOfActions();
		if (this.validatorRoutesActions.areAValidsRoutes(routesActions)) {
			this.controllerPlayers = createPlayers(routesActions);
			for(Player controllerPlayer: this.controllerPlayers) {
				controllerPlayer.createGame();
				controllerPlayer.getPanelPlayer();
				controllerPlayer.runGame();
			}
		} else {
			throw new IllegalArgumentException("There are invalids files in the folder");
		}
	}
	
	public List<Player> createPlayers(List<String> routesActions) {
		List<Player> players = new ArrayList<>();
		for (String routeAction : routesActions) {
			players.add(new Player(Constants.ROUTE_MAP_PROPERTIES, routeAction));
		}
		return players;
	}
	
	public void runGames() {
		
	}
}
