package classProperties;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ActionsConfigurationTest {
	private ActionsConfiguration actionsConfiguration;

	@Before
	public void init() {
		this.actionsConfiguration = new ActionsConfiguration(null, null, null, null);
	}

	@Test
	public void test01() {
		this.actionsConfiguration.setAvanzar(new ArrayList<String>());
		assertNotNull(this.actionsConfiguration.getAvanzar());
	}

	@Test
	public void test02() {
		this.actionsConfiguration.setDerecha(new ArrayList<String>());
		assertNotNull(this.actionsConfiguration.getDerecha());
	}

	@Test
	public void test03() {
		this.actionsConfiguration.setIzquierda(new ArrayList<String>());
		assertNotNull(this.actionsConfiguration.getIzquierda());
	}

	@Test
	public void test04() {
		this.actionsConfiguration.setLuz(new ArrayList<String>());
		assertNotNull(this.actionsConfiguration.getLuz());
	}
}
