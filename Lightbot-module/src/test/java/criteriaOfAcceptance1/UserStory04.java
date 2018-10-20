package criteriaOfAcceptance1;

import static org.junit.Assert.assertNotEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import configuration.ConstantsTest;
import main.GameGenerator;

public class UserStory04 {
	private GameGenerator creator;
	
	@Before
	public void init() {
		this.creator = new GameGenerator();
		try {
			this.creator.createMap(ConstantsTest.ROUTE_MAP_PROPERTIES);
		} catch (IOException e) {
		}
	}
	/**
	 * Leer la colección de acciones [commandRight, commandMove, commandLeft,
	 * commandMove, commandRight, commandMove, commandLeft, commandMove], como todas
	 * las instrucciones son válidas, el validador deberá devolver “true”, afirmando
	 * que las instrucciones son válidas y por lo tanto, se creara la lista de acciones.
	 */
	@Test
	public void checkActionsTest01() {
		this.creator.createActionsByJson(ConstantsTest.ROUTE_JSON_ACTIONS_2);
		assertNotEquals(this.creator.getInvokerCommands().size(), 0);
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
		this.creator.createActionsByJson(ConstantsTest.ROUTE_JSON_ACTIONS_INVALID_2);
		//this.creator.runActions();
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
	@Test(expected = IllegalArgumentException.class)
	public void checkActionsTest03() {
		this.creator.createActionsByJson(ConstantsTest.ROUTE_JSON_ACTIONS_2);
		//this.creator.runActions();
	}
}
