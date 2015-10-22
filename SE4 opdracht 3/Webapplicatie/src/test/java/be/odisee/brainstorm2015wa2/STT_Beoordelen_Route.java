package be.odisee.brainstorm2015wa2;

import com.thoughtworks.selenium.*;

public class STT_Beoordelen_Route extends SeleneseTestCase {
	public void setUp() throws Exception {
		setUp("http://localhost:8080/", "*chrome");
	}
	public void testSTT_Beoordelen_Route() throws Exception {
		selenium.open("/brainstorm2015WA3/login.html");
		selenium.type("id=username", "a@a.com");
		selenium.type("id=password", "aaaaaa");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Gebruiker");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Route Toevoegen");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=naam", "vlagenroute");
		selenium.type("id=breedtegraad", "12");
		selenium.type("id=lengtegraad", "21");
		selenium.type("id=type", "AUTO");
		selenium.type("id=afstand", "12");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Route Toevoegen");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=naam", "pattatenroute");
		selenium.type("id=breedtegraad", "34");
		selenium.type("id=lengtegraad", "5");
		selenium.type("id=type", "fiets");
		selenium.type("id=afstand", "34");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Verander Route");
		selenium.waitForPageToLoad("30000");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Log opnieuw in");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=username", "com@com.com");
		selenium.type("id=password", "com123");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Community");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=vlagenroute");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Controle OK");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=pattatenroute");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Verwijder");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Log opnieuw in");
		selenium.waitForPageToLoad("30000");
	}
}
