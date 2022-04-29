package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class EditLeadAssignment1 extends BaseclassAssignment1 {
	
	@BeforeClass
	public void setUp()
	{
		fileName = "EditLeadWeek5Day2Ass1";
	}

	@Test(dataProvider = "fetchData")
	public void editLead(String company, String fName, String lName, String localName, String dept, String email) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(localName);
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(dept);
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Creating the Lead");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);
		WebElement statedropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select state = new Select(statedropdown);
		state.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Editing the Leads");
		driver.findElement(By.name("submitButton")).click();
		String title = driver.getTitle();
		System.out.println(title);
		
	}

}
