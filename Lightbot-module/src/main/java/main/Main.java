package main;

import java.io.IOException;

import configuration.Constants;

public class Main {

	public static void main(String[] args) throws IOException {
		GameGenerator creator = new GameGenerator();
		creator.createMap(Constants.ROUTE_MAP_PROPERTIES);
		creator.createActionsByJson(Constants.ROUTE_JSON_ACTIONS_1);
		//creator.createActionsByTxt(Constants.ROUTE_TXT_INSTRUCTIONS_3);
	}
}
