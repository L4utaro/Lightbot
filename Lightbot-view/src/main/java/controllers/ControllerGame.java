package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import enums.StateGame;
import model.Player;
import views.ViewPlayer;

public class ControllerGame implements ActionListener{
	private ViewPlayer panelPlayer;
	private Player player;
	
	public ControllerGame(String routeMap, String routeActions) {
		this.panelPlayer = new ViewPlayer();
		this.panelPlayer.getBtnPlay().addActionListener(this);
		this.panelPlayer.getBtnStop().addActionListener(this);
		this.player = new Player(routeMap, routeActions);
		//this.panelPlayer.getSlider().addChangeListener(this);
	}
	
	public void createGame() {
		this.player.getGame().addObserver(this.panelPlayer);
		this.player.getGame().addObserver(this.panelPlayer.getPanelMap());
		this.player.getGame().addObserver(this.panelPlayer.getPanelMapConsole());
		this.player.getGame().addObserver(this.panelPlayer.getPanelInstructions());
		this.player.getGame().init();
		this.panelPlayer.draw();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.panelPlayer.getBtnPlay()) {
			System.out.println("Apreto Play");
			this.player.getGame().setStateGame(StateGame.PLAY);
		} else if (e.getSource() == this.panelPlayer.getBtnStop()) {
			this.player.getGame().setStateGame(StateGame.STOP);
			System.out.println("Apreto Stop");
		}
	}
	
	public void runGame() {
		try {
			this.player.getGame().run();
		} catch (IllegalArgumentException e) {
			this.panelPlayer.setMessage(e.getMessage());
			this.panelPlayer.draw();
		}
	}
	
	public ViewPlayer getPanelPlayer() {
		return panelPlayer;
	}
}
