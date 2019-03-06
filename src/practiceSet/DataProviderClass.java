package practiceSet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {

	WebDriver driver;

	@Test(dataProvider = "crmLoginData")

	public void login(String uname, String pwd) {

		System.setProperty("webdriver.chrome.driver", "E://TechBodhi//chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().equals("CRMPRO"), "INVALID LOGI DETAILS");
	}

	@DataProvider(name = "crmLoginData")
	public Object[][] passData() {

		Object[][] data = new Object[3][2];
		data[0][0] = "drizvi";
		data[0][1] = "rizvi123";
		data[1][0] = "drizvi";
		data[1][1] = "rizvi234";
		data[2][0] = "drizvi22";
		data[2][1] = "rizvi123";
		return data;

	}
    @AfterMethod
	public void tearDown() {
       driver.quit();
	}

}
