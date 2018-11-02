package criteriaOfAcceptance2;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import configuration.ConstantsTest;
import model.Player;

public class UserStory03 {
	private List<Player> players;
	
	@Before
	public void init() {
		this.players = new ArrayList<>();
	}
	/*
	 * Ejecutar dos listas de acciones, la primera es actionsValid8.json:
	 * “actions”:{“fun”, “fun”}, “fun”:{“avanzar”}, la segunda es actionsValid9.txt:
	 * “actions”: {“fun”, "left", “move”, “fun”}, “fun”:{”right”,“move”}. El avatar de la
	 * primera instrucción que estaba en la posición (1,1) pasa a estar en la
	 * posición (1,1), debido a que no podia avanzar a la posicion (2,1). Y el avatar de la segunda instrucción que estaba en la
	 * posición (1,1) pasa a estar en la posición (2,3).
	 */
	@Test
	public void test01() {
		this.players.add(new Player(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_TXT_ACTIONS_9));
		this.players.add(new Player(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_8));
		try {
			this.players.get(0).getGame().init();
			this.players.get(0).getGame().run();
			this.players.get(1).getGame().init();
			this.players.get(1).getGame().run();
		} catch (IllegalArgumentException e) {
		}
		assertEquals(new Point(2,3), this.players.get(0).getGame().getMap().getAvatarPos());
		assertEquals(new Point(1,1), this.players.get(1).getGame().getMap().getAvatarPos());
	}
	/*
	 * Ejecutar dos listas de acciones, la primera es actionsValid8.json:
	 * “actions”:{“fun”, “fun”}, “fun”:{“avanzar”}, la segunda es actionsFail7.json:
	 * “actions”:{“derecha”, “fun”, “fun”}, “fun”:{“avanzar”}. El avatar de la
	 * segunda instrucción está en la posición (1,1) y se encuentra mirando hacia
	 * abajo, pasaría a estar en la posición (1,3), pero como esa posición no es
	 * parte del camino posible, se deberá de lanzar un IllegalArgumentException,
	 * indicando que el avatar salió del camino.
	 */
	
	/*
	 * Ejecutar dos listas de acciones, la primera es actions1Win.json, la segunda
	 * es actions10Win.json: “actions”:{“derecha”, “avanzar”, “izquierda”,
	 * “izquierda”, “avanzar”, “derecha”, derecha”, “fun”, “derecha”, ”fun”, ”luz”},
	 * “fun”: {“avanzar”, “izquierda”, “avanzar”}. Ambos avatares llegarán a la
	 * meta, pero el primer avatar lo hará en 9 acciones, en cambio, el segundo
	 * avatar lo hará en 15 acciones. Por lo tanto, ganaría el player 1.
	 */

}
