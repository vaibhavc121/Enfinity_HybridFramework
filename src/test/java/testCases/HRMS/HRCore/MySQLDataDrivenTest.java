package testCases.HRMS.HRCore;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.DatabaseUtility;

public class MySQLDataDrivenTest
{
	@DataProvider(name = "userinfo")
	public Object[][] getDataFromDB() throws Exception
	{
		// Query to get test data
		String query = "SELECT username, password FROM users";

		// Fetch data from DB
		ResultSet resultSet = DatabaseUtility.getTestData(query);
		List<Object[]> testData = new ArrayList<>();

		// Loop through the result set and store data in List
		while (resultSet.next())
		{
			String username = resultSet.getString("username");
			String password = resultSet.getString("password");
			testData.add(new Object[]
			{ username, password });
		}

		// Convert List to Object[][]
		return testData.toArray(new Object[testData.size()][]);
	}

	@Test(dataProvider = "userinfo")
	public void testLogin(String username, String password)
	{
		// Selenium test case using data from MySQL
		System.out.println("Testing login with Username: " + username + " and Password: " + password);
		// Use Selenium WebDriver here to interact with the web application
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testlogin.onenfinity.com/User/Login?returnUrl=https%3A%2F%2Ftesthrms.onenfinity.com%2F");
		driver.findElement(By.name("Username")).sendKeys(username);
		driver.findElement(By.name("Password")).sendKeys(password);
		driver.findElement(By.xpath("//div[@aria-label='Sign In']//div[@class='dx-button-content']")).click();
	}
}
