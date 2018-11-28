package classProperties;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import configuration.ConstantsTest;

public class ActionsPropertiesTest {
private ActionsProperties actionsProperties;
	
	@Before
	public void init() {
		try {
			this.actionsProperties = new ActionsProperties(ConstantsTest.ROUTE_CONFIGURATION_ACTIONS);
		} catch (IOException e) {
		}
	}
	
	@Test
	public void test01() {
		this.actionsProperties.loadDataProperties();
		assertNotNull(this.actionsProperties.getActionsConfiguration());
	}

	@Test
	public void test02() {
		try {
			this.actionsProperties = new ActionsProperties(ConstantsTest.ROUTE_CONFIGURATION_ACTIONS);
			this.actionsProperties.loadProperties(ConstantsTest.ROUTE_CONFIGURATION_ACTIONS);
		} catch (IOException e) {
		}
		assertNotNull(this.actionsProperties.getActionsConfiguration());
	}

	@Test(expected = NullPointerException.class)
	public void test03() {
		try {
			this.actionsProperties = new ActionsProperties(ConstantsTest.ROUTE_CONFIGURATION_ACTIONS);
			this.actionsProperties.loadProperties(null);
		} catch (IOException e) {
		}
		assertNotNull(this.actionsProperties.getActionsConfiguration());
	}
	
	@Test
	public void test04() {
		try {
			this.actionsProperties = new ActionsProperties(ConstantsTest.ROUTE_CONFIGURATION_ACTIONS);
			this.actionsProperties.loadProperties("src/main/resources/properties");
		} catch (IOException e) {
		}
		assertNotNull(this.actionsProperties.getActionsConfiguration());
	}

	@Test
	public void test05() {
		this.actionsProperties.loadActionsOfString("avanzar");
		this.actionsProperties.loadDataProperties();
		assertNotNull(this.actionsProperties.getActionsConfiguration());
	}
}
