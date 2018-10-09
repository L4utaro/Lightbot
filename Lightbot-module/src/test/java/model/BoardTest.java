package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import enums.LightStatus;
import enums.TypeOfBox;

public class BoardTest {
	private Board board;
	
	@Before
	public void init() {
		this.board = new Board(new Point(2,2));
	}
	
	@Test
	public void test01() {
		this.board.addBox(new Point(1,1), TypeOfBox.WALK);
		assertEquals(this.board.getBox(new Point(1,1)).getTypeOfBox(), TypeOfBox.WALK);
	}
	
	@Test
	public void test02() {
		this.board.addBoxAvatar(new Point(1,1), TypeOfBox.WALK, new Avatar());
		assertNotNull(this.board.getBox(new Point(1,1)).getObjectGraphic());
	}
	
	@Test
	public void test03() {
		this.board.addBoxLight(new Point(1,1), TypeOfBox.WALK, LightStatus.OFF);
		assertEquals(this.board.getBox(new Point(1,1)).getLightStatus(), LightStatus.OFF);
	}
	
	@Test
	public void test04() {
		this.board.deleteBox(new Point(2,2));
		assertNull(this.board.getBox(new Point(2,2)));
	}

	@Test
	public void test05() {
		assertNull(this.board.getAvatarPos());
	}
	
	@Test
	public void test06() {
		assertNull(this.board.getBox(new Point(1,1)));
	}
	
	@Test
	public void test07() {
		assertEquals(this.board.getBoxes().length, 2);
	}
	
	@Test
	public void test08() {
		assertEquals(this.board.getLimitsBoard(), new Point(2,2));
	}
	
	@Test
	public void test09() {
		assertEquals(this.board.getListOfLightPos().size(), 0);
	}
	
	@Test
	public void test10() {
		this.board.addBoxAvatar(new Point(2,2), TypeOfBox.WALK, new Avatar());
		assertTrue(this.board.isOcupatePosition(new Point(2,2)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test11() {
		this.board.isOcupatePosition(new Point(3,3));
	}
	
	@Test
	public void test12() {
		this.board.setAvatarPos(new Point(2,2));
		assertEquals(this.board.getAvatarPos(), new Point(2,2));
	}
}
