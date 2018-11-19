package controllers;


import java.util.List;

import views.PanelPlayer;
import views.PlayersView;

public class ControllerPlayersView {
	private PlayersView playersView;
	
	public ControllerPlayersView() {
		this.playersView = new PlayersView();
	}
	
	public void init(List<PanelPlayer> panelsPlayers) {
		this.playersView.addPanelsPlayers(panelsPlayers);
	}
}
