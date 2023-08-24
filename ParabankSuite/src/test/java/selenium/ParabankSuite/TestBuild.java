package selenium.ParabankSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBuild {
	public  WebDriver driver;
  @Test
  public void launchApplication() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://nxtgenaiacademy.com/");
	  WebElement course = driver.findElement(By.linkText("Demo Sites"));
	  Actions action = new Actions(driver);
	  action.moveToElement(course).perform();
	  action.moveToElement(driver.findElement(By.linkText("Practice Automation"))).perform();
  }
}
