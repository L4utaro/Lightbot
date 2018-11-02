package validators;

import java.util.List;

import validators.interfaces.IValidator;

public class ValidatorRoutesActions implements IValidator {

	public boolean areAValidsRoutes(List<String> routesActions) {
		for (String route : routesActions) {
			if (!(route.charAt(route.length() - 1) == 'n' || route.charAt(route.length() - 1) == 't')) {
				return false;
			}
		}
		return true;
	}
}
