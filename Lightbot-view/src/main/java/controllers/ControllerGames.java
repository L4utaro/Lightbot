package controllers;

import java.util.ArrayList;
import java.util.List;

import configuration.Constants;
import lectors.LectorFolder;
import validators.ValidatorRoutesActions;

public class ControllerGames {
	private LectorFolder lector;
	private ValidatorRoutesActions validatorRoutesActions;
	private List<ControllerPlayer> controllerPlayers;
	
	public ControllerGames() {
		this.lector = new LectorFolder(Constants.ROUTE_ACTIONS);
		this.validatorRoutesActions = new ValidatorRoutesActions();
	}
	
	public void initGames() {
		List<String> routesActions = this.lector.getRoutesOfActions();
		if (this.validatorRoutesActions.areAValidsRoutes(routesActions)) {
			this.controllerPlayers = createPlayers(routesActions);
			for(ControllerPlayer controllerPlayer: this.controllerPlayers) {
				controllerPlayer.createGame();
				controllerPlayer.runGame();
			}
		} else {
			throw new IllegalArgumentException("There are invalids files in the folder");
		}
	}
	
	public List<ControllerPlayer> createPlayers(List<String> routesActions) {
		List<ControllerPlayer> players = new ArrayList<>();
		for (String routeAction : routesActions) {
			players.add(new ControllerPlayer(Constants.ROUTE_MAP_PROPERTIES, routeAction));
		}
		return players;
	}
	
	public void runGames() {
		
	}
}
