package validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import enums.TypeOfBox;
import model.Board;
import model.Size;

public class ValidatorBoardTest {
	private ValidatorBoard validatorboard;
	
	@Before
	public void init() {
		Board board = new Board(new Size(3,3));
		board.addBox(new Point(1,1), TypeOfBox.WALK);
		this.validatorboard = new ValidatorBoard(board);
	}
	
	@Test
	public void test01() {
		assertTrue(this.validatorboard.isValidPositionForBox(new Point(1,1)));
	}
	
	@Test
	public void test02() {
		assertFalse(this.validatorboard.isValidPositionForBox(new Point(4,4)));
	}

	@Test
	public void test03() {
		assertTrue(this.validatorboard.isValidPositionForObjectGraphic(new Point(1,1)));
	}
}
