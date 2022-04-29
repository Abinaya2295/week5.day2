package week5.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassServiceNow {
	
	public ChromeDriver driver;
	
	@DataProvider
	public String[][] fetchData() throws IOException
	{
		return ReadExcelServiceNow.readExcel();
	}
	
	@Parameters({"URL", "username", "password"})
	@BeforeMethod
	public void preCondition(String URL, String username, String password) {	
		//Load ServiceNow application URL
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//switch into frame
		driver.switchTo().frame(0);
		//Enter username (Check for frame before entering the username)
		driver.findElement(By.id("user_name")).sendKeys(username);
		//Enter password 
		driver.findElement(By.id("user_password")).sendKeys(password);
		//Click Login
		driver.findElement(By.xpath("//button[text()='Log in']")).click();		
	}

	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	
	

}
