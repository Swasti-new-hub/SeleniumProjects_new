package ProjectWork_OrangeHRM;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class Activity1 {
	
	WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {
		driver = new FirefoxDriver();
		
		//Open a browser.Navigate to ‘http://alchemy.hguy.co/orangehrm’.

		driver.get("http://alchemy.hguy.co/orangehrm");
			
	  }
	
	@Test
  public void readTitleAndVerifyText() {
        //Get the title of the website.
		String Title = driver.getTitle();
		
		System.out.println("The Title of the page is:" + Title);
		
		//Make sure it matches “OrangeHRM” exactly.
		
		Assert.assertEquals("OrangeHRM", Title);
		
		System.out.println("Title matches with the Page Title");
		
		System.out.println("Activity 1 completed successfully!!");
		
		
  }
  
  @AfterClass
  public void afterClass() {
	  //If it matches, close the browser.
	  driver.close();
  }

}
