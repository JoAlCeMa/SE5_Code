package be.odisee.gebruikers;

import org.openqa.selenium.*;

public abstract class AbstractPage {

	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage navigateToLoginPage() {
		driver.navigate().to("http://localhost:8080/brainstorm2015WA3/login");
		return new LoginPage(driver);
	}
	
	public String getPageText() {
		return driver.findElement(By.tagName("body")).getText();
	}
	
	public void CloseBrowser() {
		driver.quit();
	}
}
