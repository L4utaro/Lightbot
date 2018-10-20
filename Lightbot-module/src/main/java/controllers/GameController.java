package controllers;


import java.util.List;

import commands.invoker.InvokerCommand;
import model.Map;
import modelo.Game;

public class GameController{
	private Game modelo;

	public GameController(Map map, List<InvokerCommand> invokerCommands) {
		//this.modelo = new Modelo(map, invokerCommands);
	}
}
