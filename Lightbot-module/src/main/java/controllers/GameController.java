package controllers;

import java.util.List;

import commands.invoker.InvokerCommand;
import model.Map;
import validators.ValidatorGame;

public class GameController {
	private Map map;
	private ValidatorGame validatorGame;

	public GameController(Map map) {
		this.map = map;
		this.validatorGame = new ValidatorGame(map);
	}

	public void run(List<InvokerCommand> invokersCommands) {
		for (InvokerCommand invokerCommand : invokersCommands) {
			invokerCommand.executeCommand(this.map);
			System.out.println("\n-----\n");
			this.map.printMap();
			if(this.validatorGame.isAvatarIsOutOfPathPossible()) {
				System.out.println("Game Over: The avatar is't out of paht possible");
				throw new IllegalArgumentException("Game Over: The avatar is't out of paht possible");
			}
		}
		if (!this.validatorGame.allLightsAreTurnedOn(this.map)) {
			System.out.println("Game Over: The avatar don't turned on all the lights");
			throw new IllegalArgumentException("Game Over: The avatar don't turned on all the lights");
		} else {
			System.out.println("You win");
		}
	}
}
