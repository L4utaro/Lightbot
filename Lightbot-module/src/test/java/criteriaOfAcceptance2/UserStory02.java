package criteriaOfAcceptance2;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.io.IOException;

import org.junit.Test;

import configuration.ConstantsTest;
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
	 * en la posición (3,3), con la luz encendida, por lo tanto habra ganado el juego.
	 */
	@Test
	public void test01() throws IOException {
		this.gameGenerator = new GameGenerator(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_6);
		Game game = new Game(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_6);
		assertEquals(9, game.getInvokersCommands().size());
		game.run();
		assertEquals(new Point(3,3), game.getMap().getAvatarPos());
	}
	/* Forma del mapa:
 	[  AVATAR   ][  NO_WALK  ][  NO_WALK  ]
	[   WALK    ][   WALK    ][  NO_WALK  ]
	[  NO_WALK  ][   WALK    ][ LIGHT_OFF ] 
	Despues de ejecutar las acciones:
 	[   WALK    ][  NO_WALK  ][  NO_WALK  ]
	[   WALK    ][   WALK    ][  NO_WALK  ]
	[  NO_WALK  ][   WALK    ][  AVATAR   ] 
	Y por ultimo aparecera el mensaje de:
	- You Win
	 */
	
	/*
	 * Ejecutar la lista de acción actionsInvalid5.json: “actions”:{“derecha”, “fun”,
	 * “fun”}, “fun”:{“avanzar”}, como el avatar está en la posición (1,1) y se
	 * encuentra mirando hacia abajo, pasaría a estar en la posición (1,3), pero
	 * como esa posición no es parte del camino posible, se deberá de lanzar un
	 * IllegalArgumentException, indicando que el avatar salió del camino.
	 */

	@Test(expected= IllegalArgumentException.class)
	public void test02(){
		Game game = new Game(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_INVALID_5);
		game.run();
	}
	/* Forma del mapa:
 	[  AVATAR   ][  NO_WALK  ][  NO_WALK  ]
	[   WALK    ][   WALK    ][  NO_WALK  ]
	[  NO_WALK  ][   WALK    ][ LIGHT_OFF ] 
	Despues de ejecutar las acciones:
 	[   WALK    ][  NO_WALK  ][  NO_WALK  ]
	[   WALK    ][   WALK    ][  NO_WALK  ]
	[  AVATAR   ][   WALK    ][ LIGHT_OFF ] 
	 */
	
	/*
	 * Ejecutar la lista de acción actionsInvalid6.json: “actions”:{“derecha”, “fun”,
	 * “fun”}, “fun”:{“fun2”}, “fun2”:{“avanzar”}. Como dentro de la funcion se
	 * encuentra referenciada otra funcion, el sistema debera terminar su ejecucion
	 * y lanzar un IllegalArgumentException.
	 */

	@Test(expected= IllegalArgumentException.class)
	public void test03() throws IOException {
		this.gameGenerator = new GameGenerator(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_INVALID_6);
	}
	/*
	 * Ejecutar la lista de acciones generada por actions1.json, y hacer que después
	 * de 4 segundos la ejecución se corte, por lo tanto el avatar quedara en la
	 * posición (2,2) del mapa.
	 * 
	 */
}
