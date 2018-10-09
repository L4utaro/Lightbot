package main;

public class Main {

	public static void main(String[] args) {
		GameGenerator creator = new GameGenerator();
		creator.createMap(Constants.ROUTE_MAP_PROPERTIES);
		creator.createActionsByJson(Constants.ROUTE_JSON_INSTRUCTIONS_1);
		//creator.createActionsByTxt(Constants.ROUTE_TXT_INSTRUCTIONS_3);
		creator.runActions();
	}
}
