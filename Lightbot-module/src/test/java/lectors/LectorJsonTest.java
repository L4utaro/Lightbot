package lectors;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import configuration.Constants;
public class LectorJsonTest {
	private LectorJson lectorJson;
	
	@Before
	public void init() {
		this.lectorJson = new LectorJson(Constants.ROUTE_JSON_ACTIONS_1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test01() {
		this.lectorJson = new LectorJson("src/main/resources/error.json");
	}

	@Test
	public void test02() {
		assertNotNull(this.lectorJson.getListOfJson("actions"));
	}
	
	@Test(expected = AssertionError.class)
	public void test03() {
		assertNotNull(this.lectorJson.getListOfJson("act"));
	}
}
