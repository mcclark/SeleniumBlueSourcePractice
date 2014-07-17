package testPackage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import userGenerator.BlueUserGenerator;
import blueSourcePages.BlueMain;
import blueSourcePages.BlueSourceLogin;

public class PageObjectTest {

	static WebDriver driver;
	public static BlueUserGenerator user;

	/**
	 * Opens a new internet explorer driver
	 */
	@BeforeTest
	public static void initializeTest() {
		File file = new File("C:/Selenium/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * Test logs in to the bluesource website
	 * 
	 * @param url
	 * @param firstName
	 * @param lastName
	 * @param password
	 */
	@Test
	@Parameters({ "url", "firstName", "lastName", "password", "manager" })
	public void loginTest(String url, String firstName, String lastName,
			String password, String manager) {
		loginToBlueSource(url, firstName, lastName, password);
		addEmployee(manager);

		BlueMain mainPage = new BlueMain(driver);
		Assert.assertTrue(mainPage.isElementPresent(By.xpath("html/body/div[1]/section/div[1]/div[1]")) == true, "User not created");
		mainPage.selectEmployee(user.getEmployeeFirstName(), user.getEmployeeLastName());
	}

	/**
	 * Adds a new employee
	 */
	public void addEmployee(String manager) {
		user = new BlueUserGenerator(manager);
		BlueMain mainPage = new BlueMain(driver);
		mainPage.openAddEmployeeScreen();
		mainPage.addNewEmployee(user);
	}

	/**
	 * Logs into site
	 * 
	 * @param url
	 * @param firstName
	 * @param lastName
	 * @param password
	 */
	public void loginToBlueSource(String url, String firstName,
			String lastName, String password) {
		BlueSourceLogin loginPage = new BlueSourceLogin(driver);

		loginPage.setURL(url);
		loginPage.open();
		loginPage.isElementPresent(By.name("employee[username]"));
		loginPage.completeLogin(firstName, lastName, password);

	}

	/**
	 * Closes driver after test is complete
	 */
	@AfterTest(description = "closes driver")
	public void cleanup() {
		driver.quit();
	}
}
