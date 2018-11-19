package views;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Size;

public class PlayersView implements Observer {
	private JFrame frame;
	private JPanel panel;
	private List<PanelPlayer> panelsPlayers;
	private Size size;

	public PlayersView() {
		this.frame = new JFrame("Lightbot");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLocationRelativeTo(null);
		this.size = new Size(800, 900);
		this.frame.setSize(this.size.getWidht(), this.size.getHigh());
		this.panel = new JPanel();
		this.panel.setLayout(null);
	}

	public void addPanelsPlayers(List<PanelPlayer> panelsPlayers) {
		this.panelsPlayers = panelsPlayers;
	}
	
	public void draw() {
		this.panel.removeAll();
		for (int i = 0; i < this.panelsPlayers.size(); i++) {
			this.panel.add(this.panelsPlayers.get(i).getPanel());
		}
		this.frame.add(this.panel);
		this.frame.setVisible(true);
	}

	@Override
	public void update(Observable observable, Object object) {
		draw();
	}
}
