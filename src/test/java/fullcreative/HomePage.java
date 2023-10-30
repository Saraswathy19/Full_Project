package fullcreative;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import testbase.BaseClass;

public class HomePage extends BaseClass{
	
	
	@Test(priority=1)
	public void storyTitle() {
		driver.findElement(By.xpath("//a[@href='https://full.io/our-story']")).click();
		Assert.assertEquals(driver.getTitle(), "Our Story - FULL Creative");
	
	}
	
	@Test(priority=2)
	public void article() { 	
	int count=0;
	List<WebElement> articles= driver.findElements(By.className("grid-elem"));
	  for(WebElement article: articles)
	  {
		  if(article.getText().contains("AnywhereWorks CA"))
		  {
			  System.out.println(article.getText());
			  Assert.assertTrue(true);
			  count++;
			  break;
		  }  
	  }
	  if(count!=1)
	  {
		  Assert.fail("The desired Article is not found");
	  }
	 
	}
	
	@Test(priority=3)
	public void leaders() {
		
		
		int lcount=0;
		 String leader1[] =new String[2];
		 String leader2[] =new String[2];
		 List<String> leaders_list = new ArrayList<String>();
		 
		List<String> mylist=new ArrayList<String>();
		mylist.add("Kevin Payne");
		mylist.add("Michael Payne");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2500)", "");
		
		for(int i=0; i<mylist.size(); i++)
		{		
			try {
		    driver.findElement(By.xpath("//div/child::figure/following-sibling::h5[text()='"+mylist.get(i)+"']")).isDisplayed();
			leader1[i]=mylist.get(i)+" is displayed";
		    System.out.println(leader1[i]);
			}
			catch(Exception e) 
			{
				leader2[i]=mylist.get(i)+" is not displayed";
				System.out.println(leader2[i]);
				lcount++;
			}
		}
		
		System.out.println(lcount);
		if(lcount!=0)
		{
			for(String ld2: leader2)
			{
				if(ld2 != null && ld2.length() > 0) {
					leaders_list.add(ld2);
			       }
			}
			System.out.println(leaders_list);
			Assert.fail(leaders_list.toString());			
		}
		else
		{
			Assert.assertTrue(true);	
		}
		
	}
	
}
