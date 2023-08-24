package selenium.ParabankSuite;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
// Note : While importing for NoSuchElementException, select the

public class LaunchApplication {
	public static void main(String[] args) {
		// To Set System Property
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		// To Create Driver Object in Driver Interface
		WebDriver driver = new ChromeDriver();
		// Launch the Home URL
		driver.get("https://demoqa.com/progress-bar");
		// To Maximize Window
		driver.manage().window().maximize();
		// Click on Start Button
		driver.findElement(By.id("startStopButton")).click();
		// Declaring the reset webelement
		WebElement resetBtn ;
		// Fluent Wait
		// Waiting 30 seconds for an element to be present on the page,checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5))
				.withMessage("Fluent Wait in implemented")
				.ignoring(NoSuchElementException.class);
		resetBtn =
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resetButton")));
		// Click on Reset Button
		resetBtn.click();
		System.out.println("Reset button is clicked");
	}

}
