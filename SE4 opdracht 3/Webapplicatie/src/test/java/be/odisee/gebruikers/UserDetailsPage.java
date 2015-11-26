package be.odisee.gebruikers;

import org.openqa.selenium.*;

public class UserDetailsPage extends AbstractPage {

	public UserDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public ListUsersPage chooseDeleteUser() {
		driver.findElement(By.linkText("Verwijder persoon")).click();
		return new ListUsersPage(driver);
	}
	
	public ListUsersPage chooseHome() {
		driver.findElement(By.linkText("Admin Home")).click();
		return new ListUsersPage(driver);
	}
	
	public String getTitle() {
		return driver.findElement(By.tagName("h1")).getText();
	}
	
	public boolean isOnDetailsPage() {
		return this.getTitle().contains("Details van Gebruiker");
	}
}
