package panels;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import commands.CommandFunction;
import commands.interfaces.ICommand;
import commands.invoker.InvokerCommand;
import model.Size;
import modelo.Game;

public class PanelInstructions implements Observer {
	private java.util.Map<String, List<InvokerCommand>> functions;
	private JPanel panel;
	private Size size;

	public PanelInstructions() {
		this.panel = new JPanel();
		this.size = new Size(680, 250);
		panel.setSize(this.size.getHigh(), this.size.getWidht());
		panel.setLocation(new Point(500, 20));
	}

	public void draw() {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
		drawFunctions();
	}

	public List<String> getStringOfCommands(List<InvokerCommand> invokersCommands) {
		List<String> mapString = new ArrayList<>();
		String newString = "{";
		for (int i = 0; i < invokersCommands.size(); i++) {
			if(i == 0) {
				newString = newString + " [" + getNameOfAction(invokersCommands.get(i).getCommand()) + "]";
			}
			newString = newString + ", [" + getNameOfAction(invokersCommands.get(i).getCommand()) + "]";
			if(i+1 == invokersCommands.size()) {
				newString = newString + "} ";
			}
			mapString.add(newString);
			newString = "";
		}
		return mapString;
	}

	private String getNameOfAction(ICommand command) {
		if(command.getClass().getSimpleName().equals("CommandMove")) {
			return "Avanzar";
		} else if(command.getClass().getSimpleName().equals("CommandLeft")) {
			return "Izquierda";
		} else if(command.getClass().getSimpleName().equals("CommandRight")) {
			return "Derecha";
		} else if(command.getClass().getSimpleName().equals("CommandLight")) {
			return "luz";
		}
		return ((CommandFunction) command).getNameFunction();
	}

	public void drawInstructions(List<String> mapString) {
		for (int i = 0; i < mapString.size(); i++) {
			drawInstruction(mapString.get(i));
		}
	}

	public void drawInstruction(String value) {
		JLabel label = new JLabel(value);
		label.setBounds(0, 0, 60, 200);
		label.setOpaque(true);
		panel.add(label);
	}
	
	public void drawFunctions() {
		List<String> namesFunctions = new ArrayList<>();
		namesFunctions.addAll(this.functions.keySet());
		for(int i = 0; i < namesFunctions.size(); i ++) {
			drawInstruction(namesFunctions.get(i)+ ":");
			drawInstructions(getStringOfCommands(this.functions.get(namesFunctions.get(i))));
		}
	}
	
	@Override
	public void update(Observable observable, Object object) {
		//this.invokersCommands = ((Game) observable).getInvokersCommands();
		this.functions = ((Game) observable).getFunctions(); 
		draw();
	}

	public JPanel getPanel() {
		return panel;
	}
}
