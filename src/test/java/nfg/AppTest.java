package nfg;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nfg.controller.HomeController;

public class AppTest {
	
	@Test
	public void testApp() {
		HomeController hc = new HomeController();
		String result = hc.home();
		assertEquals(result, "Spring Application Running...");
	}
}
