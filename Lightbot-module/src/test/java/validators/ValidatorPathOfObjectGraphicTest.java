package validators;

import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import board.Builder;
import model.Map;
import model.Size;

public class ValidatorPathOfObjectGraphicTest {
	private ValidatorPathOfObjectGraphic validatorPathOfObjectGraphic;
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
		this.map = new Map(new Builder(new Size(3, 3)).whitRoadPossible(posOfPathPossible).whitAvatar(new Point(1, 1))
				.whitLights(posOfLights));
		this.validatorPathOfObjectGraphic = new ValidatorPathOfObjectGraphic(this.map);
	}

	@Test
	public void test01() {
		assertTrue(this.validatorPathOfObjectGraphic.validatePositionForObjectGraphic(new Point(2,2)));
	}
}
