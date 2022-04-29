package week5.day2;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DuplicateLeadAssignment1 extends BaseclassAssignment1 {
	
	@BeforeClass
	public void setUp()
	{
		fileName = "DuplicateLeadWeek5Day2Ass1";
	}

	@Test(dataProvider = "fetchData")
	public void duplicateLead(String email) throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys(email);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String name = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();		
		System.out.println(name);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("Duplicate Lead"))
		{
			System.out.println("Title contains duplicate leads");
		}else
		{
			System.out.println("Title doesn't contain duplicated Lead");
		}
		driver.findElement(By.name("submitButton")).click();
		String duplicatename = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(duplicatename);
		if(duplicatename.equals(name))
		{
			System.out.println("Duplicated lead name is same as captured name");
		}else
		{
			System.out.println("Duplicated lead name is not same as captured name");
		}
		Thread.sleep(1000);
		
	}

}
