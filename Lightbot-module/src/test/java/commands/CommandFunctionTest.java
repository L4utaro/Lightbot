package commands;

import static org.junit.Assert.assertNotNull;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import board.Builder;
import model.Map;
import model.Size;

public class CommandFunctionTest {
	private CommandFunction commandFunction;
	private List<Point> posOfPathPossible;

	@Before
	public void init() {
		this.commandFunction = new CommandFunction("fun");
		this.posOfPathPossible = new ArrayList<Point>();
		this.posOfPathPossible.add(new Point(1, 1));
	}

	@Test
	public void test01() {
		this.commandFunction.executeCommand(
				new Map(new Builder(new Size(2, 2)).whitRoadPossible(posOfPathPossible).whitAvatar(new Point(1, 1))));
		assertNotNull(this.commandFunction.getNameFunction());
	}
}
