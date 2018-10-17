package lectors.implementation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.Constants;

public class TxtImplementationTest {
	private TxtImplementation txtImplementation;

	@Before
	public void init() {
		this.txtImplementation = new TxtImplementation(Constants.ROUTE_TXT_ACTIONS_3);
	}

	@Test
	public void test01() {
		this.txtImplementation.addAction("move");
		assertEquals(this.txtImplementation.getInvokerCommands().size(), 1);
	}

	@Test
	public void test02() {
		this.txtImplementation.addAction("right");
		assertEquals(this.txtImplementation.getInvokerCommands().size(), 1);
	}

	@Test
	public void test03() {
		this.txtImplementation.addAction("left");
		assertEquals(this.txtImplementation.getInvokerCommands().size(), 1);
	}

	@Test
	public void test04() {
		this.txtImplementation.addAction("light");
		assertEquals(this.txtImplementation.getInvokerCommands().size(), 1);
	}

	@Test
	public void test05() {
		this.txtImplementation = new TxtImplementation(Constants.ROUTE_TXT_ACTIONS_3);
		assertEquals(this.txtImplementation.getActionsJson().size(), 9);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test06() {
		this.txtImplementation = new TxtImplementation("src/main/resources/error.txt");
	}

	@Test
	public void test07() {
		this.txtImplementation.createColecctionOfActions();
		assertEquals(this.txtImplementation.getActionsJson().size(), 9);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test08() {
		this.txtImplementation = new TxtImplementation(Constants.ROUTE_TXT_ACTIONS_INVALID_3);
		this.txtImplementation.createColecctionOfActions();
		assertEquals(this.txtImplementation.getActionsJson().size(), 9);
	}
}
