package validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import configuration.Constants;

public class ValidatorLectorTxtTest {
	private ValidatorLectorTxt validatorLectorTxt;
	
	@Before
	public void init() {
		this.validatorLectorTxt = new ValidatorLectorTxt();
	}

	@Test
	public void test01() {
		assertTrue(this.validatorLectorTxt.isValidRoute(Constants.ROUTE_TXT_ACTIONS_3));
	}

	@Test
	public void test02() {
		assertFalse(this.validatorLectorTxt.isValidRoute("src/main/resources/bor.txt"));
	}
}
