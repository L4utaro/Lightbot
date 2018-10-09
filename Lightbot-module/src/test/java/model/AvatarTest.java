package model;

import org.junit.Before;
import org.junit.Test;

public class AvatarTest {
	private Avatar avatar;
	
	@Before
	public void init() {
		this.avatar = new Avatar();
	}
	
	@Test
	public void test01() {
		this.avatar.getNumOfOrientation();
	}
}
