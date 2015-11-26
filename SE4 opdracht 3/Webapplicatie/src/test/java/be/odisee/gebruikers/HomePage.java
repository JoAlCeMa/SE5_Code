package be.odisee.gebruikers;

import org.openqa.selenium.*;

public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public AbstractPage chooseRole(String rolename) {
		driver.findElement(By.linkText(rolename)).click();
		if (rolename.equals("Administrator")) {
			return new ListUsersPage(driver);
		}
		return null;
	}
}
