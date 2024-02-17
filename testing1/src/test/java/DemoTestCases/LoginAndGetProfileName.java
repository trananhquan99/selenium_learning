package DemoTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginAndGetProfileName {
	
	public WebDriver driver;
		
		@BeforeTest
		public void OpenBrowser() {
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.get("https://opensource-demo.orangehrmlive.com/");
		}
		
		@Test
		public void SignInTest() {
			
			WebElement usernameField = driver.findElement(By.name("username"));
			usernameField.sendKeys("Admin");
			
			WebElement passwordField = driver.findElement(By.name("password"));
			passwordField.sendKeys("admin123");
					
			WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
			loginButton.click();
		}
		
		@AfterTest
		public void CloseBrowser() {
			driver.quit();
		}

}
