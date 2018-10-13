package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import enums.Orientation;

public class AvatarTest {
	private Avatar avatar;

	@Before
	public void init() {
		this.avatar = new Avatar();
	}

	@Test
	public void test01() {
		this.avatar.setOrientation(Orientation.UP);
		assertEquals(this.avatar.getOrientation(), Orientation.UP);
	}
}
