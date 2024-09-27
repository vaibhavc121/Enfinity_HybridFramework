package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pageObjects.LoginPage;

public class BaseClass
{
	public static WebDriver driver;
	public Properties p;
	public Logger logger; // log4j

	@BeforeClass(groups =
	{ "regression", "datadriven" })
	public void setup() throws IOException
	{
		// Loading config.properties file
		// read- e- input stream
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass()); // log4j2

//		if (br.equalsIgnoreCase("chrome"))
//		{
//			driver = new ChromeDriver();
//		}
//		else if (br.equalsIgnoreCase("edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		else
//		{
//			System.out.println("No matching browser ");
//		}

//		switch (br.toLowerCase())
//		{
//		case "chrome":
//			driver = new ChromeDriver();
//
//			break;
//
//		case "edge":
//			driver = new EdgeDriver();
//
//			break;
//
//		default:
//			System.out.println("invalid browser name");
//			return; // return- totally exit from the execution
//		}
		logger.info("Automation Engineer(SDET)- Vaibhav Chavan");
		logger.info("--test case started--");
		driver = new ChromeDriver();
		logger.info("browser opened");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		logger.info("browser maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl")); // Reading URL from properties file
		logger.info("provided app URL in browser");
	}

	@BeforeMethod(groups =
	{ "regression", "datadriven" })
	public void login()
	{
		// login page
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(p.getProperty("username"));
		logger.info("provided username");
		lp.setPwd(p.getProperty("pwd"));
		logger.info("provided password");
		lp.clkSignin();
		logger.info("clicked on sign in button");
	}

	@AfterClass(groups =
	{ "regression", "datadriven" })
	public void teardown()
	{
		// driver.quit();
	}

	// used in extent report manager class
	public String captureScreen(String tname)
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}

	// used in extent report manager class
	public WebDriver getDriver()
	{
		return driver;
	}

	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}

	public String randomNumber()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(4);
		return generatedNumber;
	}

	public String randomAlphaNumeric()
	{
		String alphanumeric = RandomStringUtils.randomAlphanumeric(10);
		return alphanumeric;
	}

	public String randomEmail()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		return generatedString + generatedNumber + "@" + "gmail.com";
	}

	public String randomMblNum()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

//	public String randomAlphaNumeric()
//	{
//		String generatedString = RandomStringUtils.randomAlphabetic(3);
//		String generatedNumber = RandomStringUtils.randomNumeric(3);
//		return (generatedString + "@" + generatedNumer);
//	}

}
