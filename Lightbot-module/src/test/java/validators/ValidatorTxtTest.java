package validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import lectors.implementation.TxtImplementation;
import main.Constants;

public class ValidatorTxtTest {
	private ValidatorTxt validatorTxt;
	private TxtImplementation txtImplementacion;

	@Before
	public void init() {
		this.validatorTxt = new ValidatorTxt();
		this.txtImplementacion = new TxtImplementation(Constants.ROUTE_TXT_ACTIONS_3);
	}

	@Test
	public void test01() {
		assertFalse(this.validatorTxt.checkInstruction(Constants.ROUTE_TXT_ACTIONS_3));
	}

	@Test
	public void test02() {
		assertTrue(this.validatorTxt.validateInstructionsOfJsonArray(this.txtImplementacion.getActionsJson()));
	}

	@Test
	public void test03() {
		this.txtImplementacion = new TxtImplementation(Constants.ROUTE_TXT_ACTIONS_INVALID_3);
		assertFalse(this.validatorTxt.validateInstructionsOfJsonArray(this.txtImplementacion.getActionsJson()));
	}
}
