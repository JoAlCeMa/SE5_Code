package be.odisee.gebruikers;

import org.openqa.selenium.*;

public class LoginPage extends AbstractPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void open() {
		this.navigateToLoginPage();
	}
	
	public void fillUsername(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}
	
	public void fillPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	public void submitCredentials() {
		driver.findElement(By.id("submit")).click();
	}
	
	public HomePage login(String username, String password) {
		this.fillUsername(username);
		this.fillPassword(password);
		this.submitCredentials();
		return new HomePage(driver);
	}
}
