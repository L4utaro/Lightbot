package lectors.implementation;

import java.util.ArrayList;
import java.util.List;

import configuration.Constants;
import lectors.LectorJson;
import model.Command;

public class ImplementationCommands {
	private List<String> namesCommands;
	private List<Command> commands;
	private LectorJson lectorJson;

	public ImplementationCommands() {
		this.commands = new ArrayList<>();
		this.namesCommands = new ArrayList<>();
		this.lectorJson = new LectorJson(Constants.ROUTE_COMMANDS);
		this.namesCommands.addAll(this.lectorJson.getNamesOfArrays());
	}
	
	//leo las acciones una por una, entonces tengo que recorrer cada array de commmands
	public void createCommands() {
		//recorrrer los nombers y crear comando por comando
		System.out.println("COMANDOS");
		System.out.println(this.lectorJson.getListOfJson("commands"));
	}
}
