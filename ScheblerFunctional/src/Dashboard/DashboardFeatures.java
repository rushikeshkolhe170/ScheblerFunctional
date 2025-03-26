package Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners(Listener.listener.class)

public class DashboardFeatures extends BaseTest {

	@Test(description = "Various calculation box on Dashboard", priority = 1)
	@Feature("Calculations boxes")
	@Severity(SeverityLevel.NORMAL)
	public void detailsOnDashboard() {

		// Capturing the title and count of first box on DashBoard..
		String text1 = driver.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 css-1ws9804\"])[1]")).getText();
		boolean count1 = driver.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 css-3nzzhj\"])[1]")).isDisplayed();

		// Verifying the text is correct or not and count is display or not..
		Assert.assertEquals(text1, "Total Projects");
		Assert.assertEquals(count1, true);

		// Capturing the title and count of second box on DashBoard..
		String text2 = driver.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 css-1ws9804\"])[2]")).getText();
		boolean count2 = driver.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 css-3nzzhj\"])[2]")).isDisplayed();

		// Verifying the text is correct or not..
		Assert.assertEquals(text2, "Total Pending Projects");
		Assert.assertEquals(count2, true);

		// Capturing the title and count of third box on DashBoard..
		String text3 = driver.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 css-1ws9804\"])[3]")).getText();
		boolean count3 = driver.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 css-3nzzhj\"])[3]")).isDisplayed();

		// Verifying the text is correct or not..
		Assert.assertEquals(text3, "Total Reports");
		Assert.assertEquals(count3, true);

		// Capturing the title and count of fourth box on DashBoard..
		String text4 = driver.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 css-1ws9804\"])[4]")).getText();
		boolean count4 = driver.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 css-3nzzhj\"])[4]")).isDisplayed();

		// Verifying the text is correct or not..
		Assert.assertEquals(text4, "User Management");
		Assert.assertEquals(count4, true);
	}

	@Test(description = "Toggle, Profile and Signout button", priority = 2)
	@Feature("Toggle, Profile and Signout button")
	@Severity(SeverityLevel.NORMAL)
	public void featureButton() throws Exception {

		// Checking which theme is currently on..
		boolean theme;
		try {
			driver.findElement(By.xpath("(//span[contains(@class,\"Mui-checked\")])[2]")).isDisplayed();
			theme = true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			theme = false;
		}
		if (theme == true) {
			System.out.println("Currently the theme is DARK");
		} else {
			System.out.println("Currently the theme is WHITE");
		}

		// Changing the theme..
		Thread.sleep(2000);
		WebElement toggle = driver.findElement(By.xpath("(//span[@class=\"MuiSwitch-track css-1ju1kxc\"])[2]"));
		Actions a = new Actions(driver);
		a.click(toggle).perform();
		Thread.sleep(2000);

		// Checking which theme is apply after click..
		boolean theme2;
		try {
			driver.findElement(By.xpath("(//span[contains(@class,\"Mui-checked\")])[2]")).isDisplayed();
			theme2 = true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			theme2 = false;
		}
		if (theme2 == true) {
			System.out.println("After toggle theme is DARK");
		} else {
			System.out.println("After toggle theme is WHITE");
		}

		// Logout from the site..
		driver.findElement(By.xpath("//button[@aria-label=\"Logout\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
	}
}
