package modelo;

import java.util.List;
import java.util.Observable;

import commands.invoker.InvokerCommand;
import enums.StateGame;
import model.Map;
import validators.ValidatorGame;

public class Game extends Observable{
	private Map map;
	private ValidatorGame validatorGame;
	private String message;
	private List<InvokerCommand> invokersCommands;
	private StateGame stateGame;
	private java.util.Map<String, List<InvokerCommand>> functions;
	
	public Game(Map map, List<InvokerCommand> invokersCommands, java.util.Map<String, List<InvokerCommand>> functions) {
		this.map = map;
		this.invokersCommands = invokersCommands;
		this.functions = functions;
	}

	public void init() {
		this.validatorGame = new ValidatorGame(map);
		this.stateGame = StateGame.PLAY;
		modelChange();
	}
	
	public void run() {
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
	
	public java.util.Map<String, List<InvokerCommand>> getFunctions() {
		return this.functions;
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
	
	public int getCantActions() {
		return this.functions.get("actions").size();
	}
}
