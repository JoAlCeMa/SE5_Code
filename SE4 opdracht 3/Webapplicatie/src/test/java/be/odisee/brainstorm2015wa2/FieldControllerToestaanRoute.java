package be.odisee.brainstorm2015wa2;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class FieldControllerToestaanRoute extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testFieldControllerToestaanRoute() throws Exception {
		selenium.open("/brainstorm2015WA3/login.html");
		selenium.type("id=username", "pam@telenet.be");
		selenium.type("id=password", "test21");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Field", selenium.getText("link=Field"));
		selenium.click("link=Field");
		selenium.waitForPageToLoad("30000");
		assertEquals("Lijst van te controleren routes", selenium.getText("css=h2"));
		assertEquals("odiseestraat", selenium.getText("link=odiseestraat"));
		selenium.click("link=odiseestraat");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Controle OK");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
