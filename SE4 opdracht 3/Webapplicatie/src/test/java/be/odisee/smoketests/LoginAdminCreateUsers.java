package be.odisee.smoketests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class LoginAdminCreateUsers extends SeleneseTestCase {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testLoginAdminCreateUsersJUnit() throws Exception {
		selenium.open("/brainstorm2015WA3/login");
		assertEquals("Brainstorm Login", selenium.getTitle());
		selenium.type("id=username", "admin@mail.com");
		selenium.type("id=password", "test12");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Kies uw Rol aub", selenium.getText("css=h1"));
		selenium.click("link=Administrator");
		selenium.waitForPageToLoad("30000");
		assertEquals("Lijst van de personen", selenium.getText("css=h1"));
		selenium.click("link=Persoon Toevoegen");
		selenium.waitForPageToLoad("30000");
		assertEquals("Persoon toevoegen", selenium.getText("css=h1"));
		selenium.type("id=voornaam", "gebr");
		selenium.type("id=familienaam", "tester");
		selenium.type("id=emailadres", "gebr@mail.com");
		selenium.type("id=paswoord", "test12");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Details van Gebruiker", selenium.getText("css=h1"));
		assertEquals("gebr", selenium.getText("//span[2]"));
		assertEquals("tester", selenium.getText("//span[3]"));
		assertEquals("gebr@mail.com", selenium.getText("//span[4]"));
		assertEquals("test12", selenium.getText("//span[5]"));
		selenium.click("link=Gebruikers rechten");
		selenium.waitForPageToLoad("30000");
		assertEquals("Lijst van de personen", selenium.getText("css=h1"));
		selenium.click("link=Persoon Toevoegen");
		selenium.waitForPageToLoad("30000");
		assertEquals("Persoon toevoegen", selenium.getText("css=h1"));
		selenium.type("id=voornaam", "comm");
		selenium.type("id=familienaam", "tester");
		selenium.type("id=emailadres", "comm@mail.com");
		selenium.type("id=paswoord", "test12");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Details van Gebruiker", selenium.getText("css=h1"));
		assertEquals("comm", selenium.getText("//span[2]"));
		assertEquals("tester", selenium.getText("//span[3]"));
		assertEquals("comm@mail.com", selenium.getText("//span[4]"));
		assertEquals("test12", selenium.getText("//span[5]"));
		selenium.click("link=Community rechten");
		selenium.waitForPageToLoad("30000");
		assertEquals("Lijst van de personen", selenium.getText("css=h1"));
		selenium.click("link=Persoon Toevoegen");
		selenium.waitForPageToLoad("30000");
		assertEquals("Persoon toevoegen", selenium.getText("css=h1"));
		selenium.type("id=voornaam", "field");
		selenium.type("id=familienaam", "tester");
		selenium.type("id=emailadres", "field@mail.com");
		selenium.type("id=paswoord", "test12");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Details van Gebruiker", selenium.getText("css=h1"));
		assertEquals("field", selenium.getText("//span[2]"));
		assertEquals("tester", selenium.getText("//span[3]"));
		assertEquals("field@mail.com", selenium.getText("//span[4]"));
		assertEquals("test12", selenium.getText("//span[5]"));
		selenium.click("link=Field rechten");
		selenium.waitForPageToLoad("30000");
		assertEquals("Lijst van de personen", selenium.getText("css=h1"));
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Tot weerziens!!!", selenium.getTitle());
		selenium.click("link=Log opnieuw in");
		selenium.waitForPageToLoad("30000");
		assertEquals("Brainstorm Login", selenium.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}