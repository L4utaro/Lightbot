package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import enums.StateGame;
import modelo.Game;
import views.ViewPlayer;

public class Player implements ActionListener {
	private Game game;
	private ViewPlayer panelPlayer;

	public Player(String routeMap, String routeActions) {
		this.game = new Game(routeMap, routeActions);
		this.panelPlayer = new ViewPlayer();
		this.panelPlayer.getBtnPlay().addActionListener(this);
		this.panelPlayer.getBtnStop().addActionListener(this);
	}

	public void createGame() {
		this.game.addObserver(this.panelPlayer);
		this.game.addObserver(this.panelPlayer.getPanelMap());
		this.game.addObserver(this.panelPlayer.getPanelMapConsole());
		this.game.addObserver(this.panelPlayer.getPanelInstructions());
		this.game.init();
		this.panelPlayer.draw();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.panelPlayer.getBtnPlay()) {
			System.out.println("Apreto Play");
			this.game.setStateGame(StateGame.PLAY);
		} else if (e.getSource() == this.panelPlayer.getBtnStop()) {
			this.game.setStateGame(StateGame.STOP);
			System.out.println("Apreto Stop");
		}
		this.game.setTimeForInstruction(this.panelPlayer.getSlider().getValue());
	}

	public void runGame() {
		try {
			this.game.run();
		} catch (IllegalArgumentException e) {
			this.panelPlayer.setMessage(e.getMessage());
			this.panelPlayer.draw();
		}
	}

	public ViewPlayer getViewPlayer() {
		return panelPlayer;
	}
}
