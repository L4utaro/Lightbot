package lectors.implementation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.Constants;

public class JsonImplementationTest {
	private JsonImplementation jsonImplementation;

	@Before
	public void init() {
		this.jsonImplementation = new JsonImplementation(Constants.ROUTE_JSON_ACTIONS_1);
	}

	@Test
	public void test01() {
		this.jsonImplementation.addAction("avanzar");
		assertEquals(this.jsonImplementation.getInvokerCommands().size(), 1);
	}

	@Test
	public void test02() {
		this.jsonImplementation.addAction("derecha");
		assertEquals(this.jsonImplementation.getInvokerCommands().size(), 1);
	}

	@Test
	public void test03() {
		this.jsonImplementation.addAction("izquierda");
		assertEquals(this.jsonImplementation.getInvokerCommands().size(), 1);
	}

	@Test
	public void test04() {
		this.jsonImplementation.addAction("luz");
		assertEquals(this.jsonImplementation.getInvokerCommands().size(), 1);
	}

	@Test
	public void test05() {
		this.jsonImplementation = new JsonImplementation(Constants.ROUTE_JSON_ACTIONS_1);
		assertEquals(this.jsonImplementation.getActionsJson().size(), 9);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test06() {
		this.jsonImplementation = new JsonImplementation("src/main/resources/error.json");
	}

	@Test
	public void test07() {
		this.jsonImplementation.createColecctionOfActions();
		assertEquals(this.jsonImplementation.getActionsJson().size(), 9);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test08() {
		this.jsonImplementation = new JsonImplementation(Constants.ROUTE_JSON_ACTIONS_INVALID_1);
		this.jsonImplementation.createColecctionOfActions();
		assertEquals(this.jsonImplementation.getActionsJson().size(), 9);
	}
}
