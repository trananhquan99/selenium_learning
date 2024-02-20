package DemoTestCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetToAdminPage {
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
	public void getToAdminPage() throws InterruptedException {
		
		//Login step
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		
		WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		usernameField.sendKeys("Admin");
		
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("admin123");
				
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		WebElement loginAlert = driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
		if (loginAlert.isDisplayed()) {
			Assert.fail("Cannot login");
		} else if (loginAlert.isDisplayed() == false) {
			//Verify the profile name
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='oxd-userdropdown-tab']")));
			
			WebElement profile = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']/p[@class='oxd-userdropdown-name']"));
			String profileName = profile.getText();
			System.out.println("You are accessing in a profile name " +profileName);
			
			Thread.sleep(3000);
		}
		
		//Go to Admin page
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='oxd-main-menu-item' and @href='/web/index.php/admin/viewAdminModule']")));
		
		WebElement AdminPage = driver.findElement(By.xpath("//a[@class='oxd-main-menu-item' and @href='/web/index.php/admin/viewAdminModule']"));
		AdminPage.click();
		
		String AdminBreadcrumb = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
		Assert.assertEquals(AdminBreadcrumb, "Admin");
		
		System.out.println("You are at " +AdminBreadcrumb+ " page");
		
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
