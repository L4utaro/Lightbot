package validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import configuration.ConstantsTest;
import lectors.implementation.Implementation;

public class ValidatorJsonTest {
	private ValidatorJson validatorJson;
	private Implementation implementacion;

	@Before
	public void init() {
		this.validatorJson = new ValidatorJson();
		this.implementacion = new Implementation(ConstantsTest.ROUTE_JSON_ACTIONS_1);
	}

	@Test
	public void test01() {
		assertFalse(this.validatorJson.checkInstruction(ConstantsTest.ROUTE_JSON_ACTIONS_1));
	}

	@Test
	public void test02() {
		assertTrue(this.validatorJson.validateInstructionsOfJsonArray(this.implementacion.getActionsJson(), null));
	}

	@Test
	public void test03() {
		this.implementacion = new Implementation(ConstantsTest.ROUTE_JSON_ACTIONS_INVALID_1);
		assertFalse(this.validatorJson.validateInstructionsOfJsonArray(this.implementacion.getActionsJson(), null));
	}
}
