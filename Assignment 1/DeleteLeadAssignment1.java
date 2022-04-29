package week5.day2;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DeleteLeadAssignment1 extends BaseclassAssignment1 {
	
	@BeforeClass
	public void setUp()
	{
		fileName = "DeleteLeadWeek5Day2Ass1";
	}

	@Test(dataProvider = "fetchData")
	public void deleteLead(String phoneNumber) throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		String firstLeadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		System.out.println(firstLeadId);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(firstLeadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		boolean displayed = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
		if(displayed)
		{
			System.out.println("Delection completed successfully");
			
		}
		else
		{
			System.out.println("Delection not completed successfully");
		}
		Thread.sleep(3000);
		

	}

}
