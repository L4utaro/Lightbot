package criteriaOfAcceptance2;

import org.junit.Test;

import controllers.ControllerGames;

public class UserStory04 {
	private ControllerGames controller;

	/*
	 * Cargar las acciones de la carpeta ActionsTest en el directorio
	 * "src/main/resources/user04test01". Deberá de cargar y mostrar la unica
	 * partida que posee. Mostrando el mapa del formato consola, el mapa del formato
	 * grilla de color y las instrucciones usadas por el player. Al finalizar las
	 * instrucciones debera de mostrar que el player gano el juego.
	 */
	@Test
	public void test01() throws InterruptedException {
		this.controller = new ControllerGames("src/main/resources/user04test01");
		this.controller.initGames();
		this.controller.runGames();
		Thread.sleep(10000);
	}

	/*
	 * Cargar las acciones de la carpeta ActionsTest en el directorio
	 * "src/main/resources/user04test02". Debera de cargar y mostrar todas las
	 * partidas de los players y mostrar el resultado final de cada partida. En el
	 * primer juego debera de mostrar el mensaje (You Win). Y el segundo juego (Game
	 * Over: The avatar don't turned all the lights).
	 */

	@Test
	public void test02() throws InterruptedException {
		this.controller = new ControllerGames("src/main/resources/user04test02");
		this.controller.initGames();
		this.controller.runGames();
		Thread.sleep(10000);
	}
	
	/*
	 * Cargar las acciones de la carpeta ActionsTest en el directorio
	 * "src/main/resources/user04test03". Debera de cargar y mostrar todas las
	 * partidas de los players y mostrar el resultado final de cada partida. En el
	 * primer juego debera de mostrar el mensaje (You Win). Y el segundo juego (You win).
	 * Pero como el segundo jugador utilizo menos instrucciones, debera mostrar por 
	 * pantalla "Thw winner is player 2".
	 */

	@Test
	public void test03() throws InterruptedException {
		this.controller = new ControllerGames("src/main/resources/user04test03");
		this.controller.initGames();
		this.controller.runGames();
		Thread.sleep(10000);
	}
}
