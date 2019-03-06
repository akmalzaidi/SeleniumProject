package dummyApp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Login_TestCase {

	public static WebDriver driver;

	@Test(priority = 1, groups = "Regression", description = "to check project url is correct")

	public static void verify_Url() {
		String my_url = driver.getCurrentUrl();
		System.out.println("Page title is " + my_url);

		String expected_url = "file:///C:/Users/acer/Desktop/OfflineWebsite/index.html";
		Assert.assertEquals(my_url, expected_url);
		System.out.println("*************");
		System.out.println("Test case 1 with thread id :" + Thread.currentThread().getId());

	}

	@Test(priority = 2, groups = "Regression", description = "to check application title")

	public static void verify_ApplicationTitle() {
		String my_Title = driver.getTitle();
		System.out.println("Test title is :" + my_Title);
		System.out.println("***********");

		String expected_Title = "AdminLTE 2 | Log in";

		Assert.assertEquals(my_Title, expected_Title);

		System.out.println("Test case 2 thread id is : " + Thread.currentThread().getId());

	}

	@Test(priority = 3, groups = "Regression", description = "to verify title")
	public void verify_Title() {

		String stitle = driver.findElement(By.xpath("//a[@href='index2.html']")).getText();
		String exp = "AdminLTE";
		Assert.assertEquals(stitle, exp);

		System.out.println("Application title is :" + stitle);
	}

	@Test(priority = 4, groups = "Regression", description = "session title")

	public void login_Session() {

		String session_title = driver.findElement(By.xpath("//p[contains(text(),'Sign in to start your session')]"))
				.getText();

		System.out.println(session_title);
	}

	@Test(priority = 5, groups = "Regression", description = "check placeholder")

	public void check_PlaceHolder_Username() {

		String str = driver.findElement(By.id("email")).getAttribute("placeholder");
		String expected = "Email";

		Assert.assertEquals(str, expected);

		System.out.println("Place holder email verified");
	}

	@Test(priority = 6, groups = "Regression", description = "check placeholder password")

	public void check_PlaceHolder_Password() {

		String str = driver.findElement(By.id("password")).getAttribute("placeholder");
		String expected = "Password";

		Assert.assertEquals(str, expected);

		System.out.println("Place holder password verified");
	}

	@Test(priority = 7, groups = "Regression", description = "check btn color")

	public void check_Button_Color() {

		WebElement btn = driver.findElement(By.xpath("//button[@type = 'submit']"));

		System.out.println("before mouse hover button color is :" + btn.getCssValue("background-color"));

		Actions act = new Actions(driver);

		act.moveToElement(btn).build().perform();
		System.out.println("color of button after mouse hover: " + btn.getCssValue("color"));

		System.out.println("****************************");

	}

	@Test(priority = 8, groups = "Regression", description = "check links")

	public void check_Links() {

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("link count is : " + links.size());
		for (int i = 0; i < links.size(); i++) {
			System.out.println("link text : " + links.get(i).getText());
		}
	}

	@Test(priority = 9, groups = "Regression", description = "blank username and password")

	public void blank_Username_Password() {

		WebElement stract = driver.findElement(By.xpath("//input[@type = 'text']"));
		stract.sendKeys("");

		String strexp = "sa";

		Assert.assertNotEquals(stract, strexp);

		WebElement passact = driver.findElement(By.xpath("//input[@id = 'password']"));
		stract.sendKeys("");

		String passexp = "sa";

		driver.findElement(By.xpath("//button[@type = 'submit']")).click();

		Assert.assertNotEquals(passact, passexp);

		String uname = driver.findElement(By.xpath("//div[@id = 'email_error']")).getText();
		System.out.println(uname);
		String password = driver.findElement(By.xpath("//div[@id = 'password_error']")).getText();
		System.out.println(password);

	}

	@Test(priority = 10, groups = "Regression", description = "invalid username and password")

	public void invalid_username_password() throws InterruptedException {

		WebElement stract = driver.findElement(By.xpath("//input[@id = 'email']"));
		stract.sendKeys("kiran12@gmail.com");

		String strexp = "Kiran@gmail.com";

		Assert.assertNotEquals(stract, strexp);

		Thread.sleep(2000);

		stract.clear();
		WebElement passact = driver.findElement(By.id("password"));
		passact.sendKeys("12345");

		Thread.sleep(2000);

		String passexp = "123456";

		Assert.assertNotEquals(passact, passexp);

		driver.findElement(By.xpath("//button[@type = 'submit']")).click();

		// Login_TestCase abc = new Login_TestCase();
		// abc.blank_Username_Password();

	}

	@Test(priority = 11, groups = "Regression", description = "valid username and password")
	public void valid_username_password() {

		WebElement element = driver.findElement(By.xpath("//input[@id = 'email']"));
		element.clear();
		element.sendKeys("kiran@gmail.com");
		WebElement element2 = driver.findElement(By.xpath("//input[@id = 'password']"));
		element2.clear();
		element2.sendKeys("123456");
		driver.findElement(By.xpath("//button[@type= 'submit']")).click();

		System.out.println("application logged in");
	}

	@Test(priority = 12, groups = "smoke")

	public void url_Dashboard() {

		String actualUrl = driver.getCurrentUrl();
		System.out.println("actual url after login is: " + actualUrl);
		String expectedURL = "file:///C:/Users/acer/Desktop/OfflineWebsite/pages/examples/dashboard.html";

		Assert.assertEquals(actualUrl, expectedURL);

		System.out.println("***********************************************************");

	}

	@Test(priority = 13, groups = "smoke")

	public void application_title_dashboard() {

		String actualtitle = driver.getTitle();
		System.out.println("actual url after login is: " + actualtitle);
		String expectedtitle = "AdminLTE 2 | Dashboard";

		Assert.assertEquals(actualtitle, expectedtitle);

		System.out.println("***********************************************************");

	}

	@Test(priority = 14, groups = "smoke")

	public void heading_Dashboard() throws InterruptedException {

		String sTitle = driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).getText();
		String exp = "Dashboard Control panel";

		Assert.assertEquals(sTitle, exp);
		System.out.println("Application title verify: " + sTitle);

		System.out.println("************************************");

		Thread.sleep(2000);
	}

	@Test(priority = 15, groups = "unit")

	public void click_onUser() {

		driver.findElement(By.xpath("//a[@href='users.html']")).click();

		// click on delete button

		driver.findElement(By.xpath("//span[@class='label label-danger']")).click();

		// @SuppressWarnings("unused")

		Alert alt = driver.switchTo().alert();

		// print alert text

		System.out.println(alt.getText());
		alt.accept();

	}

	@Test(priority = 16, groups = "unit")
	public void getTabledata() throws InterruptedException {

		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
		List<WebElement> tr = table.findElements(By.tagName("tr"));
		// list the number of rows in table
		System.out.println(tr.size());

		// printing elements of table

		for (WebElement row : tr) {
			List<WebElement> td = row.findElements(By.tagName("td"));

			for (WebElement col : td) {

				System.out.println(col.getText());
			}

			System.out.println("************************");
		}

		Thread.sleep(2000);

	}

	@Test(priority = 17, groups = "unit")

	public void click_on_addUser() throws InterruptedException {

		driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary btn-sm pull-right']")).click();

		Thread.sleep(2000);
	}

	@Test(priority = 18, groups = "unit")

	public void fill_form() {

		WebElement uname = driver.findElement(By.xpath("//input[@id='username']"));
		uname.sendKeys("hasan akmal zaidi");

		WebElement mobile = driver.findElement(By.id("mobile"));

		mobile.sendKeys("1234567890");
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("abc@gmail.com");
		
		WebElement gender = driver.findElement(By.xpath("//input[@id ='Male']"));
		gender.click();
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select s = new Select(dropdown);
		s.selectByVisibleText("Maharashtra");
		
		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("abcdefg");
		
		driver.findElement(By.xpath("//button[@id = 'submit']")).submit();
		
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
	}
	
	@Test(priority = 19, groups = "unit")
	
	public void clickOn_Operatorbtn() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[text()='Operators']")).click();
		
		Thread.sleep(3000);
		
		//get operator table data
		
		WebElement table1 = driver.findElement(By.xpath("//table[@class='table table-hover']"));
		
		List<WebElement> tr1 = table1.findElements(By.tagName("tr"));
		System.out.println("total number of rows :" +tr1.size());
		
		for(WebElement row1: tr1) {
			
			List<WebElement> td1 = row1.findElements(By.tagName("td"));
			
			for(WebElement col1 : td1) {
				
				System.out.println(col1.getText());
			}
			
			System.out.println("...............................");
		}
		
		Thread.sleep(2000);
	}
	
@Test(priority = 20, groups = "unit")
	
	public void clickOn_logOut() {
	
	driver.findElement(By.xpath("//a[@href='logout.html']")).click();
	System.out.println(driver.findElement(By.xpath("//p[text()='Logout successfully']")).getText());
}
	
	

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite (alwaysRun=true)
	public static WebDriver setup_Browser() {
		System.setProperty("webdriver.chrome.driver", "E:\\TechBodhi\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/acer/Desktop/OfflineWebsite/index.html");
		return driver;

	}

	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		
		driver.close();
	}

}
