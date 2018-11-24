package criteriaOfAcceptance2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import configuration.Constants;
import lectors.LectorFolder;
import model.Player;

public class UserStory03 {

	@Before
	public void init() {
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
	
	/*Se debera intentar cargar archivos de instrucciones, desde un path inexistente,
	 * por lo tanto, se debera lanzar  un IllegalArgumentException.*/
	@Test (expected = IllegalArgumentException.class)
	public void test03() {
		LectorFolder lectorFolder = new LectorFolder("src/main/resources/user03test03");
		lectorFolder.getRoutesOfActions();
	}
	
	/*Se debera intentar cargar instrucciones desde un directorio que no contiene
	 * ninguna lista de instrucciones. Por lo tanto, debera lanzar un 
	 * IllegalArgumentException, indicando que no hay ningun archivo de instruccion.*/
	@Test (expected = IllegalArgumentException.class)
	public void test04() {
		LectorFolder lectorFolder = new LectorFolder("src/main/resources/user03test03");
		lectorFolder.getRoutesOfActions();
	}

	public List<Player> createPlayers(List<String> routesActions) {
		List<Player> players = new ArrayList<>();
		for (int i = 0; i < routesActions.size(); i++) {
			players.add(new Player(Constants.ROUTE_MAP_PROPERTIES, routesActions.get(i)));
		}
		return players;
	}
}
