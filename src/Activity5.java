package ProjectWork_OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity5 {
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
  public void editEmployeeDetails() {
  	  
     driver.findElement(By.xpath("//input[@id= 'txtUsername']")).sendKeys("orange");
  	 driver.findElement(By.xpath("//input[@id ='txtPassword']")).sendKeys("orangepassword123");
  	 driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
  	 
  	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  	
  	try {
  		Thread.sleep(1000);
  	} catch (InterruptedException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  	
  	driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).click();
  	driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
  	
  	 //Fill in the Name, Gender, Nationality, and the DOB fields.
  	driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).clear();
  	driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Swasti");
  	
  	driver.findElement(By.id("personal_txtEmpLastName")).clear();
  	driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Bose");
  	
 
      //Gender
  		
  		driver.findElement(By.xpath("//input[@id='personal_optGender_2']")).click();
  		
  		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  		
  		//Nationality
  		
  		
  		Select selectNationality = new Select(driver.findElement(By.xpath("//*[@id=\"personal_cmbNation\"]")));
  		selectNationality.selectByVisibleText("Indian");
  		
  		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/form/fieldset/ol[3]/li[4]/img")).click();
  				
  		WebElement month = driver.findElement(By.xpath("//select[contains(@class,'month')]"));
  		
  		Select selectDOM = new Select(month);
  		
  		selectDOM.selectByVisibleText("Mar");
  		
  		WebElement year = driver.findElement(By.xpath("//select[contains(@class,'year')]"));
  		
  		Select selectYear = new Select(year);
  		selectYear.selectByVisibleText("1991");
  		
  		driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[3]/td[1]/a")).click();
  			
  		//Click Save.
  		
  		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
  		
    }
    

    @AfterClass
    public void afterClass() {
  	  //Close the browser.
  	  driver.close();
    }
  	
}	
  	
  	
  	
  
