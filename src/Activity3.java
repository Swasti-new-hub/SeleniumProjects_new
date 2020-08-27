package ProjectWork_OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	
        WebDriver driver;
		
		@BeforeClass
		  public void beforeClass() {
			driver = new FirefoxDriver();
			
			//Open the browser to the login page of OrangeHRM site.
			driver.get("http://alchemy.hguy.co/orangehrm");
			
			String Title = driver.getTitle();
			
			System.out.println("The Title of the page is:" + Title);
			
			Assert.assertEquals("OrangeHRM", Title);
			
			System.out.println("Title matches with the Page Title");
			
				
		  }
		
		@Test
	  public void dashboardOpen() {
			//Find and select the username and password fields
			WebElement userName = driver.findElement(By.xpath("//input[@id= 'txtUsername']"));
			WebElement passWord = driver.findElement(By.xpath("//input[@id ='txtPassword']"));
			
			//Enter login credentials into the respective fields
			userName.sendKeys("orange");
			passWord.sendKeys("orangepassword123");
			
			//Click login
			driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
			
			//Verify that the homepage has opened.
			WebElement header = driver.findElement(By.xpath("//h1"));
			
			Assert.assertEquals("Dashboard", header.getText());
			
			System.out.println("User logged in successfully and Dashboard is open");
			
			System.out.println("Activity 3 completed successfully!!");
	  }
	  

	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }

	}


