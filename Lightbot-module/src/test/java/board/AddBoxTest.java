package board;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import enums.LightStatus;
import enums.TypeOfBox;
import model.Avatar;
import model.Board;

public class AddBoxTest {
	private AddBox addBox;
	private Board board;
	
	@Before()
	public void init() {
		this.board = new Board(new Point(3,3));
		this.addBox = new AddBox(board);
	}

	@Test
	public void autoCompleteBoxesEmptyTest() {
		this.addBox.addBoxWalk(new Point(1,1));
		this.addBox.autoCompleteBoxesEmpty();
		assertTrue(this.board.getBox(new Point(1,1)).getTypeOfBox().equals(TypeOfBox.NO_WALK));
	}
	
	@Test
	public void addBoxWalkTest() {
		this.addBox.addBoxWalk(new Point(1,1));
		assertTrue(this.board.getBox(new Point(1,1)).getTypeOfBox().equals(TypeOfBox.WALK));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addFailBoxWalkTest() {
		List<Point> positionsWalks = new ArrayList<Point>();
		positionsWalks.add(new Point (4,4));
		this.addBox.addBoxesWalk(positionsWalks);
	}

	@Test
	public void addBoxNoWalkTest() {
		this.addBox.addBoxNoWalk(new Point(1,1));
		assertTrue(this.board.getBox(new Point(1,1)).getTypeOfBox().equals(TypeOfBox.NO_WALK));
	}
	
	@Test
	public void addBoxesWalkTest() {
		List<Point> positionsWalks = new ArrayList<Point>();
		positionsWalks.add(new Point (2,2));
		this.addBox.addBoxesWalk(positionsWalks);
		assertTrue(this.board.getBox(new Point(2,2)).getTypeOfBox().equals(TypeOfBox.WALK));
	}
	
	@Test
	public void addObjectGraphicTest() {
		this.addBox.addBoxWalk(new Point(2,2));
		this.addBox.addObjectGraphic(new Point(2,2), new Avatar());
		assertNotNull(this.board.getBox(new Point(2,2)).getObjectGraphic());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addInvalidObjectGraphicTest() {
		this.addBox.addBoxWalk(new Point(2,2));
		this.addBox.addObjectGraphic(new Point(2,3), new Avatar());
	}
	
	@Test
	public void addLightsTest() {
		this.addBox.addBoxWalk(new Point(1,1));
		List<Point> posOfLights = new ArrayList<Point>();
		posOfLights.add(new Point (1,1));
		this.addBox.addLights(posOfLights, LightStatus.OFF);
		assertNotNull(this.board.getBox(new Point(1,1)).getLightStatus());
	}

	@Test(expected = IllegalArgumentException.class)
	public void addInvalidLightsTest() {
		this.addBox.addBoxWalk(new Point(1,1));
		List<Point> posOfLights = new ArrayList<Point>();
		posOfLights.add(new Point (2,3));
		this.addBox.addLights(posOfLights, LightStatus.OFF);
		assertNotNull(this.board.getBox(new Point(1,1)).getLightStatus());
	}
	
	@Test
	public void validateTruePositionsTest() {
		this.addBox.addBoxWalk(new Point(3,2));
		List<Point> positionsOfStructure = new ArrayList<Point>();
		positionsOfStructure.add(new Point (3,2));
		assertTrue(this.addBox.validatePositions(positionsOfStructure));
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateFalsePositionsTest() {
		this.addBox.addObjectGraphic(new Point(2,1), new Avatar());
		List<Point> positionsOfStructure = new ArrayList<Point>();
		positionsOfStructure.add(new Point (1,1));
		positionsOfStructure.add(new Point (2,1));
		positionsOfStructure.add(new Point (3,1));
		assertFalse(this.addBox.validatePositions(positionsOfStructure));
	}

	@Test
	public void getBoardTest() {
		assertNotNull(this.addBox.getBoard());
	}
}
