package criteriaOfAcceptance1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lectors.LectorJson;
import lectors.implementation.JsonImplementation;
import main.Constants;

public class UserStory02 {
	private JsonImplementation jsonImplementation;
	/**
	 * En caso de no encontrar el archivo .json en la ruta
	 * “C:\ProgramData\actions.json”, se deberá lanzar una excepción notificando que
	 * no se encontró el archivo en la ruta específica.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test01() {
		@SuppressWarnings("unused")
		LectorJson lectorJson = new LectorJson("C:\\\\ProgramData\\\\actionsNot.json");
	}

	/**
	 * Cargar un archivo .json (actionsInvalid1.json), que tenga una lista con las
	 * instrucciones {avanzar, derecha, abajo} y lance una excepción debido a que
	 * tiene mal la instrucción “abajo”.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test02() {
		this.jsonImplementation = new JsonImplementation(Constants.ROUTE_JSON_ACTIONS_INVALID_1);
		this.jsonImplementation.createColecctionOfActions();
	}

	/**
	 * Cargar un archivo .json (actions2.json) que tenga una lista con las
	 * siguientes instrucciones {derecha, avanzar, izquierda, avanzar, derecha,
	 * avanzar, izquierda, avanzar}, como las instrucciones son válidas, deberá de
	 * crearse una colección de acciones. Se tendrá que verificar que la cantidad de
	 * acciones sean igual a la cantidad de instrucciones propuestas.
	 */
	@Test
	public void test03() {
		this.jsonImplementation = new JsonImplementation(Constants.ROUTE_JSON_ACTIONS_2);
		this.jsonImplementation.createColecctionOfActions();
		assertEquals(this.jsonImplementation.getActionsCommand().size(), 8);
	}
}
