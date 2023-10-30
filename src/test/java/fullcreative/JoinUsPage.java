package fullcreative;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testbase.BaseClass;

public class JoinUsPage extends BaseClass {
	
	@Test(priority=1)
	public void searchJob() throws InterruptedException {
		
		String exp_dept="Software Development";
		String exp_work="Full Time";
		String exp_loc="Chennai, India";
		
		driver.findElement(By.xpath("//a[text()='Join Us']")).click();
		Set<String> winids=driver.getWindowHandles();
		
		List <String>mylist= new ArrayList<String>(winids);
		String parentid=mylist.get(0);
		String childid=mylist.get(1);
		
		driver.switchTo().window(childid);
		driver.findElement(By.xpath("//input[@placeholder='Choose Department']")).click();
		driver.findElement(By.xpath("//label[text()='"+exp_dept+"']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Choose Work Type']")).click();
		driver.findElement(By.xpath("//label[text()='"+exp_work+"']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Choose Location']")).click();
		driver.findElement(By.xpath("//label[text()='"+exp_loc+"']")).click();
		
		String displayed_dept=driver.findElement(By.xpath("//li[@class='show']//h5[1]")).getText();
		Assert.assertEquals(displayed_dept, exp_dept);
		
		
		List<WebElement> roles=driver.findElements(By.xpath("//li[@class='show']//div[@class='hidden-content']//div//a"));
		System.out.println("Total no of "+exp_dept+" roles in "+exp_loc +" is "+ roles.size());
		
		SoftAssert sa=new SoftAssert();
		for(WebElement role: roles)
		{
			String role_name=role.getText();
			System.out.println(role_name);
			if(role_name.contains("Full Time") && role_name.contains("Chennai"))
			{
				sa.assertTrue(true);
			}
			else {
				sa.fail("Does not contain Chennai/Full Time:" +role_name);
			}
		}
		for(WebElement role: roles)
		{
			
			if(role.getText().contains("Full Stack Developer (Java,React)"))
			{
				role.click();
				Thread.sleep(4000);
				break;
			}
		}
		
		
		try {
			if(driver.findElement(By.xpath("//a[normalize-space()='Apply Now']")).isDisplayed())
			{
			driver.findElement(By.xpath("//a[normalize-space()='Apply Now']")).click();
			Thread.sleep(3000);
			Assert.assertTrue(true);
			}
		}
		catch(Exception e) {
			Assert.fail("Apply Now button is not displayed");
		}
		
		sa.assertAll();
		
	}
	
	
}
