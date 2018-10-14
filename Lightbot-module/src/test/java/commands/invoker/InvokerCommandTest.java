package commands.invoker;

import static org.junit.Assert.assertNotNull;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import board.Builder;
import commands.CommandLeft;
import commands.CommandRight;
import model.Map;

public class InvokerCommandTest {
	private InvokerCommand invokerCommand;
	private Map map;

	@Before
	public void init() {
		this.invokerCommand = new InvokerCommand(new CommandLeft());
		List<Point> posOfPathPossible = new ArrayList<Point>();
		posOfPathPossible.add(new Point(1, 1));
		this.map = new Map(
				new Builder(new Point(2, 2)).whitRoadPossible(posOfPathPossible).whitAvatar(new Point(1, 1)));
	}

	@Test
	public void test01() {
		this.invokerCommand.executeCommand(this.map);
		this.invokerCommand.setCommand(new CommandRight());
		assertNotNull(this.invokerCommand.getClass());
	}
}
