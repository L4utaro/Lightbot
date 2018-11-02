package lectors;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import configuration.Constants;

public class LectorFolderTest {
	private LectorFolder lectorFolder;
	
	@Test
	public void test01() {
		this.lectorFolder = new LectorFolder(Constants.ROUTE_ACTIONS);
		assertNotNull(this.lectorFolder.getRoutesOfActions());
	}

	@Test(expected=IllegalArgumentException.class)
	public void test02() {
		this.lectorFolder = new LectorFolder("C:\\ProgramData\\Acti");
		assertNotNull(this.lectorFolder.getRoutesOfActions());
	}
}
