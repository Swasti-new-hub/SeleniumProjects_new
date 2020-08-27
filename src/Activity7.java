package ProjectWork_OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity7 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");

		String Title = driver.getTitle();

		System.out.println("The Title of the page is:" + Title);

		Assert.assertEquals("OrangeHRM", Title);

		System.out.println("Title matches with the Page Title");

	}

	@Test
	public void editQualification() {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Open the OrangeHRM page and login with credentials provided
		WebElement userName = driver.findElement(By.xpath("//input[@id= 'txtUsername']"));
		WebElement passWord = driver.findElement(By.xpath("//input[@id ='txtPassword']"));

		userName.sendKeys("orange");
		passWord.sendKeys("orangepassword123");

		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Find the “My Info” menu item and click it.

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Find the “My Info” menu item and click it.
		WebElement MyInfoTab = driver.findElement(By.id("menu_pim_viewMyDetails"));
		wait.until(ExpectedConditions.visibilityOf(MyInfoTab));
		MyInfoTab.click();

		// On the new page, find the Qualification option on the left side menu and
		// click it.
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[9]/a")).click();

		// Add Work Experience and click Save.
		driver.findElement(By.xpath("//*[@id=\"addWorkExperience\"]")).click();

		WebElement Company = driver.findElement(By.xpath("//*[@id=\"experience_employer\"]"));
		WebElement JobTitle = driver.findElement(By.xpath("//*[@id=\"experience_jobtitle\"]"));

		Company.sendKeys("IBM India Pvt Ltd.");
		JobTitle.sendKeys("Test Specialist_automation2");

		driver.findElement(By.xpath("//*[@id=\"btnWorkExpSave\"]")).click();

		System.out.println("Test Passed");
		System.out.println("Activity 7 got completed");

	}

	@AfterClass
	public void afterClass() {
		
		 driver.close();
	}

	}

	

