package modelo;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import configuration.ConstantsTest;

public class GameTest {
	private Game game;
	
	@Before
	public void init() {
		this.game = new Game();
	}
	
	@Test
	public void test01() {
		this.game.run();
	}
	
	@Test
	public void test02() {
		this.game = new Game(ConstantsTest.ROUTE_MAP_PROPERTIES);
		this.game.run();
	}
	
	@Test
	public void test03() {
		this.game = new Game(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_1);
		this.game.run();
	}
	
	@Test(expected = NullPointerException.class)
	public void test04() {
		this.game = new Game("src/test/java/asda");
		this.game.run();
		assertNotEquals("",this.game.getMessage());
	}
	
	@Test(expected = NullPointerException.class)
	public void test05() {
		this.game = new Game("src/test/java/asda", ConstantsTest.ROUTE_JSON_ACTIONS_1);
		this.game.run();
	}

	@Test(expected = IllegalArgumentException.class)
	public void test06() {
		this.game = new Game(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_INVALID_1);
		this.game.run();
	}

	@Test(expected = IllegalArgumentException.class)
	public void test07() {
		this.game = new Game(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_TXT_ACTIONS_INVALID_3);
		this.game.run();
	}
}
