package criteriaOfAcceptance1;

import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import configuration.ConstantsTest;
import modelo.Game;

public class UserStory04 {
	private Game game;

	@Before
	public void init() {
		this.game = new Game();
	}

	/**
	 * Correr la colección de acciones actions.json, y verificar que tarde menos de
	 * 10 segundos su ejecución.
	 */
	@Test
	public void checkActionsTest01() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		this.game = new Game(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_1);
		this.game.run();
		assertTrue((new Timestamp(System.currentTimeMillis())).getTime() - (timestamp.getTime()) < 10000);
	}

	/**
	 * Leer la colección de acciones [commandRight, commandMove, commandLeft,
	 * commandMove, commandMove], como todas las instrucciones son válidas, se
	 * deberán ejecutar las instrucciones. Pero como el avatar termina saliendo del
	 * camino posible se deberá lanzar un IllegalArgumentException, indicando que el
	 * avatar salió del camino posible.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void checkActionsTest02() {
		this.game = new Game(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_INVALID_2);
		this.game.run();
	}
	/*
	 * Forma del mapa: 
	 * [ AVATAR  ][ NO_WALK ][ NO_WALK   ] 
	 * [ WALK    ][ WALK    ][ NO_WALK   ]
	 * [ NO_WALK ][ WALK    ][ LIGHT_OFF ] 
	 * Despues de ejecutar las acciones: 
	 * [ WALK    ][ NO_WALK ][ NO_WALK   ] 
	 * [ WALK    ][ WALK    ][ AVATAR    ] 
	 * [ NO_WALK ][ WALK    ][LIGHT_OFF  ]
	 */

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
		this.game = new Game(ConstantsTest.ROUTE_MAP_PROPERTIES, ConstantsTest.ROUTE_JSON_ACTIONS_2);
		this.game.run();
	}
	/*
	 * Forma del mapa: 
	 * [ AVATAR  ][ NO_WALK ][ NO_WALK   ] 
	 * [ WALK    ][ WALK    ][ NO_WALK   ]
	 * [ NO_WALK ][ WALK    ][ LIGHT_OFF ] 
	 * Despues de ejecutar las acciones: 
	 * [ WALK    ][ NO_WALK ][ NO_WALK   ] 
	 * [ WALK    ][ WALK    ][ AVATAR    ] 
	 * [ NO_WALK ][ WALK    ][ AVATAR    ]
	 */
}
