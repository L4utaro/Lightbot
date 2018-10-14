package classProperties;

import static org.junit.Assert.assertNotNull;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ElectionMapTest {
	private ElectionMap electionMap;

	@Before
	public void init() {
		List<Point> posLight = new ArrayList<Point>();
		posLight.add(new Point(3,3));
		List<Point> posOfPathPossible = new ArrayList<Point>();
		posOfPathPossible.add(new Point(1,1));
		posOfPathPossible.add(new Point(1,2));
		this.electionMap = new ElectionMap(new Point(3, 3), new Point(1, 1), posLight, posOfPathPossible);
	}
	
	@Test
	public void test01() {
		this.electionMap.setMapSize(new Point(2,2));
		assertNotNull(this.electionMap.getMapSize());
	}

	@Test
	public void test02() {
		this.electionMap.setPosAvatar(new Point(2,2));
		assertNotNull(this.electionMap.getPosAvatar());
	}

	@Test
	public void test03() {
		List<Point> posLight = new ArrayList<Point>();
		posLight.add(new Point(2,2));
		this.electionMap.setPosLight(posLight);
		assertNotNull(this.electionMap.getPosLight());
	}

	@Test
	public void test04() {
		List<Point> posOfPathPossible = new ArrayList<Point>();
		posOfPathPossible.add(new Point(2,3));
		posOfPathPossible.add(new Point(3,3));
		this.electionMap.setPosOfPathPossible(posOfPathPossible);
		assertNotNull(this.electionMap.getPosOfPathPossible());
	}
}
