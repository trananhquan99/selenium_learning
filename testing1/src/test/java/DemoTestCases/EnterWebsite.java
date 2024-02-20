package DemoTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EnterWebsite {
	
	public WebDriver driver;
	
	public String BaseURL = "https://opensource-demo.orangehrmlive.com/";
	
	@BeforeTest
	public void OpenBrowser() {
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test
	public void NavigateToWebsite() throws InterruptedException {
		//Go to the website
		driver.get(BaseURL);
		
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle,"OrangeHRM");
		System.out.println("Welcome to " +pageTitle);
		
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
}
