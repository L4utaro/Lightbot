package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import enums.StateGame;
import modelo.Game;
import panels.PanelPlayer;

public class Player implements ActionListener {
	private Game game;
	private PanelPlayer panelPlayer;

	public Player(String routeMap, String routeActions) {
		this.game = new Game(routeMap, routeActions);
		this.panelPlayer = new PanelPlayer();
		this.panelPlayer.getBtnPlay().addActionListener(this);
		this.panelPlayer.getBtnStop().addActionListener(this);
		this.panelPlayer.getBtnTimeDown().addActionListener(this);
		this.panelPlayer.getBtnTimeUp().addActionListener(this);
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
		} else if (e.getSource() == this.panelPlayer.getBtnTimeDown()
				&& this.panelPlayer.getTime()>=0.2) {
			this.panelPlayer.setTime(this.panelPlayer.getTime() - 0.2);
			System.out.println(this.panelPlayer.getTime());
			this.game.setTimeForInstruction(this.panelPlayer.getTime());
		} else if (e.getSource() == this.panelPlayer.getBtnTimeUp()) {
			this.panelPlayer.setTime(this.panelPlayer.getTime() + 0.2);
			System.out.println(this.panelPlayer.getTime());
			this.game.setTimeForInstruction(this.panelPlayer.getTime());
		}
	}

	public void runGame() {
		try {
			this.game.run();
			this.panelPlayer.setMessage("You win");
			this.panelPlayer.draw();
		} catch (IllegalArgumentException e) {
			this.panelPlayer.setMessage(e.getMessage());
			this.panelPlayer.draw();
		}
	}

	public PanelPlayer getPanelPlayer() {
		return panelPlayer;
	}

	public Game getGame() {
		return game;
	}
}
