package validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ValidatorRoutesActionsTest {
	private ValidatorRoutesActions validatorRoutesActions;
	private List<String> routesActionsValid;
	private List<String> routesActionsInvalid;
	
	@Before
	public void init() {
		this.validatorRoutesActions = new ValidatorRoutesActions();
		this.routesActionsValid = new ArrayList<>();
		this.routesActionsValid.add("C:\\ProgramData\\Actions\\actions.json");
		this.routesActionsInvalid = new ArrayList<>();
		this.routesActionsInvalid.add("C:\\ProgramData\\Actions\\acons.js");
	}
	
	@Test
	public void test01() {
		assertTrue(this.validatorRoutesActions.areAValidsRoutes(this.routesActionsValid));
	}

	@Test
	public void test02() {
		assertFalse(this.validatorRoutesActions.areAValidsRoutes(this.routesActionsInvalid));
	}
}
