package model;

import modelo.Game;

public class Player {
	private Game game;

	public Player(String routeMap, String routeActions) {
		this.game = new Game(routeMap, routeActions);
	}

	public Game getGame() {
		return game;
	}
}
