package criteriaOfAcceptance2;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import configuration.ConstantsTest;
import generators.GameGenerator;

public class UserStory01 {
	private GameGenerator gameGenerator;
	/*
	 * Crear un archivo actionsInvalid4.json, que contenga (“function”:{”move”}),
	 * pero que lance un IllegalArgumentException, debido a que no contiene el
	 * main del juego, cuyo nombre es referenciado con "actions"
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test01() throws IOException {
		this.gameGenerator = new GameGenerator(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_INVALID_4);
	}
	
	/*
	 * Utilizar el archivo actions3.json, se deberá de cargar y crear la lista de
	 * acciones en base a este archivo. Se deberá de crear la lista de instrucciones
	 * correspondiente, que contengan las instrucciones de las acciones y que se
	 * almacenen las dos funciones. Por lo tanto, se tendrá la lista de acciones con
	 * un tamaño de 12 acciones, y las funciones con dos acciones cada una.
	 */
	@Test
	public void test02() throws IOException {
		this.gameGenerator = new GameGenerator(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_3);
		assertEquals(12, this.gameGenerator.getInvokerCommands().size());
		assertEquals(2,this.gameGenerator.getFunctions().size());
		assertEquals(2,this.gameGenerator.getFunctions().get("fun1").size());
		assertEquals(2,this.gameGenerator.getFunctions().get("fun2").size());		
	}
	
	/*
	 * Crear un archivo actionsWhitFunctions.txt que tenga las siguientes
	 * instrucciones: (“fun”:{“move”, “left”, ”move”}, “actions”: {“move”, “fun”,
	 * “fun”}, se deberá de cargar y crear la lista de acciones en base a este
	 * archivo. Se de contar con una acción, y una lista de acciones que contenga
	 * dos acciones, quedando con un total de 5 acciones.
	 */
	@Test
	public void test03() throws IOException {
		this.gameGenerator = new GameGenerator(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_TXT_ACTIONS_WHIT_FUNCTIONS);
		assertEquals(5, this.gameGenerator.getInvokerCommands().size());	
	}
}
