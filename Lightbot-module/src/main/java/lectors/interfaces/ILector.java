package lectors.interfaces;

import java.util.List;

public interface ILector {

	public List<Object> getListOfJson(String keyValue);
	
	public void isAValidRoute();

	public List<String> getNamesOfArrays();
}
