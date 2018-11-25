package model;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import configuration.ConstantsTest;
import generators.GameGenerator;

public class PlayerTest {
	private Player player;

	@Test
	public void test01() throws IOException {
		GameGenerator gameGenerator = new GameGenerator(ConstantsTest.ROUTE_MAP_PROPERTIES,
				ConstantsTest.ROUTE_JSON_ACTIONS_6);
		this.player = new Player(gameGenerator.getMap(), gameGenerator.getInvokerCommands(), null);
		assertNotNull(this.player.getGame());
	}
}
