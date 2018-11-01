package panels;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import commands.invoker.InvokerCommand;
import modelo.Game;

public class PanelInstructions implements Observer{
	private List<InvokerCommand> invokersCommands;
	private JPanel panel;
	
	public PanelInstructions() {
		this.panel = new JPanel();
	}
	
	public void draw() {
		JLabel label = new JLabel(getStringOfCommands());
	}
	
	public String getStringOfCommands() {
		String newString = "";
		for(InvokerCommand invokerCommand: this.invokersCommands) {
			
		}
		return newString;
	}
	@Override
	public void update(Observable observable, Object object) {
		this.invokersCommands = ((Game) observable).getInvokersCommands();
		draw();
	}

}
