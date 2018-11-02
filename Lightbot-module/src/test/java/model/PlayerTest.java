package model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import configuration.Constants;

public class PlayerTest {
	private Player player;
	
	@Test
	public void test01() {
		this.player = new Player(Constants.ROUTE_MAP_PROPERTIES, Constants.ROUTE_JSON_ACTIONS_1);
		assertNotNull(this.player.getGame());
	}
}
