package json;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import lectors.LectorJson;
import main.Constants;

public class LectorJsonTest {
	private LectorJson lectorJson;
	
	@Before
	public void init() {
		this.lectorJson = new LectorJson(Constants.ROUTE_JSON_ACTIONS_1);
	}
	
	@Test
	public void getListOfJsonTest1() {
		assertNotNull(this.lectorJson.getListOfJson("actions"));
	}

	@Test
	public void getListOfJsonTest2() {
		assertNull(this.lectorJson.getListOfJson("sf"));
	}
}
