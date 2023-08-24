package selenium.ParabankSuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\baru\\.m2\\repository\\Web driver\\115\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver();
	//	options.addArguments("--disable-notifications");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://ncino-1cf.my.salesforce.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rajesh.vedula-ext291@ncinotraining.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("JJuly@2023");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		WebElement element =driver.findElement(By.xpath("//a[@title='Leads']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		String Salutaion ="Dr.";
		WebElement salutationDD =driver.findElement(By.xpath("//div[@class='slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right']//button[@id='combobox-button-210' and @data-value='"+Salutaion+"']"));
        executor.executeScript("arguments[0].click()", salutationDD);
//		Select salDD = new Select(salutationDD);
//		salDD.selectByVisibleText(null);
		
		
		driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow']//input[@name='lastName']")).sendKeys("Test");
	}

}
