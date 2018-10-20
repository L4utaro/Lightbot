package validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import configuration.Constants;
import lectors.implementation.JsonImplementation;

public class ValidatorJsonTest {
	private ValidatorJson validatorJson;
	private JsonImplementation jsonImplementacion;

	@Before
	public void init() {
		this.validatorJson = new ValidatorJson();
		this.jsonImplementacion = new JsonImplementation(Constants.ROUTE_JSON_ACTIONS_1);
	}

	@Test
	public void test01() {
		assertFalse(this.validatorJson.checkInstruction(Constants.ROUTE_JSON_ACTIONS_1));
	}

	@Test
	public void test02() {
		assertTrue(this.validatorJson.validateInstructionsOfJsonArray(this.jsonImplementacion.getActionsJson()));
	}

	@Test
	public void test03() {
		this.jsonImplementacion = new JsonImplementation(Constants.ROUTE_JSON_ACTIONS_INVALID_1);
		assertFalse(this.validatorJson.validateInstructionsOfJsonArray(this.jsonImplementacion.getActionsJson()));
	}
}
