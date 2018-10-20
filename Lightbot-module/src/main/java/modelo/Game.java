package modelo;

import java.io.IOException;
import java.util.List;
import java.util.Observable;

import commands.invoker.InvokerCommand;
import configuration.Constants;
import main.GameGenerator;
import model.Map;
import validators.ValidatorGame;

public class Game extends Observable{
	private Map map;
	private ValidatorGame validatorGame;
	private String message;
	
	public Game(){
		GameGenerator creator = new GameGenerator();
		try {
			creator.createMap(Constants.ROUTE_MAP_PROPERTIES);
		} catch (IOException e) {
			message = e.getMessage();
		}
		creator.createActionsByJson(Constants.ROUTE_JSON_ACTIONS_1);
		this.map = creator.getMap();
		this.validatorGame = new ValidatorGame(map);
		run(creator.getInvokerCommands());
	}
	
	public void run(List<InvokerCommand> invokersCommands) {
		for (InvokerCommand invokerCommand : invokersCommands) {
			invokerCommand.executeCommand(this.map);
			modelChange();
			System.out.println("\n-----\n");
			this.map.printMap();
			if(this.validatorGame.isAvatarIsOutOfPathPossible()) {
				System.out.println("Game Over: The avatar is't out of paht possible");
				throw new IllegalArgumentException("Game Over: The avatar is't out of paht possible");
			}else if (!this.validatorGame.allLightsAreTurnedOn(this.map)) {
				System.out.println("You win");
			}
		}
		if (!this.validatorGame.allLightsAreTurnedOn(this.map)) {
			System.out.println("Game Over: The avatar don't turned on all the lights");
			throw new IllegalArgumentException("Game Over: The avatar don't turned on all the lights");
		} else {
			System.out.println("You win");
		}
	}

	public void modelChange() {
		setChanged();
		notifyObservers();
	}

	public String getMessage() {
		return message;
	}
}
