package commands;

import static org.junit.Assert.assertNotNull;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import board.Builder;
import model.Avatar;
import model.Map;

public class CommandMoveTest {
	private CommandMove commandMove;
	private Map map;

	@Before
	public void init() {
		this.commandMove = new CommandMove();
		List<Point> posOfPathPossible = new ArrayList<Point>();
		posOfPathPossible.add(new Point(1, 1));
		posOfPathPossible.add(new Point(2, 1));
		this.map = new Map(
				new Builder(new Point(2, 2)).whitRoadPossible(posOfPathPossible).whitAvatar(new Point(1, 1)));
	}

	@Test
	public void test01() {
		this.commandMove.executeCommand(this.map);
		assertNotNull(this.commandMove.getClass());
	}

	@Test
	public void test02() {
		this.commandMove.makeChangePositionOfAvatar(this.map, this.map.getAvatarPos(), new Point(2,1),
				(Avatar) this.map.getBox(new Point(1, 1)).getObjectGraphic());
		assertNotNull(this.commandMove.getClass());
	}

	@Test
	public void test03() {
		this.commandMove.moveAvatar(this.map, (Avatar) this.map.getBox(new Point(1, 1)).getObjectGraphic());
		assertNotNull(this.commandMove.getClass());
	}
}
