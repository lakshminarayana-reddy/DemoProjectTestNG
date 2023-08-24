package selenium.ParabankSuite;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitTest {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://nxtgenaiacademy.com/progress-bar/");
		driver.manage().window().maximize();
		WebElement strtBtn = driver.findElement(By.xpath("//button[@onclick='move()']"));
		strtBtn.click();
		System.out.println("Start Button clicked");
		WebElement completionText;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.withMessage("Fluent wait is implemented")
				.ignoring(NoSuchElementException.class);
		completionText =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Progress Bar Completed']")));
		System.out.println(completionText);
		strtBtn.click();
		System.out.println("Start button is clikced again");
		driver.close();
		System.out.println("Driver is closed");
		
				
	}

}
