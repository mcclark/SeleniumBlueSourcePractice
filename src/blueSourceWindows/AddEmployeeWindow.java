package blueSourceWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import userGenerator.BlueUserGenerator;

/**
 * This class includes functionality for the add employee screen
 * 
 * @author matthew.clark
 * 
 */
public class AddEmployeeWindow {

	private WebDriver driver;
	private WebElement element;

	/**
	 * Contructor for the add employee window
	 * 
	 * @param driver
	 */
	public AddEmployeeWindow(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Sets the user name field in the add employee window
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public void setUserName(String firstName, String lastName) {
		driver.findElement(By.name("employee[username]")).sendKeys(
				firstName + "." + lastName);
	}

	/**
	 * Selects a specified value from a drop down box
	 * 
	 * @param option
	 * @param xpath
	 */
	private void selectBox(String option, By elementProperty) {
		element = driver.findElement(elementProperty);
		new Select(element).selectByVisibleText(option);
	}

	/**
	 * Inputs the text param into a text box
	 * 
	 * @param text
	 * @param elementProperty
	 */
	private void setText(String text, By elementProperty) {
		element = driver.findElement(elementProperty);
		element.sendKeys(text);
	}

	/**
	 * This method fills all appropriate fields with data from the random user
	 * generator
	 * 
	 * @param newEmployee
	 */
	public void fillFields(BlueUserGenerator newEmployee) {
		setUserName(newEmployee.getEmployeeFirstName(),
				newEmployee.getEmployeeLastName());
		setFirstName(newEmployee.getEmployeeFirstName());
		setLastName(newEmployee.getEmployeeLastName());
		selectRole(newEmployee.getEmployeeRole());
		selectDepartment(newEmployee.getDepartment());
		selectSubDepartment(newEmployee.getSubDepartment());
		selectLocation(newEmployee.getLocation());
		selectManager(newEmployee.getEmployeeManager());
		selectTitle(newEmployee.getEmployeeTitle());
		setStartDate(newEmployee.getStartDate());
		selectStatus(newEmployee.getStatus());
		setCellPhone(newEmployee.getCellNumber());
		setOfficePhone(newEmployee.getOfficeNumber());
		setEmail(newEmployee.getEmail());
		setIMname(newEmployee.getIM_name());
		setIMClient(newEmployee.getIM_Client());
	}

	/**
	 * Sets employee first name
	 * 
	 * @param employeeFirstName
	 */
	public void setFirstName(String employeeFirstName) {
		setText(employeeFirstName, By.name("employee[first_name]"));
	}

	/**
	 * Sets employee last name
	 * 
	 * @param employeeLastName
	 */
	public void setLastName(String employeeLastName) {
		setText(employeeLastName, By.name("employee[last_name]"));
	}

	/**
	 * Sets employee title
	 * 
	 * @param employeeTitle
	 */
	public void selectTitle(String employeeTitle) {
		selectBox(employeeTitle, By.name("employee[title_id]"));
	}

	/**
	 * Sets employee Role
	 * 
	 * @param employeeRole
	 */
	public void selectRole(String employeeRole) {
		selectBox(employeeRole, By.name("employee[role]"));
	}

	/**
	 * Sets employee manager
	 * 
	 * @param employeeManager
	 */
	public void selectManager(String employeeManager) {
		selectBox(employeeManager, By.name("employee[manager_id]"));
	}

	/**
	 * Sets employee status
	 * 
	 * @param status
	 */
	public void selectStatus(String status) {
		selectBox(status, By.name("employee[status]"));
	}

	/**
	 * Sets employee location
	 * 
	 * @param location
	 */
	public void selectLocation(String location) {
		selectBox(location, By.name("employee[location]"));
	}

	/**
	 * Sets employee start date
	 * 
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		setText(startDate, By.name("employee[start_date]"));
	}

	/**
	 * Sets employee cell number
	 * 
	 * @param cellNumber
	 */
	public void setCellPhone(String cellNumber) {
		setText(cellNumber, By.name("employee[cell_phone]"));
	}

	/**
	 * Sets employee office number
	 * 
	 * @param officeNumber
	 */
	public void setOfficePhone(String officeNumber) {
		setText(officeNumber, By.name("employee[office_phone]"));
	}

	/**
	 * Sets email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		setText(email, By.name("employee[email]"));
	}

	/**
	 * Sets im name
	 * 
	 * @param im_name
	 */
	public void setIMname(String im_name) {
		setText(im_name, By.name("employee[im_name]"));
	}

	/**
	 * Sets imClient
	 * 
	 * @param im_Client
	 */
	public void setIMClient(String im_Client) {
		selectBox(im_Client, By.name("employee[im_client]"));
	}

	/**
	 * @param department
	 */
	public void selectDepartment(String department) {
		selectBox(
				department,
				By.xpath("html/body/div[1]/section/div[1]/div[5]/div/div/div[2]/form/div[17]/select[1]"));
	}

	/**
	 * @param subDepartment
	 */
	public void selectSubDepartment(String subDepartment) {
		selectBox(
				subDepartment,
				By.xpath("html/body/div[1]/section/div[1]/div[5]/div/div/div[2]/form/div[17]/select[2]"));

	}

	/**
	 * Clicks the create employee button
	 */
	public void clickAdd() {
		driver.findElement(By.name("commit")).click();
	}

}
