package fullcreative;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testbase.BaseClass;


public class ToolsPage extends BaseClass {
	
	@Test(priority=1)
	public void toolsApp() throws InterruptedException {
		
		HashMap <String, String>hm=new HashMap<String, String>();
		hm.put("Tools - FULL Creative", "https://full.io/tools");
		hm.put("Phone Answering & Growth Solutions | ServiceForge", "https://www.serviceforge.com/");
		hm.put("Teleport | Online Video Conferencing Software", "https://teleport.video/");
		hm.put("SignMore | People-powered solutions for real estate success", "https://www.signmore.com/");
		hm.put("WellReceived - Medical Answering Services | 24/7 Service", "https://www.wellreceived.com/");
		hm.put("Free online Time Tracking Software | YoCoBoard", "https://www.yocoboard.com/");
		hm.put("AdaptiveU - Free Employee Training", "https://www.adaptiveu.io/");
		hm.put("24/7 Lead qualification & capture service | HelloSells", "https://www.hellosells.com/");
		hm.put("Free Live Chat Software & Website Chat for 2023 | ChatSupport", "https://chatsupport.co/");
		hm.put("Setmore | Free Online Appointment Scheduling Software", "https://www.setmore.com/");
		hm.put("24/7 Call Answering Service & Live Receptionists | AnswerForce", "https://www.answerforce.com/");
		hm.put("Live Call Answering Services In The US | AnswerConnect", "https://www.answerconnect.com/");
		hm.put("anywhere.app | Anywhereworks", "https://anywhere.app/");
		hm.put("Lister Place | Homepage", "https://www.listerplace.co.uk/");
		hm.put("More Than A 24/7 Answering Service For Lawyers | LEX Reception", "https://www.lexreception.com/");
		
		
		HashMap <String, String>hmtitle=new HashMap<String, String>();
		
		driver.findElement(By.xpath("//a[@href='https://full.io/tools']")).click();
		List<WebElement> tools= driver.findElements(By.className("grid-elem"));
		System.out.println("Total number of tools used in the company:"+tools.size());
		for(WebElement tool: tools)
		{
			tool.click();
		}
		
		
		Set<String> winids=driver.getWindowHandles();
		for(String id: winids)
		{
			String pageTitle=driver.switchTo().window(id).getTitle();
			Thread.sleep(3000);
			String currentUrl= driver.getCurrentUrl();
			//System.out.println(pageTitle+": "+currentUrl);
			hmtitle.put(pageTitle, currentUrl);		
		}
		
		
		System.out.println(hmtitle);
		System.out.println(hm);
		
		SoftAssert sa=new SoftAssert();
		
		
		if(hmtitle.equals(hm)) {
			sa.assertTrue(true);
		}
		else {
			for (Map.Entry<String, String> entry : hm.entrySet()) {
	            String key = entry.getKey();
	            String value1 = entry.getValue();
	            String value2 = hmtitle.get(key);

	            if (value2 == null || !value1.equals(value2)) {
	                //System.out.println("Key: " + key + " | Value in map1: " + value1 + " | Value in map2: " + value2);
	                sa.fail("Key: " + key + " | Value in map1: " + value1 + " | Value in map2: " + value2);
	            }
	        }
			//Assert.fail();
			sa.assertAll();
		}
		
	}
	
}
