package modelo;

import java.io.IOException;
import java.util.List;
import java.util.Observable;

import commands.invoker.InvokerCommand;
import enums.StateGame;
import generators.GameGenerator;
import model.Map;
import validators.ValidatorGame;

public class Game extends Observable{
	private Map map;
	private ValidatorGame validatorGame;
	private String message;
	private	GameGenerator creator;
	private List<InvokerCommand> invokersCommands;
	private StateGame stateGame;
	//private Thread thread;
	
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
		this.stateGame = StateGame.PLAY;
		modelChange();
	}
	
	public void run() {
		//for (InvokerCommand invokerCommand : this.invokersCommands) {
		int i = 0;
		while (!this.stateGame.equals(StateGame.FINISH)) {
			while(this.stateGame.equals(StateGame.PLAY)) {
				this.invokersCommands.get(i).executeCommand(this.map);
				checkStatusGame();
				modelChange();
				i++;
				if(i == this.invokersCommands.size()) {
					setStateGame(StateGame.FINISH);
				}
			}
			while(this.stateGame.equals(StateGame.STOP)) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
			}
		}
		if (!this.validatorGame.allLightsAreTurnedOn(this.map)) {
			message = "Game Over: The avatar don't turned on all the lights";
			throw new IllegalArgumentException("Game Over: The avatar don't turned on all the lights");
		}
		modelChange();
	}

	public void checkStatusGame() {
		if(this.validatorGame.isAvatarIsOutOfPathPossible()) {
			message = "Game Over: The avatar is't out of paht possible";
			throw new IllegalArgumentException("Game Over: The avatar is't out of paht possible");
		}else if (this.validatorGame.allLightsAreTurnedOn(this.map)) {
			message = "You win";
		}
	}

	public void modelChange() {
		setChanged();
		notifyObservers();
	}

	public List<InvokerCommand> getInvokersCommands() {
		return invokersCommands;
	}

	public Map getMap() {
		return this.map;
	}
	
	public String getMessage() {
		return message;
	}

	public void setStateGame(StateGame stateGame) {
		this.stateGame = stateGame;
	}

	public void setTimeForInstruction(Double timeOfSleep) {
		for (InvokerCommand invokerCommand: this.invokersCommands) {
			invokerCommand.setTimeOfSleep(timeOfSleep);
		}
	}
}
