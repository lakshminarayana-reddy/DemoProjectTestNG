package com.driverscript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait;
	@BeforeSuite
	//@Parameters({"browser"})
	public WebDriver setUp() throws IOException {
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\driverscript\\configuration.properties");
			config.load(fis);
			System.out.println("Configuration File loaded successfully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(config.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(config.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get(config.getProperty("url"));
		System.out.println("Application opened successfully");
		driver.manage().window().maximize();
		return driver;
	}

	@AfterSuite
	public void tearDown() {
		if(driver !=null) {
			driver.quit();
		}
	}

}
