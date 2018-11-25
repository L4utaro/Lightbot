package criteriaOfAcceptance1;

import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import org.junit.Test;

import configuration.ConstantsTest;
import generators.GameGenerator;
import modelo.Game;

public class UserStory04 {
	private GameGenerator creator;
	private Game game;
	
	/**
	 * Leer la colección de acciones [commandRight, commandMove, commandLeft,
	 * commandMove, commandRight, commandMove, commandLeft, commandMove], como todas
	 * las instrucciones son válidas, el validador deberá devolver “true”, afirmando
	 * que las instrucciones son válidas y por lo tanto, se creara la lista de
	 * acciones.
	 */
	@Test
	public void checkActionsTest01() {
		try {
			this.creator = new GameGenerator();
		} catch (IOException e) {
		}
		assertNotEquals(this.creator.getInvokerCommands().size(), 0);
	}

	/**
	 * Leer la colección de acciones [commandRight, commandMove, commandLeft,
	 * commandMove, commandMove], como todas las instrucciones son válidas, se
	 * deberá corroborar que el avatar no salga del camino posible, pero como salió
	 * del mismo, se deberá lanzar un IllegalArgumentException, indicando que el
	 * avatar salió del camino posible.
	 * @throws IOException 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void checkActionsTest02() throws IOException {
		this.creator = new GameGenerator(ConstantsTest.ROUTE_MAP_PROPERTIES);
		this.game = new Game(this.creator.getMap(), this.creator.createActions(ConstantsTest.ROUTE_JSON_ACTIONS_INVALID_2) , this.creator.getFunctions());
		this.game.init();
		this.game.run();
	}
	/* Forma del mapa:
 	[  AVATAR   ][  NO_WALK  ][  NO_WALK  ]
	[   WALK    ][   WALK    ][  NO_WALK  ]
	[  NO_WALK  ][   WALK    ][ LIGHT_OFF ] 
	Despues de ejecutar las acciones:
 	[   WALK    ][  NO_WALK  ][  NO_WALK  ]
	[   WALK    ][   WALK    ][  AVATAR   ]
	[  NO_WALK  ][   WALK    ][ LIGHT_OFF ] 
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
	public void checkActionsTest03() throws IOException {
		this.creator = new GameGenerator(ConstantsTest.ROUTE_MAP_PROPERTIES);
		this.game = new Game(this.creator.getMap(), this.creator.createActions(ConstantsTest.ROUTE_JSON_ACTIONS_2) ,this.creator.getFunctions());
		this.game.init();
		this.game.run();
	}
	/* Forma del mapa:
 	[  AVATAR   ][  NO_WALK  ][  NO_WALK  ]
	[   WALK    ][   WALK    ][  NO_WALK  ]
	[  NO_WALK  ][   WALK    ][ LIGHT_OFF ] 
	Despues de ejecutar las acciones:
 	[   WALK    ][  NO_WALK  ][  NO_WALK  ]
	[   WALK    ][   WALK    ][  AVATAR   ]
	[  NO_WALK  ][   WALK    ][  AVATAR   ] 
	 */
}
