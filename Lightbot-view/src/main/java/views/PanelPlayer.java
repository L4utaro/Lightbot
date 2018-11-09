package views;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Size;
import panels.PanelInstructions;
import panels.PanelMap;
import panels.PanelMapConsole;

public class PanelPlayer implements Observer {
	private JFrame frame;
	private JPanel panel;
	private PanelMap panelMap;
	private PanelMapConsole panelMapConsole;
	private PanelInstructions panelInstructions;
	private Size size;
	private String message;
	
	public PanelPlayer() {
		this.panelMap = new PanelMap();
		this.panelMapConsole = new PanelMapConsole();
		this.panelInstructions = new PanelInstructions();
		this.frame = new JFrame("Lightbot");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLocationRelativeTo(null);
		this.size = new Size(800, 300);
		this.frame.setSize(800, 300);

		this.panel = new JPanel();
		this.panel.setLayout(null);
		// frame.setSize(this.viewMap.getSize().getHigh(),
		// this.viewMap.getSize().getWidht());
	}

	public void draw() {
		panel.removeAll();
		panel.add(this.panelMap.getPanel());
		panel.add(this.panelMapConsole.getPanel());
		panel.add(this.panelInstructions.getPanel());
		frame.setLocationRelativeTo(null);
		if(this.message != null) {
			panel.removeAll();
			panel.add(this.panelInstructions.getPanel());
			JLabel label = new JLabel(this.message);
			label.setBounds(0, 0, 500, 50);
			label.setOpaque(true);
			panel.add(label);
		}
		frame.add(panel);
		frame.setVisible(true);
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

	public JPanel getPanel() {
		return panel;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
