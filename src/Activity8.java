package ProjectWork_OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Activity8 {
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
	public void applyLeave() throws InterruptedException {

		// Open the OrangeHRM page and login with credentials provided
		WebElement userName = driver.findElement(By.xpath("//input[@id= 'txtUsername']"));
		WebElement passWord = driver.findElement(By.xpath("//input[@id ='txtPassword']"));

		userName.sendKeys("orange");
		passWord.sendKeys("orangepassword123");

		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		WebElement Dashboard = driver.findElement(By.xpath("//*[@id=\"menu_dashboard_index\"]"));
		Dashboard.click();

		WebElement ApplyLeave = driver.findElement(By.xpath(
				"/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a/img"));
		ApplyLeave.click();

		Select leaveType = new Select(driver.findElement(By.xpath("//*[@id=\"applyleave_txtLeaveType\"]")));
		leaveType.selectByVisibleText("Paid Leave");

		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[3]/img")).click();

		WebElement FromMonth = driver.findElement(By.xpath("//select[contains(@class,'month')]"));

		Select selectMonth = new Select(FromMonth);

		selectMonth.selectByVisibleText("Aug");

		WebElement FromYear = driver.findElement(By.xpath("//select[contains(@class,'year')]"));
        Select selectYear = new Select(FromYear);
		selectYear.selectByVisibleText("2020");

		// Select From Day
		driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[4]/td[5]/a")).click();

	    // ToSelection
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[4]/img"));


		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}

		WebElement ToMonth = driver.findElement(By.xpath("//select[contains(@class,'month')]"));
		Select LeaveToMonth = new Select(ToMonth);

		LeaveToMonth.selectByVisibleText("Aug");

		WebElement ToYear = driver.findElement(By.xpath("//select[contains(@class,'year')]"));

		Select LeaveToYear = new Select(ToYear);
		LeaveToYear.selectByVisibleText("2020");

		driver.findElement(By.xpath("//*[@id=\"applyBtn\"]")).click();
		
		
		
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		
		
		
		driver.findElement(By.xpath("//*[@id='menu_leave_viewMyLeaveList']")).click();
		WebElement fDate = driver.findElement(By.id("calFromDate"));
		fDate.clear();
		fDate.sendKeys(date.format(now));
		WebElement tDate = driver.findElement(By.id("calToDate"));
		tDate.clear();
		tDate.sendKeys(date.format(now));
		driver.findElement(By.id("btnSearch")).click();

		driver.findElement(By.linkText(date.format(now))).click();
		Thread.sleep(1000);
		
		// Verify the status
		String status = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[5]")).getText();

		System.out.println("Leave Status is: " + status);

		Reporter.log("Leave successfully applied and s in status: " + status);
        System.out.println("Activity 8 is completed");

	}

	@AfterClass
	public void afterClass() {
    driver.close();
	}

}