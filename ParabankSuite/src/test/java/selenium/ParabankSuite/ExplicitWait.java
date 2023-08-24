package selenium.ParabankSuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://nxtgenaiacademy.com/progress-bar/");
		driver.manage().window().maximize();
		WebElement strtBtn = driver.findElement(By.xpath("//button[@onclick='move()']"));
		strtBtn.click();
		System.out.println("Start Button clicked");
		WebElement completeText = driver.findElement(By.xpath("//div[text()='Progress Bar Completed']"));
		//String text =completeText.getText();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		strtBtn = wait.until(ExpectedConditions.visibilityOf(completeText));
		strtBtn.click();
		System.out.println("Start Button clicked again");
		driver.close();
		System.out.println("Application is closed");
	}

}
