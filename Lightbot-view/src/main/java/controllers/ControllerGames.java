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
	
	public ControllerGames(String routeFolder) {
		this.lector = new LectorFolder(routeFolder);
		this.validatorRoutesActions = new ValidatorRoutesActions();
	}
	
	public void initGames() {
		List<String> routesActions = this.lector.getRoutesOfActions();
		if (this.validatorRoutesActions.areAValidsRoutes(routesActions)) {
			this.controllerPlayers = createPlayers(routesActions);
			for(Player controllerPlayer: this.controllerPlayers) {
				controllerPlayer.createGame();
				controllerPlayer.getViewPlayer();
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
