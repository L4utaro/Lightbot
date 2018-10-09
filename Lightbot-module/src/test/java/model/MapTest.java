package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import board.Builder;
import enums.LightStatus;
import enums.TypeOfBox;

public class MapTest {
	private Map map;
	
	@Before
	public void init() {
		this.map = new Map(new Builder(new Point(2,2)));
	}

	@Test
	public void test01() {
		this.map.addBoxAvatar(new Point(1,1), TypeOfBox.WALK, new Avatar());
		assertNotNull(this.map.getBox(new Point(1,1)).getObjectGraphic());
		assertEquals(this.map.getAvatarPos(), new Point(1,1));
	}

	@Test
	public void test02() {
		this.map.addBoxLight(new Point(2,2), TypeOfBox.WALK, LightStatus.OFF);
		assertEquals(this.map.getBox(new Point(2,2)).getLightStatus(), LightStatus.OFF);
	}

	@Test
	public void test03() {
		this.map.addBoxObjectGraphic(new Point(1,1), new Avatar());
		assertNotNull(this.map.getBox(new Point(1,1)).getObjectGraphic());
	}

	@Test
	public void test04() {
		this.map.deleteObjectGraphic(new Point(1,1));
		assertNull(this.map.getBox(new Point(1,1)).getObjectGraphic());
	}
	
	@Test
	public void test05() {
		this.map.deleteBox(new Point(1,1));
		assertNull(this.map.getBox(new Point(1,1)));
	}
	
	@Test
	public void test06() {
		this.map.setAvatarPos(new Point(2,2));
		assertEquals(this.map.getAvatarPos(), new Point(2,2));
	}
	
	@Test
	public void test07() {
		assertNotNull(this.map.getBoard());
	}
	
	@Test
	public void test08() {
		assertEquals(this.map.getLimitsBoard(), new Point(2,2));
	}

	@Test
	public void test09() {
		this.map.addBoxObjectGraphic(new Point(1,1), new Avatar());
		assertTrue(this.map.isOcupatePosition(new Point(1,1)));
	}

}
