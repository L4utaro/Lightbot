package panels;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import commands.invoker.InvokerCommand;
import model.Size;
import modelo.Game;

public class PanelInstructions implements Observer {
	private List<InvokerCommand> invokersCommands;
	private JPanel panel;
	private Size size;

	public PanelInstructions() {
		this.panel = new JPanel();
		this.size = new Size(250, 300);
		panel.setSize(this.size.getWidht(), this.size.getHigh());
		panel.setLocation(new Point(500, 0));
	}

	public void draw() {
		panel.removeAll();
		drawInstructions(getStringOfCommands());
	}

	public List<String> getStringOfCommands() {
		List<String> mapString = new ArrayList<>();
		String newString = "";
		for (int i = 0; i < this.invokersCommands.size(); i++) {
			newString = newString + "[" + this.invokersCommands.get(i).getCommand().getClass().getSimpleName() + "], ";
			if (i % 2 == 0) {
				mapString.add(newString);
				newString = "";
			}
		}
		return mapString;
	}

	public void drawInstructions(List<String> mapString) {
		panel.removeAll();
		for (int i = 0; i < mapString.size(); i++) {
			JLabel label = new JLabel(mapString.get(i));
			label.setBounds(0, 0, 60, 200);
			label.setOpaque(true);
			panel.add(label);
		}
	}

	@Override
	public void update(Observable observable, Object object) {
		this.invokersCommands = ((Game) observable).getInvokersCommands();
		draw();
	}

	public JPanel getPanel() {
		return panel;
	}
}
