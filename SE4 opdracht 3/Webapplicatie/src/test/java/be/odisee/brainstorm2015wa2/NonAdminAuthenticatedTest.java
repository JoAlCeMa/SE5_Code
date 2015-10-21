package be.odisee.brainstorm2015wa2;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class NonAdminAuthenticatedTest extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testNonadminAuthenticated() throws Exception {
		selenium.open("/brainstorm2015WA3/login.html");
		selenium.type("id=username", "ayoub@telenet.be");
		selenium.type("id=password", "test21");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Gebruiker", selenium.getText("link=Gebruiker"));
		selenium.click("link=Gebruiker");
		selenium.open("/brainstorm2015WA3/admin/index.html?rolid=8");
		assertEquals("Oeps! Dit mag je niet doen", selenium.getText("css=h1"));
		selenium.click("link=Menu");
		selenium.waitForPageToLoad("30000");
		assertEquals("Gebruiker", selenium.getText("link=Gebruiker"));
		selenium.click("link=Gebruiker");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
