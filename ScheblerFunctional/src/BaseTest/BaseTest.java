package BaseTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.google.common.collect.ImmutableMap;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class BaseTest {
	
	public static WebDriver driver;
	ChromeOptions options;
	
	@BeforeSuite
	public void setAllureEnvironment() {
		allureEnvironmentWriter(
				ImmutableMap.<String, String>builder()
				.put("Browser", "Chrome")
				.put("URL", "https://13.201.44.10:3000/")
				.build(), System.getProperty("user.dir")+"/allure-results/");
	}
	
	@BeforeClass
	public void browser() {
	
		//Driver setting...
		options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://13.201.44.10:3000/");
		driver.findElement(By.xpath("(//input[@id=\"outlined-start-adornment\"])[1]")).sendKeys("rdhar@schebler.com");
		driver.findElement(By.xpath("(//input[@id=\"outlined-start-adornment\"])[2]")).sendKeys("rdhar@schebler");
		driver.findElement(By.xpath("//button[text()=\"Login\"]")).click();
	}
	
	@AfterClass
	public void closing() {
		
		//Quitting all the process...
		driver.quit();
	}
}
