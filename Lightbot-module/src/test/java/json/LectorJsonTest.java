package json;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import lectors.LectorJson;
import main.Constants;

public class LectorJsonTest {
	
//	@Test
//	public void getListOfJsonTest1() {
//		LectorJson lector = new LectorJson(Constants.ROUTE_JSON_INSTRUCTIONS_1);
//		assertNotNull(lector.getListOfJson("sd"));
//	}

	@Test(expected=IllegalArgumentException.class)
	public void getListOfJsonTest2() {
		LectorJson lector = new LectorJson("asdasd");
		assertNotNull(lector.getListOfJson("sd"));
	}

//	@Test
//	public void getListOfJsonTest3() {
//		LectorJson lector = new LectorJson(Constants.ROUTE_JSON_INSTRUCTIONS_1);
//		assertNotNull(lector.getListOfJson("Points"));
//	}
}
