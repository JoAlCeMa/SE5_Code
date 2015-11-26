package be.odisee.gebruikers;

import java.util.List;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Stap3StepDefinitions {
	
	WebDriver driver = new FirefoxDriver();
	LoginPage loginpage;
	HomePage homepage;
	ListUsersPage listuserpage;
	UserDetailsPage userdetailpage;
	String gebruikersnaam = "zmiTCWVO31 0tAz4ReUBezEP4X8LHqE";
	
	@Given("^dat ik de details van een gebruiker bekijk$")
	public void dat_ik_de_details_van_een_gebruiker_bekijk() throws Throwable {
		loginpage = new LoginPage(driver);
		loginpage.open();
		homepage = loginpage.login("admin@mail.be", "abc123");
		listuserpage = (ListUsersPage)homepage.chooseRole("Administrator");
		userdetailpage = listuserpage.chooseUser(gebruikersnaam);
		Assert.assertTrue("Niet op de details van een gebruiker geraakt.", userdetailpage.isOnDetailsPage());
	}

	@When("^ik de gebruiker verwijder$")
	public void ik_de_gebruiker_verwijder() throws Throwable {
		listuserpage = userdetailpage.chooseDeleteUser();
	}

	@Then("^moet ik terugkeren naar de lijst van gebruikers$")
	public void moet_ik_terugkeren_naar_de_lijst_van_gebruikers() throws Throwable {
		Assert.assertTrue("Niet op de lijst met gebruikers terechtgekomen", listuserpage.isOnListPage());
	}

	@Then("^is de verwijderde gebruiker niet meer in de lijst$")
	public void is_de_verwijderde_gebruiker_niet_meer_in_de_lijst() throws Throwable {
	    Assert.assertFalse("Gebruiker bestaat nog terwijl hij werd verwijdert.", listuserpage.userExists(gebruikersnaam));
	    listuserpage.CloseBrowser();
	}
}
