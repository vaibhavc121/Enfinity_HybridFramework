package testCases.HRMS.HRCore;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GoogleLogin
{
	@Test
	public void login() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("india");

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wM6W7d']")));

		Thread.sleep(5000);

		List<WebElement> searchList = driver.findElements(By.xpath("//div[@class='wM6W7d']"));

		for (WebElement list : searchList)
		{
			System.out.println(list.getText());
			if (list.getText().contains("india map"))
			{
				list.click();
				break;
			}
		}

	}

}
