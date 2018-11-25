package classProperties;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import configuration.ConstantsTest;

public class RoutesPropertiesTest {
	private RoutesProperties routesProperties;
	
	@Before
	public void init() throws IOException {
		this.routesProperties = new RoutesProperties(ConstantsTest.ROUTE_ROUTES_CONFIGURATION_PROPERTIES);
	}
	
	@Test
	public void test01() throws IOException {
		this.routesProperties.loadProperties(ConstantsTest.ROUTE_ROUTES_CONFIGURATION_PROPERTIES);
		assertNotNull(this.routesProperties.getRoutesConfiguration());
	}

	@Test (expected = IOException.class)
	public void test02() throws IOException {
		this.routesProperties.loadProperties("src/main/resources");
		assertNotNull(this.routesProperties.getRoutesConfiguration());
	}
	
	@Test
	public void test03() throws IOException {
		this.routesProperties.loadProperties(ConstantsTest.ROUTE_ROUTES_CONFIGURATION_PROPERTIES);
		this.routesProperties.loadDataProperties();
		assertNotNull(this.routesProperties.getRoutesConfiguration());
	}
}
