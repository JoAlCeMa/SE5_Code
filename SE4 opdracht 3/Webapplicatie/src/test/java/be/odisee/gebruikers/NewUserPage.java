package be.odisee.gebruikers;

import org.openqa.selenium.*;

public class NewUserPage extends AbstractPage {

	public NewUserPage(WebDriver driver) {
		super(driver);
	}
	
	public NewUserPage fillFirstName(String firstName) {
		driver.findElement(By.id("voornaam")).sendKeys(firstName);
		return this;
	}
	
	public NewUserPage fillLastName(String lastname) {
		driver.findElement(By.id("familienaam")).sendKeys(lastname);
		return this;
	}
	
	public NewUserPage fillemailAddress(String emailAddress) {
		driver.findElement(By.id("emailadres")).sendKeys(emailAddress);
		return this;
	}
	
	public NewUserPage fillPassword(String password) {
		driver.findElement(By.id("paswoord")).sendKeys(password);
		return this;
	}
	
	public UserDetailsPage submitUser() {
		driver.findElement(By.name("submit")).click();
		return new UserDetailsPage(driver);
	}
}
