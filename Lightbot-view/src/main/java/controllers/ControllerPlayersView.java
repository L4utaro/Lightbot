package controllers;


import java.util.List;

import views.PlayersView;

public class ControllerPlayersView {
	private PlayersView playersView;
	
	public ControllerPlayersView() {
		this.playersView = new PlayersView();
	}
	
	public void init(List<Player> players) {
		this.playersView.addPanelsPlayers(players);
		this.playersView.draw();
	}

	public PlayersView getPlayersView() {
		return playersView;
	}
	
	public void drawWinner(String message) {
		this.playersView.drawWinner(message);
	}
}
