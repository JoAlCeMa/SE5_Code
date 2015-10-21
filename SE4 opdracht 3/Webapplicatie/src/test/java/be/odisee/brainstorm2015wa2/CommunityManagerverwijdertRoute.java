package be.odisee.brainstorm2015wa2;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class CommunityManagerverwijdertRoute extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testCommunityManagerverwijdertRoute() throws Exception {
		selenium.open("/brainstorm2015WA3/login.html");
		selenium.type("id=username", "");
		selenium.type("id=username", "enzo@proximus.be");
		selenium.type("id=password", "test21");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Community", selenium.getText("link=Community"));
		selenium.click("link=Community");
		selenium.waitForPageToLoad("30000");
		assertEquals("Lijst van te controleren routes", selenium.getText("css=h2"));
		assertEquals("Jefstraat", selenium.getText("link=Jefstraat"));
		selenium.click("link=Jefstraat");
		selenium.waitForPageToLoad("30000");
		assertEquals("Naam:", selenium.getText("//b[2]"));
		selenium.click("link=Verwijder");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
