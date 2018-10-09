package lectors;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import lectors.interfaces.ILector;
import validators.ValidatorLectorJson;

public class LectorJson implements ILector{
	private String routeCodeJSON;
	private ValidatorLectorJson validatorLectorJson;

	public LectorJson(final String routeCodeJSON) {
		this.routeCodeJSON = routeCodeJSON;
		this.validatorLectorJson = new ValidatorLectorJson();
		isAValidRoute();
	}

	public void isAValidRoute() {
		if (!this.validatorLectorJson.isValidRoute(this.routeCodeJSON)) {
			throw new IllegalArgumentException("This is not a valid route of actions.json");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Object> getListOfJson(String keyValue) {
		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(new FileReader(routeCodeJSON));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray leng = (JSONArray) jsonObject.get(keyValue);
			return leng;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
