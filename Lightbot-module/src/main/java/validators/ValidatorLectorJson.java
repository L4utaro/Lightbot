package validators;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import validators.interfaces.IValidator;

public class ValidatorLectorJson implements IValidator {

	public boolean isValidRoute(String routeCodeJSON) {
		JSONParser parser = new JSONParser();
		@SuppressWarnings("unused")
		Object obj;
		try {
			obj = parser.parse(new FileReader(routeCodeJSON));
		} catch (IOException e) {
			return false;
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
}
