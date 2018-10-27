package modelo;

import java.io.IOException;
import java.util.List;
import java.util.Observable;

import commands.invoker.InvokerCommand;
import generators.GameGenerator;
import model.Map;
import validators.ValidatorGame;

public class Game extends Observable{
	private Map map;
	private ValidatorGame validatorGame;
	private String message;
	private	GameGenerator creator;
	private List<InvokerCommand> invokersCommands;
	
	/**default*/
	public Game(){
		try {
			 creator = new GameGenerator();
		} catch (IOException e) {
			message = e.getMessage();
		}
		init();
	}
	
	/**whit map*/
	public Game(String mapRoute){
		try {
			 creator = new GameGenerator(mapRoute);
		} catch (IOException e) {
			message = e.getMessage();
		}
		init();
	}

	/**whit all options*/
	public Game(String mapRoute, String jsonRoute){
		try {
			 creator = new GameGenerator(mapRoute, jsonRoute);
		} catch (IOException e) {
			message = e.getMessage();
		}
		init();
	}
	
	public void init() {
		this.map = creator.getMap();
		this.validatorGame = new ValidatorGame(map);
		this.invokersCommands = creator.getInvokerCommands();
	}
	
	public void run() {
		for (InvokerCommand invokerCommand : this.invokersCommands) {
			invokerCommand.executeCommand(this.map);
			modelChange();
			System.out.println("\n-----\n");
			this.map.printMap();
			if(this.validatorGame.isAvatarIsOutOfPathPossible()) {
				System.out.println("Game Over: The avatar is't out of paht possible");
				throw new IllegalArgumentException("Game Over: The avatar is't out of paht possible");
			}else if (this.validatorGame.allLightsAreTurnedOn(this.map)) {
				System.out.println("You win");
			}
		}
		if (!this.validatorGame.allLightsAreTurnedOn(this.map)) {
			System.out.println("Game Over: The avatar don't turned on all the lights");
			throw new IllegalArgumentException("Game Over: The avatar don't turned on all the lights");
		}
	}

	public void modelChange() {
		setChanged();
		notifyObservers();
	}

	public String getMessage() {
		return message;
	}

	public Map getMap() {
		return map;
	}
}
