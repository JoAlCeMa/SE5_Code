package be.odisee.brainstorm2015wa2;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class GebruikerVoegtRouteToe extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testGebruikerVoegtRouteToe() throws Exception {
	
		selenium.open("/brainstorm2015WA3/login.html");
		selenium.type("id=username", "");
		selenium.type("id=username", "ayoub@telenet.be");
		selenium.type("id=password", "test21");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Gebruiker", selenium.getText("link=Gebruiker"));
		selenium.click("link=Gebruiker");
		selenium.waitForPageToLoad("30000");
		assertEquals("Route Toevoegen", selenium.getText("link=Route Toevoegen"));
		selenium.click("link=Route Toevoegen");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=naam", "Jefstraat");
		selenium.type("id=breedtegraad", "35");
		selenium.type("id=lengtegraad", "35");
		selenium.type("id=type", "asfalt");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Naam:", selenium.getText("//b[2]"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
