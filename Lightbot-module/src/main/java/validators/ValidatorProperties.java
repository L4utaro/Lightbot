package validators;

import java.util.Properties;

import org.w3c.dom.events.EventException;

import main.Constants;

public class ValidatorProperties implements IValidator {
	private Properties properties;

	public ValidatorProperties(Properties properties) {
		this.properties = properties;
	}

	public boolean isAValidProperties() {
		try {
			if (this.properties.getProperty(Constants.NAME_PATHPOSSIBLE_PROPERTIES) == null
					|| this.properties.getProperty(Constants.NAME_POSAVATAR_PROPERTIES) == null
					|| this.properties.getProperty(Constants.NAME_POSLIGHT_PROPERTIES) == null
					|| this.properties.getProperty(Constants.NAME_SIZEMAP_PROPERTIES) == null) {
				return false;
			}
		} catch (EventException e) {
			return false;
		}
		return true;
	}
}
