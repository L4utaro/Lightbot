package lectors.implementation;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import commands.invoker.InvokerCommand;
import configuration.ConstantsTest;

public class ImplementationTest {
	private Implementation implementation;
	private List<InvokerCommand> invokerCommands;

	@Before
	public void init() {
		this.implementation = new Implementation(ConstantsTest.ROUTE_JSON_ACTIONS_1, ConstantsTest.ROUTE_FUNCTIONS_MACRO);
		this.invokerCommands = this.implementation.createColecctionOfActions(null);
	}

	@Test
	public void test01() {
		this.implementation.addAction("avanzar", this.invokerCommands);
		assertEquals(this.invokerCommands.size(), 10);
	}

	@Test
	public void test02() {
		this.implementation.addAction("derecha", this.invokerCommands);
		assertEquals(this.invokerCommands.size(), 10);
	}

	@Test
	public void test03() {
		this.implementation.addAction("izquierda", this.invokerCommands);
		assertEquals(this.invokerCommands.size(), 10);
	}

	@Test
	public void test04() {
		this.implementation.addAction("luz", this.invokerCommands);
		assertEquals(this.invokerCommands.size(), 10);
	}

	@Test
	public void test05() {
		this.implementation = new Implementation(ConstantsTest.ROUTE_JSON_ACTIONS_1, ConstantsTest.ROUTE_FUNCTIONS_MACRO);
		assertEquals(this.implementation.getActionsJson().size(), 9);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test06() {
		this.implementation = new Implementation("src/main/resources/error.json", ConstantsTest.ROUTE_FUNCTIONS_MACRO);
	}

	@Test
	public void test07() {
		this.implementation.createColecctionOfActions(null);
		assertEquals(this.implementation.getActionsJson().size(), 9);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test08() {
		this.implementation = new Implementation(ConstantsTest.ROUTE_JSON_ACTIONS_INVALID_1, ConstantsTest.ROUTE_FUNCTIONS_MACRO);
		this.implementation.createColecctionOfActions(null);
		assertEquals(this.implementation.getActionsJson().size(), 9);
	}

	@Test
	public void test09() {
		this.implementation = new Implementation(ConstantsTest.ROUTE_TXT_ACTIONS_3, ConstantsTest.ROUTE_FUNCTIONS_MACRO);
		this.implementation.addAction("move", this.invokerCommands);
		assertEquals(this.invokerCommands.size(), 10);
	}
}
