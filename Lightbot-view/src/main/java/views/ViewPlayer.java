package views;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

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
	private String message;
	private JButton btnPlay;
	private JButton btnStop;
	private JSlider slider;

	public ViewPlayer() {
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
		drawbtns();
		drawJslider();
	}

	public void draw() {
		panel.add(this.panelMap.getPanel());
		panel.add(this.panelMapConsole.getPanel());
		panel.add(this.panelInstructions.getPanel());
		if (this.message != null) {
			JLabel label = new JLabel(this.message);
			label.setBounds(5, 0, 500, 25);
			label.setOpaque(true);
			panel.add(label);
		}
		frame.add(panel);
		frame.setVisible(true);
	}

	public void drawJslider() {
		slider = new JSlider(0, 3, 1);
		slider.setBounds(630, 0, 120, 20);
		panel.add(slider);
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

	public void setMessage(String message) {
		this.message = message;
	}

	public JButton getBtnPlay() {
		return btnPlay;
	}

	public JButton getBtnStop() {
		return btnStop;
	}

	public JSlider getSlider() {
		return slider;
	}
}
