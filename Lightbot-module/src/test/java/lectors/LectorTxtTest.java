package lectors;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import configuration.Constants;

public class LectorTxtTest {
private LectorTxt lectorTxt;
	
	@Before
	public void init() {
		this.lectorTxt = new LectorTxt(Constants.ROUTE_TXT_ACTIONS_3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test01() {
		this.lectorTxt = new LectorTxt("src/main/resources/error.txt");
	}

	@Test
	public void test02() {
		this.lectorTxt.readFile();
		assertNotNull(this.lectorTxt.getJson());
	}
	
	@Test
	public void test03() {
		this.lectorTxt.readFile();
		assertNotNull(this.lectorTxt.getListOfJson("actions"));
	}
	
	@Test(expected = AssertionError.class)
	public void test04() {
		assertNotNull(this.lectorTxt.getListOfJson("act"));
	}
}
