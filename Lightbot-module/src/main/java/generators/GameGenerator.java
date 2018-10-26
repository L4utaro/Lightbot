package generators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import board.CreateMap;
import commands.invoker.InvokerCommand;
import configuration.Constants;
import lectors.implementation.JsonImplementation;
import lectors.implementation.TxtImplementation;
import lectors.interfaces.IImplementation;
import model.Map;

public class GameGenerator {
	private Map map;
	private IImplementation implementation;
	private List<InvokerCommand> invokerCommands;

	/**default*/
	public GameGenerator() throws IOException {
		this.invokerCommands = new ArrayList<InvokerCommand>();
		createMap(Constants.ROUTE_MAP_PROPERTIES);
		this.implementation = new JsonImplementation(Constants.ROUTE_JSON_ACTIONS_1);
		createActions();
	}

	/**whit map*/
	public GameGenerator(String mapRoute) throws IOException {
		this.invokerCommands = new ArrayList<InvokerCommand>();
		createMap(mapRoute);
		this.implementation = new JsonImplementation(Constants.ROUTE_JSON_ACTIONS_1);
		createActions();
	}

	/**whit all options*/
	public GameGenerator(String mapRoute, String actionsRoute) throws IOException {
		this.invokerCommands = new ArrayList<InvokerCommand>();
		createMap(mapRoute);
		if(actionsRoute.charAt(actionsRoute.length()-1) == 'n') {
			this.implementation = new JsonImplementation(actionsRoute);
		} else {
			this.implementation = new TxtImplementation(actionsRoute);
		}
		createActions();
	}
	
	public void createMap(String mapRoute) throws IOException {
		CreateMap create = new CreateMap(mapRoute);
		this.map = create.getMap();
	}

	public void createActions() {
		this.implementation.createMapFunction();
		this.invokerCommands = this.implementation.getInvokerCommands();
	}

	public Map getMap() {
		return map;
	}

	public List<InvokerCommand> getInvokerCommands() {
		return invokerCommands;
	}
}