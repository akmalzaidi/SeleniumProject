package practiceSet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClassExample {
  @Test
  public void f() {
	  
	  System.setProperty("webdriver.chrome.driver", "E:\\TechBodhi\\chromedriver\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  Actions builder = new Actions(driver);
	  driver.get("http://javabykiran.com//javabykiranfiles/");
	  WebElement username = driver.findElement(By.xpath("//*[@id = 'login_form_user']"));
	  
	  Action seriesofactions = builder.moveToElement(username).click().keyDown(username, Keys.SHIFT).sendKeys(username,"javabykiran").doubleClick(username).contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build();
	  seriesofactions.perform();
  }
}
