package validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import board.Builder;
import classProperties.MapProperties;
import enums.TypeOfBox;
import main.Constants;
import model.Map;

public class ValidatorCreateMapTest {
	private ValidatorCreateMap validatorCreateMap;
	private Map map;
	private MapProperties mapProperties;
	
	@Before
	public void init() {
		List<Point> posOfPathPossible = new ArrayList<Point>();
		posOfPathPossible.add(new Point(1, 1));
		posOfPathPossible.add(new Point(1, 2));
		posOfPathPossible.add(new Point(2, 2));
		posOfPathPossible.add(new Point(2, 3));
		posOfPathPossible.add(new Point(3, 3));
		List<Point> posOfLights = new ArrayList<Point>();
		posOfLights.add(new Point(3, 3));
		this.map = new Map(new Builder(new Point(3, 3)).whitRoadPossible(posOfPathPossible).whitAvatar(new Point(1, 1))
				.whitLights(posOfLights));
		this.mapProperties = new MapProperties(Constants.ROUTE_MAP_PROPERTIES);
		this.validatorCreateMap = new ValidatorCreateMap(map, mapProperties);
	}

	@Test
	public void test01() {
		assertTrue(this.validatorCreateMap.isAValidAvatarPosition());
	}

	@Test
	public void test02() {
		assertTrue(this.validatorCreateMap.isAValidLights());
	}

	@Test
	public void test03() {
		assertTrue(this.validatorCreateMap.isAValidRoad());
	}

	@Test
	public void test04() {
		assertTrue(this.validatorCreateMap.isAValidSizeBoard());
	}

	@Test
	public void test05() {
		assertTrue(this.validatorCreateMap.isValidMap());
	}

	@Test
	public void test06() {
		this.map.getBox(new Point(3,3)).setLightStatus(null);;
		this.validatorCreateMap = new ValidatorCreateMap(map, mapProperties);
		assertFalse(this.validatorCreateMap.isAValidLights());
	}

	@Test
	public void test07() {
		this.map.getBoard().addBox(new Point(2,2), TypeOfBox.NO_WALK);
		this.validatorCreateMap = new ValidatorCreateMap(map, mapProperties);
		assertFalse(this.validatorCreateMap.isAValidRoad());
	}
}
