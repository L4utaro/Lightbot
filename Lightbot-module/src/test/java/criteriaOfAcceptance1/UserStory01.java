package criteriaOfAcceptance1;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.io.IOException;

import org.junit.Test;

import board.CreateMap;
import enums.LightStatus;
import enums.TypeOfBox;
import main.ConstantsTest;
import model.Avatar;
import model.Map;

public class UserStory01 {
	private Map map;

	/**
	 * Leer un archivo properties (boardInvalid1.properties), que tenga un tamaño
	 * del mapa 3x3, con un camino posible, pero que la posición de la luz en (3,1)
	 * no pertenezca al camino posible, por lo tanto, se deberá lanzar una excepción
	 * y cerrar el juego.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test01() {
		CreateMap create;
		try {
			create = new CreateMap(ConstantsTest.ROUTE_MAP_INVALID_1_PROPERTIES);
			this.map = create.getMap();
		} catch (IOException e) {
		}
	}

	/**
	 * Leer un archivo properties (boardInvalid2.properties), que tenga un tamaño
	 * del mapa 3x3, con un camino posible, pero que no haya una posición para la
	 * luz, por lo tanto, se deberá lanzar una excepción y cerrar el juego.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test02() {
		CreateMap create;
		try {
			create = new CreateMap(ConstantsTest.ROUTE_MAP_INVALID_2_PROPERTIES);
			this.map = create.getMap();
		} catch (IOException e) {
		}
	}

	/**
	 * Leer un archivo properties (boardInvalid3.properties), que tenga un tamaño
	 * del mapa 3x3, con un camino posible, pero que no haya una posición para el
	 * avatar, por lo tanto, se deberá lanzar una excepción y cerrar el juego.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test03() {
		CreateMap create;
		try {
			create = new CreateMap(ConstantsTest.ROUTE_MAP_INVALID_3_PROPERTIES);
			this.map = create.getMap();
		} catch (IOException e) {
		}
	}

	/**
	 * Leer un archivo properties (boardInvalid4.properties), que tenga un tamaño
	 * del mapa 3x3, pero que tenga un camino posible, pero que el avatar en (3,1)
	 * no pertenezca al camino posible. De esta manera deberá de lanzar una
	 * excepción, identificando que el avatar está fuera del camino posible.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test04() {
		CreateMap create;
		try {
			create = new CreateMap(ConstantsTest.ROUTE_MAP_INVALID_4_PROPERTIES);
			this.map = create.getMap();
		} catch (IOException e) {
		}
	}

	/**
	 * Crear un mapa con tamaño 3x3 utilizando el archivo (board.properties), con un
	 * avatar en la posición (1,1), con una luz en la posición (3,3), y que tenga un
	 * camino posible. Esto quiere decir que tenemos un mapa creado, con la posición
	 * del avatar en (1,1) y la luz en (3,3) y ambos pertenecen al camino posible.
	 */
	@Test
	public void test05() {
		CreateMap create;
		try {
			create = new CreateMap(ConstantsTest.ROUTE_MAP_PROPERTIES);
			this.map = create.getMap();
		} catch (IOException e) {
		}
		assertEquals(this.map.getBoard().getBox(new Point(1, 1)).getObjectGraphic().getClass().getName(),
				new Avatar().getClass().getName());
		assertEquals(this.map.getBoard().getBox(new Point(3, 3)).getLightStatus(),
				LightStatus.OFF);
		assertEquals(this.map.getBoard().getBox(new Point(1, 1)).getTypeOfBox(), TypeOfBox.WALK);
		assertEquals(this.map.getBoard().getBox(new Point(3, 3)).getTypeOfBox(), TypeOfBox.WALK);
	}
}
