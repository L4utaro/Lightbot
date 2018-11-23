package criteriaOfAcceptance2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import configuration.Constants;
import configuration.ConstantsTest;
import lectors.LectorFolder;
import model.Player;

public class UserStory03 {
	private List<Player> players;

	@Before
	public void init() {
		this.players = new ArrayList<>();
	}
	/*
	 * Intentar cargar 4 archivos de instrucciones, como no se pueden cargar 4
	 * archivos, se deberá lanzar un IllegalArgumentException, advirtiendo que no se
	 * pueden cargar mas de 3 players.
	 */
	@Test (expected= IllegalArgumentException.class)
	public void test01() {
		LectorFolder lectorFolder = new LectorFolder("src/main/resources/user03test01");
		lectorFolder.getRoutesOfActions();
	}
	/*
	 * Se deberá cargar 3 archivos de instrucciones, y que se creen 3 players, que
	 * contenga cada uno su propio juego. Por lo tanto se deberá contar con 3 player
	 * y cada uno con su respectivo juego.
	 */
	@Test 
	public void test02() {
		LectorFolder lectorFolder = new LectorFolder("src/main/resources/user03test02");
		List<Player> players = createPlayers(lectorFolder.getRoutesOfActions());
		assertEquals(3, players.size());
	}
	/*
	 * Ejecutar dos listas de acciones, la primera es actions1Win.json, la segunda
	 * es actions10Win.json: “actions”:{“derecha”, “avanzar”, “izquierda”,
	 * “izquierda”, “avanzar”, “derecha”, derecha”, “fun”, “derecha”, ”fun”, ”luz”},
	 * “fun”: {“avanzar”, “izquierda”, “avanzar”}. Ambos avatares llegarán a la
	 * meta, pero el primer avatar lo hará en 9 acciones, en cambio, el segundo
	 * avatar lo hará en 15 acciones. Asegurar que ambos players se encuentren en la
	 * posicion (3,3), por lo tanto, ganaría el player 1.
	 */
	@Test
	public void test03() {
		this.players.add(new Player(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_1));
		this.players.add(new Player(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_10));
		this.players.get(0).getGame().init();
		this.players.get(0).getGame().run();
		this.players.get(1).getGame().init();
		this.players.get(1).getGame().run();
		assertTrue(this.players.get(0).getGame().getInvokersCommands().size() <= this.players.get(1).getGame()
				.getInvokersCommands().size());
	}
	
	/*
	 * Forma del mapa player 1: 
	 * [ WALK ][ NO_WALK ][ NO_WALK ] 
	 * [ WALK ][ WALK ][NO_WALK ] 
	 * [ NO_WALK ][ WALK ][ AVATAR ] 
	 * Forma del mapa player 2: 
	 * [ WALK ][ NO_WALK ][ NO_WALK ] 
	 * [ WALK ][ WALK ][ NO_WALK ] 
	 * [ NO_WALK ][ WALK ][ AVATAR] 
	 * Ambos players: You Win
	 */

	public List<Player> createPlayers(List<String> routesActions) {
		List<Player> players = new ArrayList<>();
		for (int i = 0; i < routesActions.size(); i++) {
			players.add(new Player(Constants.ROUTE_MAP_PROPERTIES, routesActions.get(i)));
		}
		return players;
	}
}
