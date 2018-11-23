package criteriaOfAcceptance2;

import org.junit.Test;

import controllers.ControllerGames;

public class UserStory04 {
	private ControllerGames controller;

	/*
	 * Cargar las acciones de la carpeta ActionsTest en el directorio
	 * "C:\ProgramData\. Debera de cargar y mostrar todas las partidas de los
	 * players y mostrar el resultado final de cada partida. En el primer juego
	 * debera de mostrar el mensaje (You Win). Y el segundo juego (Game Over: The
	 * avatar don't turned all the lights).
	 */
	@Test
	public void test01() {
		this.controller = new ControllerGames("src/main/resources/user04test01");
		this.controller.initGames();
	}

	/*
	 * Cargar las acciones de la carpeta ActionsTest02 en el directorio
	 * "C:\ProgramData\. Debera de cargar y mostrar todas las partidas de los
	 * players y mostrar el resultado final de cada partida. Pero esta carpeta
	 * contiene un archivo Java. Por lo tanto debera terminar y lanzar un
	 * IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test02() {
		this.controller = new ControllerGames("C:\\ProgramData\\ActionsTest02");
		this.controller.initGames();
	}

	/*
	 * Cargar las acciones de la carpeta ActionsTest03 en el directorio
	 * "C:\ProgramData\. Pero como esta carpeta no existe en la direccion, debera de
	 * lanzar una IllegalArgumentException("The folder don't exists");.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test03() {
		this.controller = new ControllerGames("C:\\ProgramData\\ActionsTest03");
		this.controller.initGames();
	}
}
