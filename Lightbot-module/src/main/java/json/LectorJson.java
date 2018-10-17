package json;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LectorJson {
	private String routeCodeJSON;
	
	public LectorJson(final String routeCodeJSON) {
		this.routeCodeJSON = routeCodeJSON;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getListOfJson(String keyValue) {
		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(new FileReader(routeCodeJSON));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray leng= (JSONArray) jsonObject.get(keyValue);
			return leng;
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
