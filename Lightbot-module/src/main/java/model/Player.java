package model;

import java.util.List;

import commands.invoker.InvokerCommand;
import modelo.Game;

public class Player {
	private Game game;

	public Player(Map map, List<InvokerCommand> invokersCommands,
			java.util.Map<String, List<InvokerCommand>> functions) {
		this.game = new Game(map, invokersCommands, functions);
	}

	public Game getGame() {
		return game;
	}
}
