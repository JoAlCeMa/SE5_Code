package be.odisee.smoketests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class RouteMaken extends SeleneseTestCase {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void test2RouteMakenJUnit() throws Exception {
		selenium.open("/brainstorm2015WA3/login.html");
		selenium.type("id=username", "gebr@mail.com");
		selenium.type("id=password", "test12");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Kies uw Rol aub", selenium.getText("css=h1"));
		selenium.click("link=Gebruiker");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Welkom in de TomTom kaarten lijst", selenium.getText("css=h1"));
		selenium.click("link=Route Toevoegen");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Route toevoegen", selenium.getText("css=h1"));
		selenium.type("id=naam", "eenTestroute");
		selenium.type("id=breedtegraad", "51.1");
		selenium.type("id=lengtegraad", "27.5");
		selenium.type("id=type", "Fiets");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Details van route", selenium.getText("css=h1"));
		verifyEquals("eenTestroute", selenium.getText("//span[2]"));
		verifyEquals("27.5", selenium.getText("//span[3]"));
		verifyEquals("51.1", selenium.getText("//span[4]"));
		verifyEquals("Fiets", selenium.getText("//span[5]"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Welkom in de TomTom kaarten lijst", selenium.getText("css=h1"));
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Bedankt om de TomTomApllicatie te gebruiken", selenium.getText("css=h1"));
		selenium.click("link=Log opnieuw in");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Login aub", selenium.getText("css=h1"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}