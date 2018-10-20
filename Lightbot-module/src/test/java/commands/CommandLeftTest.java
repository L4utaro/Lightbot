package commands;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import board.Builder;
import enums.Orientation;
import model.Map;
import model.Size;

public class CommandLeftTest {
	private CommandLeft commandLeft;
	
	@Before
	public void init() {
		this.commandLeft = new CommandLeft();
	}
	
	@Test
	public void test01() {
		List<Point> posOfPathPossible = new ArrayList<Point>();
		posOfPathPossible.add(new Point(1,1));
		this.commandLeft.executeCommand(new Map(new Builder(new Size(2,2)).whitRoadPossible(posOfPathPossible).whitAvatar(new Point(1,1))));
		assertNotNull(this.commandLeft.getNewOrientation(Orientation.RIGHT));
	}

	@Test
	public void test02() {
		List<Point> posOfPathPossible = new ArrayList<Point>();
		posOfPathPossible.add(new Point(1,1));
		this.commandLeft.executeCommand(new Map(new Builder(new Size(2,2)).whitRoadPossible(posOfPathPossible).whitAvatar(new Point(1,1))));
		assertNotNull(this.commandLeft.getNewOrientation(Orientation.UP));
	}

	@Test
	public void test03() {
		List<Point> posOfPathPossible = new ArrayList<Point>();
		posOfPathPossible.add(new Point(1,1));
		this.commandLeft.executeCommand(new Map(new Builder(new Size(2,2)).whitRoadPossible(posOfPathPossible).whitAvatar(new Point(1,1))));
		assertNotNull(this.commandLeft.getNewOrientation(Orientation.LEFT));
	}

	@Test
	public void test04() {
		List<Point> posOfPathPossible = new ArrayList<Point>();
		posOfPathPossible.add(new Point(1,1));
		this.commandLeft.executeCommand(new Map(new Builder(new Size(2,2)).whitRoadPossible(posOfPathPossible).whitAvatar(new Point(1,1))));
		assertNotNull(this.commandLeft.getNewOrientation(Orientation.DOWN));
	}

	@Test(expected = NullPointerException.class)
	public void test05() {
		List<Point> posOfPathPossible = new ArrayList<Point>();
		posOfPathPossible.add(new Point(1,1));
		this.commandLeft.executeCommand(new Map(new Builder(new Size(2,2)).whitRoadPossible(posOfPathPossible).whitAvatar(new Point(1,1))));
		assertNull(this.commandLeft.getNewOrientation(null));
	}
}
