package DemoTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginAndGetProfileName {
	
	public WebDriver driver;
	
	public String BaseURL = "https://opensource-demo.orangehrmlive.com/";
		
		@BeforeTest
		public void OpenBrowser() {
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.get(BaseURL);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		
		@Test
		public void GetToProfileName() throws InterruptedException {
			//Login
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
			
			WebElement usernameField = driver.findElement(By.name("username"));
			usernameField.sendKeys("Admin");
			
			WebElement passwordField = driver.findElement(By.name("password"));
			passwordField.sendKeys("admin123");
					
			WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
			loginButton.click();
			
			//Get profile name
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='oxd-userdropdown-tab']")));
			
			WebElement profile = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']/p[@class='oxd-userdropdown-name']"));
			String profileName = profile.getText();
			System.out.println("You are accessing in a profile name " +profileName);
			
			Thread.sleep(3000);
		}
		
		@AfterTest
		public void CloseBrowser() {
			
			driver.quit();
		}

}
