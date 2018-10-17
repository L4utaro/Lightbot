package validators;

import static org.junit.Assert.assertFalse;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

public class ValidatorPropertiesTest {
	private ValidatorProperties validatorProperties;
	private Properties properties;
	
	@Before
	public void init() {
		this.properties = new Properties();
		this.validatorProperties = new ValidatorProperties(this.properties);
	}

	@Test
	public void test01() {
		assertFalse(this.validatorProperties.isAValidProperties());
	}
}
