package validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.Constants;

public class ValidatorLectorJsonTest {
	private ValidatorLectorJson validatorLectorJson;
	
	@Before
	public void init() {
		this.validatorLectorJson = new ValidatorLectorJson();
	}

	@Test
	public void test01() {
		assertTrue(this.validatorLectorJson.isValidRoute(Constants.ROUTE_JSON_ACTIONS_1));
	}

	@Test
	public void test02() {
		assertFalse(this.validatorLectorJson.isValidRoute("src/main/resources/bor.json"));
	}
}