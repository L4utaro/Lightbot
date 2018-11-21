package views;

import java.awt.Point;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.Player;
import model.Size;

public class PlayersView implements Observer {
	private JFrame frame;
	private JPanel panel;
	private List<Player> players;
	private Size size;

	public PlayersView() {
		this.frame = new JFrame("Lightbot");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLocationRelativeTo(null);
		this.size = new Size(900, 800);
		this.frame.setSize(this.size.getWidht(), this.size.getHigh());
		this.panel = new JPanel();
		this.panel.setLayout(null);
	}

	public void addPanelsPlayers(List<Player> players) {
		this.players = players;
	}
	
	public void draw() {
		for (int i = 0; i < this.players.size(); i++) {
			PanelPlayer panelPlayer = this.players.get(i).getPanelPlayer();
			panelPlayer.getPanel().setLocation(new Point(0 ,250 * i));
			this.panel.add(panelPlayer.getPanel());
		}
		this.frame.add(this.panel);
		this.frame.setVisible(true);
	}

	@Override
	public void update(Observable observable, Object object) {
		draw();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public List<Player> getPanelsPlayers() {
		return players;
	}

	public void setPanelsPlayers(List<Player> players) {
		this.players = players;
	}

	public void drawWinner(String message) {
		JLabel jLabel = new JLabel(message);
		jLabel.setBounds(340,770,150,20);
		this.panel.add(jLabel);
	}
}
