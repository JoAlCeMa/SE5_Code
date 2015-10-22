package be.odisee.brainstorm2015wa2;

import com.thoughtworks.selenium.*;

public class DTT_Nieuwe_Route_Doorsturen extends SeleneseTestCase {
	public void setUp() throws Exception {
		setUp("http://localhost:8080/", "*chrome");
	}
	public void testDTT_Nieuwe_Route_Doorsturen() throws Exception {
		selenium.open("/brainstorm2015WA3/login.html");
		selenium.type("id=username", "jommke@gmail.com");
		selenium.type("id=password", "jom123");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Gebruiker");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Route Toevoegen");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=naam", "wandelroute");
		selenium.type("id=breedtegraad", "23");
		selenium.type("id=lengtegraad", "4.3545146");
		selenium.type("id=type", "Wandelroute");
		selenium.type("id=afstand", "5");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Log opnieuw in");
		selenium.waitForPageToLoad("30000");
	}
}
