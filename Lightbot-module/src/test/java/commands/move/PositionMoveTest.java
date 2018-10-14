package commands.move;

import static org.junit.Assert.assertNotNull;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import enums.Orientation;

public class PositionMoveTest {
	private PositionMove positionMove;
	
	@Before
	public void init() {
		this.positionMove = new PositionMove();
	}
	
	@Test
	public void test01() {
		this.positionMove.getPositionForMove(new Point(1,1), Orientation.DOWN);
		assertNotNull(this.positionMove.getClass());
	}

	@Test
	public void test02() {
		this.positionMove.getPositionForMove(new Point(1,1), Orientation.UP);
		assertNotNull(this.positionMove.getClass());
	}

	@Test
	public void test03() {
		this.positionMove.getPositionForMove(new Point(1,1), Orientation.RIGHT);
		assertNotNull(this.positionMove.getClass());
	}

	@Test
	public void test04() {
		this.positionMove.getPositionForMove(new Point(1,1), Orientation.LEFT);
		assertNotNull(this.positionMove.getClass());
	}

	@Test(expected = NullPointerException.class)
	public void test05() {
		this.positionMove.getPositionForMove(new Point(1,1), null);
		assertNotNull(this.positionMove.getClass());
	}
}
