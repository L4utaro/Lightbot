package classProperties;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import main.Constants;

public class MapPropertiesTest {
	private MapProperties mapProperties;
	
	@Before
	public void init() {
		this.mapProperties = new MapProperties(Constants.ROUTE_MAP_PROPERTIES);
	}
	
	@Test
	public void test01() {
		this.mapProperties.loadDataProperties();
		assertNotNull(this.mapProperties.getElectionMap());
	}

	@Test
	public void test02() {
		this.mapProperties = new MapProperties(Constants.ROUTE_MAP_PROPERTIES);
		this.mapProperties.loadProperties(Constants.ROUTE_MAP_PROPERTIES);
		assertNotNull(this.mapProperties.getElectionMap());
	}

	@Test(expected = NullPointerException.class)
	public void test03() {
		this.mapProperties = new MapProperties(Constants.ROUTE_MAP_PROPERTIES);
		this.mapProperties.loadProperties(null);
		assertNotNull(this.mapProperties.getElectionMap());
	}
	
	@Test
	public void test04() {
		this.mapProperties = new MapProperties(Constants.ROUTE_MAP_PROPERTIES);
		this.mapProperties.loadProperties("src/main/resources/properties");
		assertNotNull(this.mapProperties.getElectionMap());
	}

	@Test
	public void test05() {
		assertNotNull(this.mapProperties.getPointOfProperties(Constants.NAME_POSAVATAR_PROPERTIES));
	}

	@Test
	public void test06() {
		assertNotNull(this.mapProperties.loadPositionsOfPoint(Constants.NAME_POSLIGHT_PROPERTIES));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test07() {
		this.mapProperties = new MapProperties(Constants.ROUTE_MAP_INVALID_2_PROPERTIES);
		this.mapProperties.validateProperties();
	}
}
