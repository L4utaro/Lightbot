package board;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import configuration.ConstantsTest;

public class CreateMapTest {
	private CreateMap createMap;
	
	@Before
	public void init() {
		try {
			this.createMap = new CreateMap(ConstantsTest.ROUTE_MAP_PROPERTIES);
		} catch (IOException e) {
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test01() {
		try {
			this.createMap = new CreateMap(ConstantsTest.ROUTE_MAP_INVALID_1_PROPERTIES);
		} catch (IOException e) {
		}
		this.createMap.validateMapAndProperties();
	}
	
	@Test
	public void test02() {
		this.createMap.createMap();
		assertNotNull(this.createMap.getMap());
		assertNotNull(this.createMap.getMapProperties());
	}
}
