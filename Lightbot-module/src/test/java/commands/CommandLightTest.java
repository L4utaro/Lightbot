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

public class CommandLightTest {
	private CommandLight commandLight;

	@Before
	public void init() {
		this.commandLight = new CommandLight();
	}

	@Test
	public void test01() {
		List<Point> posOfPathPossible = new ArrayList<Point>();
		posOfPathPossible.add(new Point(1, 1));
		List<Point> posOfLights = new ArrayList<Point>();
		posOfLights.add(new Point(1, 1));
		this.commandLight.executeCommand(new Map(new Builder(new Size(2, 2)).whitRoadPossible(posOfPathPossible)
				.whitLights(posOfLights).whitAvatar(new Point(1, 1))));
		assertNotNull(this.commandLight.getClass());
	}
}
