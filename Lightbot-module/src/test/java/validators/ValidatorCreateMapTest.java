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
import main.Constants;
import model.Map;

public class ValidatorCreateMapTest {
	private ValidatorCreateMap validatorCreateMap;

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
		Map map = new Map(new Builder(new Point(3, 3)).whitRoadPossible(posOfPathPossible).whitAvatar(new Point(1, 1))
				.whitLights(posOfLights));
		MapProperties mapProperties = new MapProperties(Constants.ROUTE_MAP_PROPERTIES);
		this.validatorCreateMap = new ValidatorCreateMap(map, mapProperties);
	}

	@Test
	public void test01() {
		assertFalse(this.validatorCreateMap.checkAvatarPosition());
	}

	@Test
	public void test02() {
		assertFalse(this.validatorCreateMap.checkLights());
	}

	@Test
	public void test03() {
		assertFalse(this.validatorCreateMap.checkRoad());
	}

	@Test
	public void test04() {
		assertFalse(this.validatorCreateMap.checkSizeBoard());
	}

	@Test
	public void test05() {
		assertTrue(this.validatorCreateMap.isValidMap());
	}
}
