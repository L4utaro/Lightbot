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
		this.implementacion = new Implementation(ConstantsTest.ROUTE_JSON_ACTIONS_1, ConstantsTest.ROUTE_FUNCTIONS_MACRO);
	}

	@Test
	public void test01() {
		this.validatorJson.refreshInstructionsValids();
		assertFalse(this.validatorJson.checkInstruction("asd"));
	}

	@Test
	public void test02() {
		assertTrue(this.validatorJson.validateInstructionsOfJsonArray(this.implementacion.getActionsJson(), null, null));
	}

	@Test
	public void test03() {
		this.implementacion = new Implementation(ConstantsTest.ROUTE_JSON_ACTIONS_INVALID_1, ConstantsTest.ROUTE_FUNCTIONS_MACRO);
		assertFalse(this.validatorJson.validateInstructionsOfJsonArray(this.implementacion.getActionsJson(), null, null));
	}
}
