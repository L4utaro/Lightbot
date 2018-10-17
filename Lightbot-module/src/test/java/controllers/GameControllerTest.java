package controllers;

import org.junit.Before;
import org.junit.Test;

import main.Constants;
import main.GameGenerator;

public class GameControllerTest {
	private GameController gameController;
	private GameGenerator creator;
	
	@Before
	public void init() {
		this.creator = new GameGenerator();
		this.creator.createMap(Constants.ROUTE_MAP_PROPERTIES);
		this.creator.createActionsByJson(Constants.ROUTE_JSON_ACTIONS_1);
		this.gameController = new GameController(creator.getMap());
	}
	
	@Test
	public void youWinTest01() {
		this.gameController.run(this.creator.getInvokerCommands());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void gameOverAvatarPositionTest02() {
		this.creator.createMap(Constants.ROUTE_MAP_PROPERTIES);
		this.creator.createActionsByJson(Constants.ROUTE_JSON_ACTIONS_INVALID_2);
		this.gameController = new GameController(creator.getMap());
		this.gameController.run(this.creator.getInvokerCommands());
	}


	@Test(expected = IllegalArgumentException.class)
	public void gameOverLightsTest03() {
		this.creator.createMap(Constants.ROUTE_MAP_PROPERTIES);
		this.creator.createActionsByJson(Constants.ROUTE_JSON_ACTIONS_2);
		this.gameController = new GameController(creator.getMap());
		this.gameController.run(this.creator.getInvokerCommands());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void gameOverLightsTest04() {
		this.creator.createMap(Constants.ROUTE_MAP_PROPERTIES);
		this.creator.createActionsByTxt(Constants.ROUTE_TXT_ACTIONS_INVALID_3);
		this.gameController = new GameController(creator.getMap());
		this.gameController.run(this.creator.getInvokerCommands());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void gameOverLightsTest05() {
		this.creator.createMap(Constants.ROUTE_MAP_PROPERTIES);
		this.creator.createActionsByTxt(Constants.ROUTE_TXT_ACTIONS_INVALID_3);
		this.creator.runActions();
	}
}
