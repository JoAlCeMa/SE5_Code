package be.odisee.brainstorm2015wa2;

import com.thoughtworks.selenium.*;

public class UCT_RouteToevoegen extends SeleneseTestCase {
	public void setUp() throws Exception {
		setUp("http://localhost:8080/", "*chrome");
	}
	public void testUCT_RouteToevoegen() throws Exception {
		selenium.open("/brainstorm2015WA3/login.html");
		selenium.type("id=username", "gebr@mail.com");
		selenium.type("id=password", "test12");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Gebruiker");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Route Toevoegen");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=naam", "Warmoesberg 26, 1000 Brussel");
		selenium.type("id=breedtegraad", "50.8489532");
		selenium.type("id=lengtegraad", "4.3545146");
		selenium.type("id=type", "Auto");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
	}
}
