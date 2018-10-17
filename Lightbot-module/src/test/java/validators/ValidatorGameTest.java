package validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import board.Builder;
import enums.LightStatus;
import model.Map;

public class ValidatorGameTest {
	private ValidatorGame validatorGame;
	private Map map;

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
		this.validatorGame = new ValidatorGame(this.map);
	}

	@Test
	public void test01() {
		assertFalse(this.validatorGame.allLightsAreTurnedOn(this.map));
	}

	@Test
	public void test02() {
		this.map.getBox(new Point(3, 3)).setLightStatus(LightStatus.ON);
		assertTrue(this.validatorGame.allLightsAreTurnedOn(this.map));
	}
	
	@Test
	public void test03() {
		assertFalse(this.validatorGame.isAvatarIsOutOfPathPossible());
	}
}
