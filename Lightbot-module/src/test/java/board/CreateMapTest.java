package board;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import main.Constants;

public class CreateMapTest {
	private CreateMap createMap;
	
	@Before
	public void init() {
		this.createMap = new CreateMap(Constants.ROUTE_MAP_PROPERTIES);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test01() {
		this.createMap = new CreateMap(Constants.ROUTE_MAP_INVALID_1_PROPERTIES);
		this.createMap.validateMapAndProperties();
	}
	
	@Test
	public void test02() {
		this.createMap.createMap();
		assertNotNull(this.createMap.getMap());
		assertNotNull(this.createMap.getMapProperties());
	}
}
