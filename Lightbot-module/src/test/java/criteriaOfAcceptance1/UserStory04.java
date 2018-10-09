package criteriaOfAcceptance1;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import main.Constants;
import main.GameGenerator;

public class UserStory04 {
	private GameGenerator creator;
	
	@Before
	public void init() {
		this.creator = new GameGenerator();
	}
	/**
	 * Leer la colección de acciones [commandRight, commandMove, commandLeft,
	 * commandMove, commandRight, commandMove, commandLeft, commandMove], como todas
	 * las instrucciones son válidas, el validador deberá devolver “true”, afirmando
	 * que las instrucciones son válidas y por lo tanto, se creara la lista de acciones.
	 */
	@Test
	public void checkActionsTest01() {
		this.creator.createActionsByJson(Constants.ROUTE_JSON_INSTRUCTIONS_2);
		assertNotEquals(this.creator.getActionsCommand().size(), 0);
	}
	/**
	 * Leer la colección de acciones [commandRight, commandMove, commandLeft,
	 * commandMove, commandMove], como todas las instrucciones son válidas, se
	 * deberá corroborar que el avatar no salga del camino posible, pero como salió
	 * del mismo, se deberá lanzar un IllegalArgumentException, indicando que el
	 * avatar salió del camino posible.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void checkActionsTest02() {
		this.creator.createActionsByJson(Constants.ROUTE_JSON_INSTRUCTIONS_INVALID_2);
	}
	/**
	 * Leer la colección de acciones [commandRight, commandMove, commandLeft,
	 * commandMove, commandRight, commandMove, commandLeft, commandMove], como todas
	 * las instrucciones son válidas, se deberá corroborar que el avatar no salga
	 * del camino posible, como no sale del camino, se verificará que todas las
	 * luces están encendidas, pero como quedo una luz sin encender, entonces se
	 * deberá lanzar un IllegalArgumentException, indicando que alguna luz no se
	 * encuentran encendida.
	 */

}
