package be.odisee.gebruikers;

import org.openqa.selenium.*;

public class ListUsersPage extends AbstractPage {

	public ListUsersPage(WebDriver driver) {
		super(driver);
	}
	
	public UserDetailsPage chooseUser(String username) {
		driver.findElement(By.linkText(username)).click();
		return new UserDetailsPage(driver);
	}
	
	public NewUserPage chooseAddUser() {
		driver.findElement(By.linkText("Persoon Toevoegen")).click();
		return new NewUserPage(driver);
	}
	
	public String getTitle() {
		return driver.findElement(By.tagName("h1")).getText();
	}
	
	public String getList() {
		return driver.findElement(By.tagName("ul")).getText();
	}
	
	public boolean isOnListPage() {
		return this.getTitle().contains("Lijst van de personen");
	}
	
	public boolean userExists(String username) {
		return this.getList().contains(username);
	}
}
