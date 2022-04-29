package week5.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ServiceNowFrame extends BaseClassServiceNow {

	@Test(dataProvider = "fetchData")
	public void serviceNow(String description) throws InterruptedException {
		//Search “incident “ Filter Navigator
		driver.findElement(By.id("filter")).sendKeys("incident");		
		//Click “All”
		driver.findElement(By.xpath("(//div[text()='All'][@class='sn-widget-list-title'])[2]")).click();
		//Click New button
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='New'][@id='sysverb_new']")).click();
		//Select a value for Caller
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		//moving to next window, select item in second window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> switchWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(switchWindow.get(1));
		driver.manage().window().maximize();
		//select first recurring result
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]/a")).click();
		//Again switch to main window
		driver.switchTo().window(switchWindow.get(0));
		driver.switchTo().frame(0);
		//Enter value for short_description
		driver.findElement(By.xpath("//input[@id='incident.short_description'][@class='form-control']")).sendKeys(description);
		//Read the incident number and save it a variable
		WebElement readIncident = driver.findElement(By.id("incident.number"));
		String attribute = readIncident.getAttribute("Value");
		System.out.println(attribute);		
		//Click on Submit button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();		
		//Search the same incident number in the next search screen as below
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(attribute,Keys.ENTER);	
		//Verify the incident is created successful.
		String text = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if(text.contains(attribute))
		{
			System.out.println("Incident is created successfully");
		}
		else
		{
			System.out.println("Incident is not created successfully"); 
		}
	}
	
}
