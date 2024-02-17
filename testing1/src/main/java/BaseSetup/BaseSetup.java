package BaseSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSetup {
	public WebDriver driver;
	
	public void NavigateToWebsite() {
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		String PageName = driver.getTitle();
		
		System.out.print("I am at " +PageName);
	}
}
