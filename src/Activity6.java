package ProjectWork_OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity6 {
	WebDriver driver;

	@BeforeClass

	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}

	@BeforeMethod
	public void login() {
		driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("orange");
		driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("orangepassword123");
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"menu_dashboard_index\"]")).click();
	}

	@Test(priority = 0)
	public void directory() {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement directory_1 = driver.findElement(By.id("menu_directory_viewDirectory"));
		Actions action = new Actions(driver);
		action.moveToElement(directory_1).build().perform();
		wait.until(ExpectedConditions.visibilityOf(directory_1));
		directory_1.click();

		WebElement directory_menu = driver.findElement(By.xpath("//*[@id='content']/div[1]/div[1]/h1"));
		wait.until(ExpectedConditions.visibilityOf(directory_menu));
		String directory_text = directory_menu.getText();
		Assert.assertEquals(directory_text, "Search Directory");

		System.out.println("Activity 6 is completed");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
