package lectors.implementation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import configuration.ConstantsTest;

public class ImplementationTest {
	private Implementation implementation;

	@Before
	public void init() {
		this.implementation = new Implementation(ConstantsTest.ROUTE_JSON_ACTIONS_1);
	}

	@Test
	public void test01() {
		this.implementation.addAction("avanzar");
		assertEquals(this.implementation.getInvokerCommands().size(), 1);
	}

	@Test
	public void test02() {
		this.implementation.addAction("derecha");
		assertEquals(this.implementation.getInvokerCommands().size(), 1);
	}

	@Test
	public void test03() {
		this.implementation.addAction("izquierda");
		assertEquals(this.implementation.getInvokerCommands().size(), 1);
	}

	@Test
	public void test04() {
		this.implementation.addAction("luz");
		assertEquals(this.implementation.getInvokerCommands().size(), 1);
	}

	@Test
	public void test05() {
		this.implementation = new Implementation(ConstantsTest.ROUTE_JSON_ACTIONS_1);
		assertEquals(this.implementation.getActionsJson().size(), 9);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test06() {
		this.implementation = new Implementation("src/main/resources/error.json");
	}

	@Test
	public void test07() {
		this.implementation.createColecctionOfActions();
		assertEquals(this.implementation.getActionsJson().size(), 9);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test08() {
		this.implementation = new Implementation(ConstantsTest.ROUTE_JSON_ACTIONS_INVALID_1);
		this.implementation.createColecctionOfActions();
		assertEquals(this.implementation.getActionsJson().size(), 9);
	}

	@Test
	public void test09() {
		this.implementation = new Implementation(ConstantsTest.ROUTE_TXT_ACTIONS_3);
		this.implementation.addAction("move");
		assertEquals(this.implementation.getInvokerCommands().size(), 1);
	}
}
