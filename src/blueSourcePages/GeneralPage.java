package blueSourcePages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public abstract class GeneralPage {
	public String url;
	protected WebDriver driver;

	/**
	 * Constructor for general page
	 * 
	 * @param driver
	 * @param url
	 */
	public GeneralPage(WebDriver driver, String url) {
		this.driver = driver;
		this.url = url;
	}

	/**
	 * Constructor for general page
	 * 
	 * @param driver
	 */
	public GeneralPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Sets the url of the page
	 * 
	 * @param url
	 */
	public void setURL(String url) {
		this.url = url;
	}

	/**
	 * Opens webpage
	 * 
	 * @param url
	 */
	public void open() {
		driver.get(url);
	}

	/**
	 * Clicks the add button
	 */
	public void openAddEmployeeScreen() {
		driver.findElement(By.name("button")).click();
	}

	/**
	 * Verify if specified web element is present
	 * 
	 * @param locator            
	 * @return True if successful, False otherwise
	 */
	public boolean isElementPresent(By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (NoSuchElementException ne) {
			System.err.println("Element not found");
			return false;
		}

	}

	/**
	 * Search for an employee in the search bar
	 * 
	 * @param text
	 */
	public void searchEmployee(String text) {
		if (isElementPresent(By.id("search-bar")))
			driver.findElement(By.id("search-bar")).sendKeys(text);
	}

	
	/**
	 * Clicks the "Directory" link
	 */
	public void Directory(){
		if(isElementPresent(By.linkText("Directory"))==true)
			driver.findElement(By.linkText("Directory")).click();
	}
	
	
	/**
	 * Clicks the "Projects" link
	 */
	public void Projects(){
		if(isElementPresent(By.linkText("Projects"))==true)
			driver.findElement(By.linkText("Projects")).click();
	}
	
	
	/**
	 * Clicks the "Employees" link
	 */
	public void Employees(){
		if(isElementPresent(By.linkText("Employees"))==true)
			driver.findElement(By.linkText("Employees")).click();
	}
	
	
	/**
	 * Clicks the "Logout" link
	 */
	public void Logout(){
		if(isElementPresent(By.linkText("Logout"))==true)
			driver.findElement(By.linkText("Logout")).click();
	}
	
	
}
