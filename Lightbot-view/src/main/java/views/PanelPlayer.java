package views;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Size;
import panels.PanelInstructions;
import panels.PanelMap;
import panels.PanelMapConsole;

public class PanelPlayer implements Observer {
	private JPanel panel;
	private PanelMap panelMap;
	private PanelMapConsole panelMapConsole;
	private PanelInstructions panelInstructions;
	private Size size;
	private String message;
	private JButton btnPlay;
	private JButton btnStop;
	private JButton btnTimeDown;
	private JButton btnTimeUp;
	private JLabel timeOfInstruction;
	private Double time;

	public PanelPlayer() {
		this.panelMap = new PanelMap();
		this.panelMapConsole = new PanelMapConsole();
		this.panelInstructions = new PanelInstructions();
		this.size = new Size(800, 300);
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.panel.setSize(800, 250);

		this.time = 1.5;
		drawTime();
		drawbtns();
		drawBtnTime();
	}

	public void draw() {
		panel.revalidate();
		panel.repaint();
		panel.add(this.panelMap.getPanel());
		panel.add(this.panelMapConsole.getPanel());
		panel.add(this.panelInstructions.getPanel());
		if (this.message != null) {
			JLabel label = new JLabel(this.message);
			label.setBounds(5, 0, 500, 25);
			label.setOpaque(true);
			panel.add(label);
		}
		drawTime();
	}
	
	public void drawTime() {
		this.timeOfInstruction = new JLabel(""+this.time);
		this.timeOfInstruction.setBounds(690, 0, 40, 20);
		this.timeOfInstruction.setBackground(Color.gray);
		panel.add(timeOfInstruction);
	}
	
	public void drawBtnTime() {
		btnTimeDown = new JButton("<");
		btnTimeDown.setBounds(630, 0, 50, 20);
		btnTimeUp = new JButton(">");
		btnTimeUp.setBounds(730, 0, 50, 20);
		panel.add(btnTimeDown);
		panel.add(btnTimeUp);
	}

	public void drawbtns() {
		btnPlay = new JButton("Play");
		btnPlay.setBounds(500, 0, 60, 20);
		btnStop = new JButton("Stop");
		btnStop.setBounds(565, 0, 60, 20);
		panel.add(btnPlay);
		panel.add(btnStop);
	}

	@Override
	public void update(Observable o, Object arg) {
		draw();
	}

	public PanelMap getPanelMap() {
		return panelMap;
	}

	public void setPanelMap(PanelMap panelMap) {
		this.panelMap = panelMap;
	}

	public PanelMapConsole getPanelMapConsole() {
		return panelMapConsole;
	}

	public void setPanelMapConsole(PanelMapConsole panelMapConsole) {
		this.panelMapConsole = panelMapConsole;
	}

	public PanelInstructions getPanelInstructions() {
		return panelInstructions;
	}

	public Size getSize() {
		return size;
	}
	
	public JButton getBtnPlay() {
		return btnPlay;
	}

	public JButton getBtnStop() {
		return btnStop;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public Double getTime() {
		return time;
	}

	public void setTime(Double time) {
		this.time = time;
	}

	public JButton getBtnTimeDown() {
		return btnTimeDown;
	}

	public JButton getBtnTimeUp() {
		return btnTimeUp;
	}
}
