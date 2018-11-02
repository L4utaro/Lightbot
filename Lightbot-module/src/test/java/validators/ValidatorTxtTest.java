package validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import configuration.ConstantsTest;
import lectors.implementation.Implementation;

public class ValidatorTxtTest {
	private ValidatorTxt validatorTxt;
	private Implementation implementacion;

	@Before
	public void init() {
		this.validatorTxt = new ValidatorTxt();
		this.implementacion = new Implementation(ConstantsTest.ROUTE_TXT_ACTIONS_3);
	}

	@Test
	public void test01() {
		this.validatorTxt.refreshInstructionsValids();
		assertFalse(this.validatorTxt.checkInstruction("asd"));
	}

	@Test
	public void test02() {
		assertTrue(this.validatorTxt.validateInstructionsOfJsonArray(this.implementacion.getActionsJson(), null));
	}

	@Test
	public void test03() {
		this.implementacion = new Implementation(ConstantsTest.ROUTE_TXT_ACTIONS_INVALID_3);
		assertFalse(this.validatorTxt.validateInstructionsOfJsonArray(this.implementacion.getActionsJson(), null));
	}
}
