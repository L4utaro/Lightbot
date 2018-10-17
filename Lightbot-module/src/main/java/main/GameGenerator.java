package main;

import java.util.ArrayList;
import java.util.List;

import board.CreateMap;
import commands.invoker.InvokerCommand;
import controllers.GameController;
import lectors.implementation.JsonImplementation;
import lectors.implementation.TxtImplementation;
import model.Map;

public class GameGenerator {
	private Map map;
	private JsonImplementation jsonImplementation;
	private TxtImplementation txtImplementation;
	private GameController gameController;
	private List<InvokerCommand> invokerCommands;

	public GameGenerator() {
		this.invokerCommands = new ArrayList<InvokerCommand>();
	}

	public void createMap(String mapRoute) {
		CreateMap create = new CreateMap(mapRoute);
		this.map = create.getMap();
		this.map.getBoard().printBoard();
	}

	public void createActionsByJson(String jsonRoute) {
		this.jsonImplementation = new JsonImplementation(jsonRoute);
		this.jsonImplementation.createColecctionOfActions();
		this.invokerCommands = this.jsonImplementation.getInvokerCommands();
	}

	public void createActionsByTxt(String txtRoute) {
		this.txtImplementation = new TxtImplementation(txtRoute);
		this.txtImplementation.createColecctionOfActions();
		this.invokerCommands = this.txtImplementation.getInvokerCommands();
	}

	public void runActions() {
		this.gameController = new GameController(this.map);
		this.gameController.run(this.invokerCommands);
	}

	public Map getMap() {
		return map;
	}

	public List<InvokerCommand> getInvokerCommands() {
		return invokerCommands;
	}
}