package FirstTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class FirstTestCase{
	public WebDriver driver;
	public String baseUrl = "https://www.javatpoint.com/";
	@Test
	public void test() {
	// set the system property for Chrome driver
	// Create driver object for CHROME browser
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(baseUrl);
	// get the current URL of the page  
	String URL= driver.getCurrentUrl();
	System.out.print(URL);
	//get the title of the page  
	String title = driver.getTitle();
	System.out.println(title);
	}
	@BeforeTest
	public void beforeTest() {
	System.out.println("before test");
	}
	@AfterTest
	public void afterTest() {
	driver.quit();
	System.out.println("after test");
	}
}