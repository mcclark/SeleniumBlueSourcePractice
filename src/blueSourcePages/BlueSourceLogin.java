package blueSourcePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlueSourceLogin extends GeneralPage {

	/**
	 * Constructor for the bluesource login page
	 * 
	 * @param driver
	 */
	public BlueSourceLogin(WebDriver driver) {
		super(driver);
	}

	/**
	 * Enter the user into the username field
	 * 
	 * @param user
	 */
	public void enterUser(String firstName, String lastName) {
		String user;
		user = firstName + "." + lastName;
		user = user.toLowerCase();
		driver.findElement(By.name("employee[username]")).sendKeys(user);
	}

	/**
	 * Enter the password into the password field
	 * 
	 * @param password
	 */
	public void enterPassword(String password) {
		driver.findElement(By.name("employee[password]")).sendKeys(password);
	}

	/**
	 * Clicks the Login button
	 * 
	 * @return BlueMain
	 */
	public BlueMain submitLogin() {
		driver.findElement(By.name("commit")).click();
		return new BlueMain(driver);
	}

	/**
	 * Logs in when given complete info
	 * 
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @return
	 */
	public BlueMain completeLogin(String firstName, String lastName,
			String password) {
		enterUser(firstName, lastName);
		enterPassword(password);
		submitLogin();
		return new BlueMain(driver);
	}
}
