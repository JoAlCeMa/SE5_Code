package be.odisee.brainstorm2015wa2;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdminAuthenticatedAddOnePersonTest extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testAdminpersonentoevoegen() throws Exception {
		selenium.open("/brainstorm2015WA3/login.html");
		selenium.type("id=username", "bram.vandenbogaerde@gmail.com");
		selenium.type("id=password", "test");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Administrator", selenium.getText("link=Administrator"));
		selenium.click("link=Administrator");
		selenium.waitForPageToLoad("30000");
		assertEquals("Lijst van de personen", selenium.getText("css=h1"));
		selenium.click("link=Persoon Toevoegen");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=voornaam", "steve");
		selenium.type("id=familienaam", "jobs");
		selenium.type("id=emailadres", "stevejobs@");
		selenium.type("id=paswoord", "apple");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Vul een geldig e-mail adres in", selenium.getText("id=emailadres.errors"));
		assertEquals("Paswoord is minstens 6 letters aub", selenium.getText("id=paswoord.errors"));
		selenium.type("id=emailadres", "stevejobs@.com");
		selenium.type("id=paswoord", "apples");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=emailadres", "stevejobs@apple.com");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("E-mailadres:", selenium.getText("//b[4]"));
		selenium.click("link=Admin Home");
		selenium.waitForPageToLoad("30000");
		assertEquals("steve jobs", selenium.getText("//a[contains(text(),'steve\n                        jobs')]"));
		selenium.click("link=Menu");
		selenium.waitForPageToLoad("30000");

	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
