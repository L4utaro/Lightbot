package generators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import board.CreateMap;
import commands.CommandFunction;
import commands.invoker.InvokerCommand;
import configuration.Constants;
import lectors.implementation.Implementation;


public class GameGenerator {
	private model.Map map;
	private Implementation implementation;
	private List<InvokerCommand> invokerCommands;
	private Map<String, List<InvokerCommand>> functions;
	
	/**default*/
	public GameGenerator() throws IOException {
		this.invokerCommands = new ArrayList<InvokerCommand>();
		createMap(Constants.ROUTE_MAP_PROPERTIES);
		this.implementation = new Implementation(Constants.ROUTE_JSON_ACTIONS_1);
		createActions();
	}

	/**whit map*/
	public GameGenerator(String mapRoute) throws IOException {
		this.invokerCommands = new ArrayList<InvokerCommand>();
		createMap(mapRoute);
		this.implementation = new Implementation(Constants.ROUTE_JSON_ACTIONS_1);
		createActions();
	}

	/**whit all options*/
	public GameGenerator(String mapRoute, String actionsRoute) throws IOException {
		this.invokerCommands = new ArrayList<InvokerCommand>();
		createMap(mapRoute);
		this.implementation = new Implementation(actionsRoute);
		createActions();
	}
	
	public void createMap(String mapRoute) throws IOException {
		CreateMap create = new CreateMap(mapRoute);
		this.map = create.getMap();
	}

	public void createActions() {
		this.invokerCommands = this.implementation.createColecctionOfActions();
		this.functions = this.implementation.getAllFunctions();
		this.invokerCommands = addActionsFromFunctions(invokerCommands, functions);
	}
	
	public List<InvokerCommand> addActionsFromFunctions(List<InvokerCommand> invokerCommands, Map<String, List<InvokerCommand>> functions) {
		List<InvokerCommand> newInvokerCommands = new ArrayList<>();
		System.out.println(invokerCommands.size());
		for(InvokerCommand invokerCommand: invokerCommands) {
			if(invokerCommand.getCommand().getClass().equals(CommandFunction.class)) {
				newInvokerCommands.addAll(functions.get(((CommandFunction) invokerCommand.getCommand()).getNameFunction()));
				System.out.println("ed");
			} else {
				newInvokerCommands.add(invokerCommand);
			}
		}
		System.out.println(newInvokerCommands.size());
		return newInvokerCommands;
	}

	public model.Map getMap() {
		return this.map;
	}

	public List<InvokerCommand> getInvokerCommands() {
		return invokerCommands;
	}

	public Map<String, List<InvokerCommand>> getFunctions() {
		return functions;
	}
}