package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import enums.LightStatus;
import enums.TypeOfBox;

public class BoxTest {
	private Box box;

	@Before
	public void init() {
		this.box = new Box(TypeOfBox.WALK, LightStatus.OFF);
	}

	@Test
	public void test01() {
		this.box.changeStateLight();
		assertEquals(this.box.getLightStatus(), LightStatus.ON);
	}

	@Test
	public void test02() {
		this.box.setObjectGraphic(new Avatar());
		assertNotNull(this.box.getObjectGraphic());
	}

	@Test
	public void test03() {
		assertEquals(this.box.getTypeOfBox(), TypeOfBox.WALK);
	}

	@Test
	public void test04() {
		this.box.setTypeOfBox(TypeOfBox.NO_WALK);
		assertEquals(this.box.getTypeOfBox(), TypeOfBox.NO_WALK);
	}
	
	@Test
	public void test05() {
		this.box.setLightStatus(LightStatus.ON);
		assertEquals(this.box.getLightStatus(), LightStatus.ON);
	}
}
