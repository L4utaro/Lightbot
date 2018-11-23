package criteriaOfAcceptance2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.io.IOException;
import java.sql.Timestamp;

import org.junit.Test;

import configuration.ConstantsTest;
import enums.StateGame;
import generators.GameGenerator;
import modelo.Game;

public class UserStory02 {
	@SuppressWarnings("unused")
	private GameGenerator gameGenerator;

	/*
	 * Crear una lista de acciones que contenga las instrucciones del
	 * actionsValid6.json: “actions”:{“derecha”, “fun”, “derecha”, ”fun”, ”luz”},
	 * “fun”: {“avanzar”, “izquierda”, “avanzar”}. Entonces la lista de acciones
	 * deberá de tener un tamaño de 9 acciones. Y al ser ejecutada, dejara al avatar
	 * en la posición (3,3), con la luz encendida, por lo tanto habra ganado el
	 * juego.
	 */
	@Test
	public void test01() throws IOException {
		this.gameGenerator = new GameGenerator(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_6);
		Game game = new Game(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_6);
		assertEquals(9, game.getInvokersCommands().size());
		game.run();
		assertEquals(new Point(3, 3), game.getMap().getAvatarPos());
	}
	/*
	 * Forma del mapa: [ AVATAR ][ NO_WALK ][ NO_WALK ] [ WALK ][ WALK ][ NO_WALK ]
	 * [ NO_WALK ][ WALK ][ LIGHT_OFF ] Despues de ejecutar las acciones: [ WALK ][
	 * NO_WALK ][ NO_WALK ] [ WALK ][ WALK ][ NO_WALK ] [ NO_WALK ][ WALK ][ AVATAR
	 * ] Y por ultimo aparecera el mensaje de: - You Win
	 */

	/*
	 * Ejecutar la lista de acción actionsInvalid5.json: “actions”:{“derecha”,
	 * “fun”, “fun”}, “fun”:{“avanzar”}, como el avatar está en la posición (1,1) y
	 * se encuentra mirando hacia abajo, pasaría a estar en la posición (1,3), pero
	 * como esa posición no es parte del camino posible, se deberá de lanzar un
	 * IllegalArgumentException, indicando que el avatar salió del camino.
	 */

	@Test(expected = IllegalArgumentException.class)
	public void test02() {
		Game game = new Game(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_INVALID_5);
		game.run();
	}
	/*
	 * Forma del mapa: [ AVATAR ][ NO_WALK ][ NO_WALK ] [ WALK ][ WALK ][ NO_WALK ]
	 * [ NO_WALK ][ WALK ][ LIGHT_OFF ] Despues de ejecutar las acciones: [ WALK ][
	 * NO_WALK ][ NO_WALK ] [ WALK ][ WALK ][ NO_WALK ] [ AVATAR ][ WALK ][
	 * LIGHT_OFF ]
	 */

	/*
	 * Ejecutar la lista de acciones actionsValid6.json, que cada instrucción se
	 * ejecute cada un segundo y pausar la aplicación por 3 segundos, que continúe y
	 * que termine la ejecución de las acciones, corroborar que el juego tardó más
	 * de 9 segundos.
	 */

	@Test
	public void test03() throws IOException, InterruptedException {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Game game = new Game(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_6);
		game.setStateGame(StateGame.STOP);
		Thread.sleep(3000);
		game.setStateGame(StateGame.PLAY);
		game.run();
		assertTrue((new Timestamp(System.currentTimeMillis())).getTime() - (timestamp.getTime()) > 9000 );
	}
	/*
	 * Ejecutar la lista de acciones generadas por actions1.json, y aumentar el
	 * tiempo de espera por ejecución a 2 segundos, comprobar que el tiempo de
	 * ejecución de las instrucciones sea de mas de 17 segundos.
	 * 
	 */

	@Test
	public void test04() throws IOException, InterruptedException {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Game game = new Game(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_1);
		game.setTimeForInstruction(2.0);
		game.run();
		assertTrue((new Timestamp(System.currentTimeMillis())).getTime() - (timestamp.getTime()) > 17000 );
	}
}
