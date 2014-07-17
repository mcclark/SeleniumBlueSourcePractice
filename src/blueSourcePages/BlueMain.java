package blueSourcePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import blueSourceWindows.AddEmployeeWindow;
import userGenerator.BlueUserGenerator;


public class BlueMain extends GeneralPage {

	protected AddEmployeeWindow AddEmployee;

	/**
	 * Constructor for main Bluesource Page
	 * 
	 * @param driver
	 */
	public BlueMain(WebDriver driver) {
		super(driver);
		this.AddEmployee = new AddEmployeeWindow(driver);
	}

	/**
	 * Adds new employee when given a generated user
	 * 
	 * @param user
	 */
	public void addNewEmployee(BlueUserGenerator user) {
		AddEmployee.fillFields(user);
		AddEmployee.clickAdd();
	}

	/**
	 * Searches for an employee and opens their employee page
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public void selectEmployee(String firstName, String lastName) {
		searchEmployee(firstName + " " + lastName);
		driver.findElement(By.linkText(lastName)).click();
	}

}
