package modelo;

import static org.junit.Assert.assertNotEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import configuration.ConstantsTest;
import generators.GameGenerator;

public class GameTest {
	private Game game;
	private GameGenerator gameGenerator;
	
	@Before
	public void init() throws IOException {
		this.gameGenerator = new GameGenerator(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_1);
		this.game = new Game(this.gameGenerator.getMap(), this.gameGenerator.getInvokerCommands(),null);
	}
	
	@Test
	public void test01() {
		this.game.init();
		this.game.run();
	}
	
	@Test
	public void test02() {
		this.game = new Game(this.gameGenerator.getMap(), this.gameGenerator.getInvokerCommands(),null);
		this.game.init();
		this.game.run();
	}
	
	@Test(expected = IOException.class)
	public void test03() throws IOException {
		this.gameGenerator = new GameGenerator("src/test/java/asda", ConstantsTest.ROUTE_JSON_ACTIONS_1);
		this.game = new Game(this.gameGenerator.getMap(), this.gameGenerator.getInvokerCommands(),null);
		this.game.init();
		this.game.run();
		assertNotEquals("",this.game.getMessage());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test04() throws IOException {
		this.gameGenerator = new GameGenerator(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_INVALID_1);
		this.game = new Game(this.gameGenerator.getMap(), this.gameGenerator.getInvokerCommands(),null);
		this.game.init();
		this.game.run();
	}

	@Test(expected = IllegalArgumentException.class)
	public void test05() throws IOException {
		this.gameGenerator = new GameGenerator(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_TXT_ACTIONS_INVALID_3);
		this.game = new Game(this.gameGenerator.getMap(), this.gameGenerator.getInvokerCommands(),null);
		this.game.init();
		this.game.run();
	}
}
