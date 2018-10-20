package classProperties;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import configuration.ConstantsTest;

public class MapPropertiesTest {
	private MapProperties mapProperties;
	
	@Before
	public void init() {
		try {
			this.mapProperties = new MapProperties(ConstantsTest.ROUTE_MAP_PROPERTIES);
		} catch (IOException e) {
		}
	}
	
	@Test
	public void test01() {
		this.mapProperties.loadDataProperties();
		assertNotNull(this.mapProperties.getMapConfiguration());
	}

	@Test
	public void test02() {
		try {
			this.mapProperties = new MapProperties(ConstantsTest.ROUTE_MAP_PROPERTIES);
			this.mapProperties.loadProperties(ConstantsTest.ROUTE_MAP_PROPERTIES);
		} catch (IOException e) {
		}
		assertNotNull(this.mapProperties.getMapConfiguration());
	}

	@Test(expected = NullPointerException.class)
	public void test03() {
		try {
			this.mapProperties = new MapProperties(ConstantsTest.ROUTE_MAP_PROPERTIES);
			this.mapProperties.loadProperties(null);
		} catch (IOException e) {
		}
		assertNotNull(this.mapProperties.getMapConfiguration());
	}
	
	@Test
	public void test04() {
		try {
			this.mapProperties = new MapProperties(ConstantsTest.ROUTE_MAP_PROPERTIES);
			this.mapProperties.loadProperties("src/main/resources/properties");
		} catch (IOException e) {
		}
		assertNotNull(this.mapProperties.getMapConfiguration());
	}

	@Test
	public void test05() {
		assertNotNull(this.mapProperties.getPointOfProperties(ConstantsTest.NAME_POSAVATAR_PROPERTIES));
	}

	@Test
	public void test06() {
		assertNotNull(this.mapProperties.loadPositionsOfPoint(ConstantsTest.NAME_POSLIGHT_PROPERTIES));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test07() {
		try {
			this.mapProperties = new MapProperties(ConstantsTest.ROUTE_MAP_INVALID_2_PROPERTIES);
		} catch (IOException e) {
		}
		this.mapProperties.validateProperties();
	}
}
