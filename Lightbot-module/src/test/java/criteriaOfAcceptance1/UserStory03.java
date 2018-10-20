package criteriaOfAcceptance1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lectors.LectorTxt;
import lectors.implementation.TxtImplementation;
import main.ConstantsTest;

public class UserStory03 {
	private TxtImplementation txtImplementation;
	
	/**
	 * En caso de no encontrar el archivo .txt, se deberá lanzar una
	 * IllegalArgumentExcepción notificando que “No se encontró el archivo en la
	 * ruta específica”.
	 */

	@Test(expected = IllegalArgumentException.class)
	public void fileNotFoundTest01() {
		@SuppressWarnings("unused")
		LectorTxt lectorTxt = new LectorTxt("C:\\\\ProgramData\\\\actionsNot.txt");
	}
	
	/**
	 * Cargar un archivo .txt (actionsInvalid3.txt:), que tenga una lista con las
	 * siguientes instrucciones {derecha, avanzar, izquierda, avanzar, derecha,
	 * avanzar, izquierda, avanzar}, pero esto no funcionara, ya que las
	 * instrucciones están en castellano, por lo tanto, se lanzará una
	 * IllegalArgumentExcepción, informando que las notificaciones no son válidas.
	 */

	@Test(expected = IllegalArgumentException.class)
	public void argumentsInvalidTest02() {
		this.txtImplementation = new TxtImplementation(ConstantsTest.ROUTE_TXT_ACTIONS_INVALID_3);
		this.txtImplementation.createColecctionOfActions();
	}
	
	/**
	 * Cargar un archivo .txt (actions3.txt:), que tenga una lista con las
	 * siguientes instrucciones {right, move, left, move, right, move, left, move,
	 * light}, por lo tanto se creará la colección de acciones. Se tendrá que
	 * verificar que la cantidad de acciones sean igual a la cantidad de
	 * instrucciones propuestas.
	 */
	@Test
	public void test03() {
		this.txtImplementation = new TxtImplementation(ConstantsTest.ROUTE_TXT_ACTIONS_3);
		this.txtImplementation.createColecctionOfActions();
		assertEquals(this.txtImplementation.getInvokerCommands().size(), 9);
	}
}
