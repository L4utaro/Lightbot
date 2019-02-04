package commands;

import model.Command;
import model.Map;

public class ExecuteCommand {
	private Command command;

	public ExecuteCommand(Command command) {
		this.command = command;
	}

	public void execute(Map map) {
		if (this.command.getMode().equals("secuencial")) {
			executeModeSecuencial(map);
		} else {
			executeModeAlternativo(map);
		}
	}

	private Object executeModeAlternativo(Map map) {
		//Debo pasar al avatar a la posicion deseada.
		//hay varios casos:
		//1) positions - orientation 
		//2) positions - girar
		return null;
	}

	private Object executeModeSecuencial(Map map) {
		// TODO Auto-generated method stub
		return null;
	}
}
