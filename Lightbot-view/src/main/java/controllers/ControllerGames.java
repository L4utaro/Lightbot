package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import configuration.Constants;
import generators.GameGenerator;
import lectors.LectorFolder;
import model.Map;
import validators.ValidatorRoutesActions;

public class ControllerGames {
	private LectorFolder lector;
	private ValidatorRoutesActions validatorRoutesActions;
	private List<Player> players;
	private List<String> routesActions;
	private ControllerPlayersView controllerPlayersView;
	private GameGenerator gameGenerator;

	public ControllerGames(String routeFolder) {
		this.lector = new LectorFolder(routeFolder);
		this.validatorRoutesActions = new ValidatorRoutesActions();
		this.controllerPlayersView = new ControllerPlayersView();
	}

	public void initGames() {
		this.routesActions = this.lector.getRoutesOfActions();
		if (this.validatorRoutesActions.areAValidsRoutes(routesActions)) {
			try {
				this.gameGenerator = new GameGenerator(Constants.ROUTE_MAP_PROPERTIES);
			} catch (IOException e) {
				throw new IllegalArgumentException("There don't exists a map, in that route");
			}
			this.players = createPlayers(routesActions);
			try {
				initPlayers();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			this.controllerPlayersView.init(this.players);
		} else {
			throw new IllegalArgumentException("There are invalids files in the folder");
		}
	}

	public List<Player> createPlayers(List<String> routesActions) {
		List<Player> players = new ArrayList<>();
		for (int i = 0; i < routesActions.size(); i++) {
			players.add(new Player(this.lector.getNamesPlayers().get(i)));
		}
		return players;
	}

	public void initPlayers() throws CloneNotSupportedException {
		for (int i = 0; i < this.players.size(); i++) {
			this.players.get(i).createGame((Map) this.gameGenerator.getMap().clone(),
					this.gameGenerator.createActions(routesActions.get(i)), this.gameGenerator.getFunctions());
			this.players.get(i).getPanelPlayer().draw();
			this.players.get(i).getGame().addObserver(this.controllerPlayersView.getPlayersView());
		}
	}

	public void runGames() {
		for (Player player : this.players) {
			player.runGame();
		}
		checkWinner();
	}

	public void checkWinner() {
		int minInstructions = this.players.get(0).getGame().getCantActions();
		String messageWinner = "";
		for (int i = 0; i < this.players.size(); i++) {
			if (minInstructions >= this.players.get(i).getGame().getCantActions()
					&& this.players.get(i).getPanelPlayer().getMessage().equals("You win")) {
				minInstructions = this.players.get(i).getGame().getCantActions();
				//messageWinner = "The winner is player: " + (i + 1);
				messageWinner = "The winner is player: " + this.players.get(i).getPanelPlayer().getNamePlayer();
			}
		}
		this.controllerPlayersView.drawWinner(messageWinner);
	}
}
