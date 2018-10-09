package board;

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
	
	@Test
	public void addLightsTest() {
		this.addBox.addBoxWalk(new Point(1,1));
		List<Point> posOfLights = new ArrayList<Point>();
		posOfLights.add(new Point (1,1));
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

	@Test
	public void validateFalsePositionsTest() {
		List<Point> positionsOfStructure = new ArrayList<Point>();
		positionsOfStructure.add(new Point (1,1));
		assertTrue(this.addBox.validatePositions(positionsOfStructure));
	}
}
