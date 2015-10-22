package be.odisee.smoketests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class RouteField extends SeleneseTestCase {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void test4RouteFieldJUnit() throws Exception {
		selenium.open("/brainstorm2015WA3/login.html");
		verifyEquals("Login aub", selenium.getText("css=h1"));
		selenium.type("id=username", "field@mail.com");
		selenium.type("id=password", "test12");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Kies uw Rol aub", selenium.getText("css=h1"));
		selenium.click("link=Field");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Welkom Field Controller", selenium.getText("css=h1"));
		verifyEquals("eenTestroute", selenium.getText("link=eenTestroute"));
		selenium.click("link=eenTestroute");
		selenium.waitForPageToLoad("30000");
		verifyEquals("eenTestroute", selenium.getText("//span[2]"));
		verifyEquals("27.5", selenium.getText("//span[3]"));
		verifyEquals("51.1", selenium.getText("//span[4]"));
		verifyEquals("Fiets", selenium.getText("//span[5]"));
		selenium.click("link=Controle OK");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Welkom Field Controller", selenium.getText("css=h1"));
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Tot weerziens!!!", selenium.getTitle());
		selenium.click("link=Log opnieuw in");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Brainstorm Login", selenium.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}