package board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import enums.TypeOfBox;

public class BuilderTest {
	private Builder builder;

	@Test(expected = IllegalArgumentException.class)
	public void sizeMapNullTest01() {
		this.builder = new Builder(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void sizeMapInvalidTest02() {
		this.builder = new Builder(new Point(0,0));
	}
	
	@Test
	public void sizeMapValidTest03() {
		this.builder = new Builder(new Point(2,2));
		assertNotNull(this.builder.getBoard());
	}
	
	@Test
	public void whitRoadPossibleTest04() {
		List<Point> posOfPathPossible = new ArrayList<>();
		posOfPathPossible.add(new Point(1,1));
		this.builder = new Builder(new Point(2,2));
		this.builder.whitRoadPossible(posOfPathPossible);
		assertEquals(this.builder.getBoard().getBox(new Point(1,1)).getTypeOfBox(), TypeOfBox.WALK);
	}
	
	@Test
	public void whitAvatar() {
		List<Point> posOfPathPossible = new ArrayList<>();
		posOfPathPossible.add(new Point(1,1));
		this.builder = new Builder(new Point(2,2));
		this.builder.whitRoadPossible(posOfPathPossible);
		this.builder.whitAvatar(new Point(1,1));
		assertNotNull(this.builder.getBoard().getBox(new Point (1,1)).getObjectGraphic());
	}
}
