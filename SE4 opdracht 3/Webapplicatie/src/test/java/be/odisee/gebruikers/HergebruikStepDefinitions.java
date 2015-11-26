package be.odisee.gebruikers;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HergebruikStepDefinitions {
	
	WebDriver driver = new FirefoxDriver();
	LoginPage loginpage;
	HomePage homepage;
	ListUsersPage listuserpage;
	UserDetailsPage userdetailpage;
	NewUserPage newuserpage;
	String voornaam = "zmiTCWVO31";
	String achternaam = "0tAz4ReUBezEP4X8LHqE";
	String wachtwoord = "abc123";

	@Given("^dat ik een gebruiker toevoeg met correcte gegevens$")
	public void dat_ik_een_gebruiker_toevoeg_met_correcte_gegevens() throws Throwable {
		loginpage = new LoginPage(driver);
		loginpage.open();
		homepage = loginpage.login("admin@mail.be", "abc123");
		listuserpage = (ListUsersPage)homepage.chooseRole("Administrator");
		newuserpage = listuserpage.chooseAddUser();
		newuserpage.fillFirstName(voornaam)
					.fillLastName(achternaam)
					.fillemailAddress(voornaam + "@mail.be")
					.fillPassword(wachtwoord);
	}

	@When("^ik de gebruiker opsla$")
	public void ik_de_gebruiker_opsla() throws Throwable {
		userdetailpage = newuserpage.submitUser();
	}

	@Then("^moet ik de details van gebruiker zien$")
	public void moet_ik_de_details_van_gebruiker_zien() throws Throwable {
	    Assert.assertTrue("Niet op de detailpagina van de gebruiker beland.", userdetailpage.isOnDetailsPage());
	}

	@Then("^staat de net toegevoegde gebruiker in de lijst van alle gebruikers$")
	public void staat_de_net_toegevoegde_gebruiker_in_de_lijst_van_alle_gebruikers() throws Throwable {
	    listuserpage = userdetailpage.chooseHome();
	    Assert.assertTrue("De gebruiker werd niet toegevoegd.", listuserpage.userExists(voornaam + " " + achternaam));
	    listuserpage.CloseBrowser();
	}
}
