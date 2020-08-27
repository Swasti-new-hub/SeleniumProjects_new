package ProjectWork_OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity9 {
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
	public void emergencyContactUpdate() {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Open the OrangeHRM page and login with credentials provided
		WebElement userName = driver.findElement(By.xpath("//input[@id= 'txtUsername']"));
		WebElement passWord = driver.findElement(By.xpath("//input[@id ='txtPassword']"));

		userName.sendKeys("orange");
		passWord.sendKeys("orangepassword123");

		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Find the “My Info” menu item and click it.

		WebElement MyInfoTab = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']"));
		wait.until(ExpectedConditions.elementToBeClickable(MyInfoTab));
		MyInfoTab.click();

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		driver.findElement(By.linkText("Emergency Contacts")).click();

		// Get all the table row elements from the table
		List<WebElement> allRows = driver.findElements(By.xpath("//table[contains(@class,'hover')]/tbody/tr"));

		// And iterate over them and get all the cells
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));

			// Print the contents of each cell
			for (WebElement cell : cells) {

				System.out.println(cell.getText());
				
			}
		}

	}

	@AfterClass
	public void afterClass() {
		
		driver.close();
	}

}
