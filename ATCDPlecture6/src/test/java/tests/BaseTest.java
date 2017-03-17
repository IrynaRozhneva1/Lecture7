package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import ui.pages.StartPage;

public class BaseTest {

	protected WebDriver driver;
	protected StartPage startPage;

	@BeforeClass(alwaysRun = true, description = "Launch Browser")
	public void launchBrowser() {
		driver = new FirefoxDriver();
		System.out.println("Browser is opening");
		startPage = new StartPage(driver);
		startPage.open();
	}

	@AfterClass(alwaysRun = true, description = "Stop Browser")
	public void stopBrowser() {
		driver.quit();
		System.out.println("Browser is closing");
	}

}
