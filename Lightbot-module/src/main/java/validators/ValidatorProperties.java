package validators;

import java.util.Properties;

import org.w3c.dom.events.EventException;

import configuration.Constants;
import validators.interfaces.IValidator;

public class ValidatorProperties implements IValidator {
	private Properties properties;
	private Character[] charactersPosibles = {'1','2','3','4','5','6','7','8','9','0','(',')','{','}',',',' '};
	
	public ValidatorProperties(Properties properties) {
		this.properties = properties;
	}

	public boolean isAValidProperties() {
		try {
			if (!isAValidProperty(this.properties.getProperty(Constants.NAME_PATHPOSSIBLE_PROPERTIES))
					|| !isAValidProperty(this.properties.getProperty(Constants.NAME_POSAVATAR_PROPERTIES))
					|| !isAValidProperty(this.properties.getProperty(Constants.NAME_POSLIGHT_PROPERTIES))
					|| !isAValidProperty(this.properties.getProperty(Constants.NAME_SIZEMAP_PROPERTIES))) {
				return false;
			}
		} catch (EventException e) {
			return false;
		}
		return true;
	}
	
	public boolean isAValidProperty(String property) {
		if(property == null) {
			return false;
		}
		for(int i = 0; i < property.length(); i++) {
			if(!isAnInvalidCharacter(property.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public boolean isAnInvalidCharacter(char charAt) {
		for(int c = 0; c < charactersPosibles.length; c++) {
			if(charAt == charactersPosibles[c]) {
				return true;
			}
		}
		return false;
	}
}
