package views;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Size;
import panels.PanelInstructions;
import panels.PanelMap;
import panels.PanelMapConsole;

public class ViewPlayer implements Observer {
	private JFrame frame;
	private JPanel panel;
	private PanelMap panelMap;
	private PanelMapConsole panelMapConsole;
	private PanelInstructions panelInstructions;
	private Size size;

	public ViewPlayer() {
		this.panelMap = new PanelMap();
		this.panelMapConsole = new PanelMapConsole();
		this.frame = new JFrame("Lightbot");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLocationRelativeTo(null);
		this.size = new Size(600, 300);
		this.frame.setSize(600, 300);

		this.panel = new JPanel();
		this.panel.setLayout(null);
		// frame.setSize(this.viewMap.getSize().getHigh(),
		// this.viewMap.getSize().getWidht());
	}

	public void draw() {
		panel.removeAll();
		panel.add(this.panelMap.getPanel());
		panel.add(this.panelMapConsole.getPanel());
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		draw();
	}

	public PanelMap getViewMap() {
		return panelMap;
	}

	public void setViewMap(PanelMap panelMap) {
		this.panelMap = panelMap;
	}

	public PanelMapConsole getViewMapConsole() {
		return panelMapConsole;
	}

	public void setViewMapConsole(PanelMapConsole panelMapConsole) {
		this.panelMapConsole = panelMapConsole;
	}

	public PanelInstructions getPanelInstructions() {
		return panelInstructions;
	}

	public Size getSize() {
		return size;
	}
}
