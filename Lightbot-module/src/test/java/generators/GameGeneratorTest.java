package generators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import configuration.ConstantsTest;

public class GameGeneratorTest {
	private GameGenerator gameGenerator;

	@Before
	public void init() {
		try {
			this.gameGenerator = new GameGenerator();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test01() {
		this.gameGenerator.createActions();
		assertEquals(18, this.gameGenerator.getInvokerCommands().size());
	}

	@Test
	public void test02() {
		try {
			this.gameGenerator = new GameGenerator(ConstantsTest.ROUTE_MAP_PROPERTIES);
			this.gameGenerator.createMap(ConstantsTest.ROUTE_MAP_PROPERTIES2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertNotNull(this.gameGenerator.getMap());
	}

	@Test
	public void test03() {
		try {
			this.gameGenerator = new GameGenerator(ConstantsTest.ROUTE_MAP_PROPERTIES,
					ConstantsTest.ROUTE_JSON_ACTIONS_1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertNotNull(this.gameGenerator.getMap());
	}

	@Test
	public void test04() {
		try {
			this.gameGenerator = new GameGenerator(ConstantsTest.ROUTE_MAP_PROPERTIES,
					ConstantsTest.ROUTE_TXT_ACTIONS_3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertNotNull(this.gameGenerator.getMap());
	}
}
