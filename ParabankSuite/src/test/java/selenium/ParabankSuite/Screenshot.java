package selenium.ParabankSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot<TakeScreenshot> {
	WebDriver driver;
	@Test
	public void testScreenshot() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Meghana\\Downloads\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://nxtgenaiacademy.com/");
		driver.manage().window().maximize();
		TakeScreenshot ts =(TakeScreenshot)driver;
		
	}
}
