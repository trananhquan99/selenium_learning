package DemoTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EnterWebsite {
	
	public WebDriver driver;
	
	
	@BeforeTest
	public void OpenBrowser() {
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void NavigateToWebsite() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
}
