package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import enums.StateGame;
import views.ViewPlayer;

public class ControllerPanelPlayer implements ActionListener{
	private ViewPlayer panelPlayer;
	private StateGame stateGame;
	
	public ControllerPanelPlayer() {
		this.stateGame = StateGame.PLAY;
		this.panelPlayer = new ViewPlayer();
		this.panelPlayer.getBtnPlay().addActionListener(this);
		this.panelPlayer.getBtnStop().addActionListener(this);
		//this.panelPlayer.getSlider().addChangeListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.panelPlayer.getBtnPlay()) {
			System.out.println("Apreto Play");
			this.stateGame = StateGame.PLAY;
		} else if (e.getSource() == this.panelPlayer.getBtnStop()) {
			this.stateGame = StateGame.STOP;
			System.out.println("Apreto Stop");
		}
	}

	public ViewPlayer getPanelPlayer() {
		return panelPlayer;
	}

	public StateGame getStateGame() {
		return stateGame;
	}
}
