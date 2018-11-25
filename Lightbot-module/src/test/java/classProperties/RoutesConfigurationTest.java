package classProperties;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RoutesConfigurationTest {
	private RoutesConfiguration routesConfiguration;

	@Test
	public void test01() {
		this.routesConfiguration = new RoutesConfiguration("test");
		this.routesConfiguration.setRouteFolderOfActions("test02");
		assertEquals("test02", this.routesConfiguration.getRouteFolderOfActions());
	}
}
