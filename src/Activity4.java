package ProjectWork_OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit ;

public class Activity4 {
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
public void addNewEmployee() {
	  
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
	
	//Find the PIM option in the menu and click it.		
	driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]")).click();
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	//Click the Add button to add a new Employee.
	driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]")).click();
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	//Fill in the required fields and click Save.
	WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
	WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
	
	firstName.sendKeys("Swasti");
	lastName.sendKeys("Bose");
	
	driver.findElement(By.xpath("//input[@id='chkLogin']")).click();
	
	WebElement UserName = driver.findElement(By.xpath("//input[@id='user_name']"));
	WebElement Status = driver.findElement(By.xpath("//select[@id='status']"));
	
	UserName.sendKeys("Swasti Bose");
	Status.sendKeys("Enabled");
			
	
	driver.findElement(By.xpath("//input[@id='btnSave']")).click();
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	//String AdminPage = driver.findElement(By.xpath("//*[@id= 'menu_pim_viewEmployeeList']")).getText();
	
	//Navigate back to the Admin page and verify the creation of your employee.
	driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
	
	System.out.println("Navigated back to Admin Page!!");	
	
	WebElement SearchUserName = driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']"));
	//WebElement SearchEmpName = driver.findElement(By.xpath("//input[@id='searchSystemUser_employeeName_empName']"));
	
	SearchUserName.sendKeys("Swasti Bose");
			
	driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
	
	WebElement verify = driver.findElement(By.linkText("Swasti Bose"));
	Assert.assertEquals(verify.getText(), "Swasti Bose");
	
	System.out.println("Activity 4 completed successfully!!");
	
  }
	
	@AfterClass
	  public void afterClass() {
	  driver.close();
	
}




}
