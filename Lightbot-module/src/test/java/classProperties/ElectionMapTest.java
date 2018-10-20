package classProperties;

import static org.junit.Assert.assertNotNull;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Size;

public class ElectionMapTest {
	private MapConfiguration mapConfiguration;

	@Before
	public void init() {
		List<Point> posLight = new ArrayList<Point>();
		posLight.add(new Point(3,3));
		List<Point> posOfPathPossible = new ArrayList<Point>();
		posOfPathPossible.add(new Point(1,1));
		posOfPathPossible.add(new Point(1,2));
		this.mapConfiguration = new MapConfiguration(new Size(3, 3), new Point(1, 1), posLight, posOfPathPossible);
	}
	
	@Test
	public void test01() {
		this.mapConfiguration.setMapSize(new Size(2,2));
		assertNotNull(this.mapConfiguration.getMapSize());
	}

	@Test
	public void test02() {
		this.mapConfiguration.setPosAvatar(new Point(2,2));
		assertNotNull(this.mapConfiguration.getPosAvatar());
	}

	@Test
	public void test03() {
		List<Point> posLight = new ArrayList<Point>();
		posLight.add(new Point(2,2));
		this.mapConfiguration.setPosLight(posLight);
		assertNotNull(this.mapConfiguration.getPosLight());
	}

	@Test
	public void test04() {
		List<Point> posOfPathPossible = new ArrayList<Point>();
		posOfPathPossible.add(new Point(2,3));
		posOfPathPossible.add(new Point(3,3));
		this.mapConfiguration.setPosOfPathPossible(posOfPathPossible);
		assertNotNull(this.mapConfiguration.getPosOfPathPossible());
	}
}
