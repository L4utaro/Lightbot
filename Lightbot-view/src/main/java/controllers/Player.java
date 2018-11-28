package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import commands.invoker.InvokerCommand;
import enums.StateGame;
import model.Map;
import modelo.Game;
import panels.PanelPlayer;

public class Player implements ActionListener {
	private Game game;
	private PanelPlayer panelPlayer;

	public Player(String namePlayer) {
		this.panelPlayer = new PanelPlayer(namePlayer);
		this.panelPlayer.getBtnPlay().addActionListener(this);
		this.panelPlayer.getBtnStop().addActionListener(this);
		this.panelPlayer.getBtnTimeDown().addActionListener(this);
		this.panelPlayer.getBtnTimeUp().addActionListener(this);
	}

	public void createGame(Map map, List<InvokerCommand> invokersCommands,
			java.util.Map<String, List<InvokerCommand>> functions) {
		this.game = new Game(map, invokersCommands, functions);
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
			this.game.setStateGame(StateGame.PLAY);
		} else if (e.getSource() == this.panelPlayer.getBtnStop()) {
			this.game.setStateGame(StateGame.STOP);
		} else if (e.getSource() == this.panelPlayer.getBtnTimeDown() && this.panelPlayer.getTime() >= 0.2) {
			this.panelPlayer.setTime(this.panelPlayer.getTime() - 0.2);
			this.game.setTimeForInstruction(this.panelPlayer.getTime());
		} else if (e.getSource() == this.panelPlayer.getBtnTimeUp() && this.panelPlayer.getTime() <= 5.0) {
			this.panelPlayer.setTime(this.panelPlayer.getTime() + 0.2);
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
