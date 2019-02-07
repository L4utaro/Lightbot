package commands;

import gameMode.ModeAlternativo;
import gameMode.ModeSecuencial;
import gameMode.interfaces.Mode;
import model.Command;
import model.Map;

public class ExecuteCommand {
	private Command command;
	private Mode mode;
	
	public ExecuteCommand(Command command) {
		this.command = command;
	}

	public void execute(Map map) {
		if (this.command.getMode().equals("secuencial")) {
			mode = new ModeSecuencial(this.command, map);
		} else {
			mode = new ModeAlternativo(this.command, map);
		}
		mode.changePosition();
		mode.changeOrientation();
		mode.changeLight();
	}
}
