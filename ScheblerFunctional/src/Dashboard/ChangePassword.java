package Dashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners(Listener.listener.class)

public class ChangePassword extends BaseTest{
	
	@Test(description =  "Changing password of the user", priority = 1)
	@Feature("User password Change")
	@Severity(SeverityLevel.CRITICAL)
	public void changePassword() throws InterruptedException {
		
		// Opening options from the profile icon..
		driver.findElement(By.xpath("//button[@aria-label=\"Profile\"]")).click();
		
		// Selecting Change Password option..
		driver.findElement(By.xpath("//li[text()=\"Change Password\"]")).click();
		
		// Filling details to change the password..
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder=\"Old Password\"]")).sendKeys("Rushi@7738");
		String newpPassword1 = "Welcome@1";
		driver.findElement(By.xpath("//input[@placeholder=\"New Password\"]")).sendKeys(newpPassword1);
		driver.findElement(By.xpath("//input[@placeholder=\"Confirm Password\"]")).sendKeys(newpPassword1);
		driver.findElement(By.xpath("//button[text()=\"Change\"]")).click();
		
		// Toast message capturing.. 
		WebElement toast_Message = driver.findElement(By.cssSelector(".Toastify__toast-body"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(toast_Message));
		String msg = toast_Message.getText();
		wait.until(ExpectedConditions.invisibilityOf(toast_Message));
		
		//Verifying the toast message for successful password change..
		Assert.assertEquals(msg, "Password changed successfully");
		
		// Logout from the site..
		driver.findElement(By.xpath("//button[@aria-label=\"Logout\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
		
		// Login with new credentials..
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id=\"outlined-start-adornment\"])[1]")).sendKeys("rushikesh@gmail.com");
		driver.findElement(By.xpath("(//input[@id=\"outlined-start-adornment\"])[2]")).sendKeys(newpPassword1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=\"Login\"]")).click();
		
		// Toast message capturing..
		Thread.sleep(1000);
		WebElement toast_Message1 = driver.findElement(By.cssSelector("div.Toastify__toast-body"));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.visibilityOf(toast_Message1));
		String msg1 = toast_Message1.getText();
		wait1.until(ExpectedConditions.invisibilityOf(toast_Message1));
		
		// Verifying the toast message for successful password change..
		Assert.assertEquals(msg1, "Login Successful");
		
		// Opening options from the profile icon..
		driver.findElement(By.xpath("//button[@aria-label=\"Profile\"]")).click();
				
		// Selecting Change Password option..
		driver.findElement(By.xpath("//li[text()=\"Change Password\"]")).click();
				
		// Filling details to change the password..
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder=\"Old Password\"]")).sendKeys(newpPassword1);
		String newpPassword2 = "Rushi@7738";
		driver.findElement(By.xpath("//input[@placeholder=\"New Password\"]")).sendKeys(newpPassword2);
		driver.findElement(By.xpath("//input[@placeholder=\"Confirm Password\"]")).sendKeys(newpPassword2);
		driver.findElement(By.xpath("//button[text()=\"Change\"]")).click();
		
		// Toast message capturing.. 
		WebElement toast_Message3 = driver.findElement(By.cssSelector(".Toastify__toast-body"));
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(toast_Message3));
		String msg3 = toast_Message3.getText();
		wait.until(ExpectedConditions.invisibilityOf(toast_Message3));
				
		//Verifying the toast message for successful password change..
		Assert.assertEquals(msg3, "Password changed successfully");
		
		// Logout from the site..
		driver.findElement(By.xpath("//button[@aria-label=\"Logout\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
		
		// Login with new credentials..
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id=\"outlined-start-adornment\"])[1]")).sendKeys("rushikesh@gmail.com");
		driver.findElement(By.xpath("(//input[@id=\"outlined-start-adornment\"])[2]")).sendKeys(newpPassword2);
		driver.findElement(By.xpath("//button[text()=\"Login\"]")).click();
		
		// Toast message capturing..
		Thread.sleep(1000);
		WebElement toast_Message2 = driver.findElement(By.cssSelector("div.Toastify__toast-body"));
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait2.until(ExpectedConditions.visibilityOf(toast_Message2));
		String msg2 = toast_Message2.getText();
		wait2.until(ExpectedConditions.invisibilityOf(toast_Message2));
		
		//Verifying the toast message for successful password change..
		Assert.assertEquals(msg2, "Login Successful");
	}
}
