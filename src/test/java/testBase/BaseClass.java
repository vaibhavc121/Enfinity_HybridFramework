package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //log4j
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pageObjects.LoginPage;

public class BaseClass
{
	public static WebDriver driver;
	public Properties p;
	public Logger logger; // log4j

	@SuppressWarnings("deprecation")
	@BeforeClass(groups =
	{ "regression", "datadriven" })
	@Parameters(
	{ "os", "browser" })
	public void setup(String os, String br) throws IOException
	{
		// Loading config.properties file
		// read- e- input stream
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass()); // log4j2

		logger.info("==============>> Automation Engineer (SDET)- Vaibhav Chavan <<==============");
		logger.info("--test case started--");

		// code for execution on selenium grid
		if (p.getProperty("execution_env").equals("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();

			// OS (we are getting os from xml file)
			if (os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}

			else if (os.equalsIgnoreCase("android"))
			{
				capabilities.setPlatform(Platform.ANDROID);
			}
			else
			{
				System.out.println("no matching os");
				return; // It will automatically exit
			}

			// browser (we are getting browser from xml file)
			switch (br.toLowerCase())
			{
			case "chrome":
				capabilities.setBrowserName("chrome");
				capabilities.setVersion("129");
				// to work this in local env need to install the browser of ver 129, it is
				// working on browserstack

				break;

			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				capabilities.setVersion("130");
				// to work this in local env need to install the browser of ver 130, it is
				// working on browserstack

				break;

			case "firefox":
				capabilities.setBrowserName("firefox");
				capabilities.setVersion("131");
				// to work this in local env need to install the browser of ver 131, it is
				// working on browserstack

				break;

			case "safari":
				capabilities.setBrowserName("safari");

				break;

			default:
				System.out.println("No matching browser ");
				return;
			// It will automatically exit from switch case statement
			}

//			if (br.equalsIgnoreCase("chrome")) 
//			{
//			    ChromeOptions options = new ChromeOptions();
//			    options.setCapability("browserVersion", "129");
//			    driver = new ChromeDriver(options);
//			} 
//			else if (br.equalsIgnoreCase("firefox")) 
//			{
//			    FirefoxOptions options = new FirefoxOptions();
//			    options.setCapability("browserVersion", "131");
//			    driver = new FirefoxDriver(options);
//			} 
//			else if (br.equalsIgnoreCase("edge")) 
//			{
//			    EdgeOptions options = new EdgeOptions();
//			    options.setCapability("browserVersion", "130");
//			    driver = new EdgeDriver(options);
//			} else 
//			{
//			    throw new IllegalArgumentException("Unsupported browser: " + br);
//			}
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			/* for selenium grid standalone */
//			driver = new RemoteWebDriver(new URL("http://10.101.222.130:4444/wd/hub"), capabilities);
			/* for docker container on selenium grid */
//			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			/* for browserstack */
			driver = new RemoteWebDriver(
					new URL("https://vaibhavchavan_vXTnjK:VjyZRpR7fkRybdm1cyAb@hub-cloud.browserstack.com/wd/hub"),
					capabilities);
		}

		if (p.getProperty("execution_env").equals("local"))

		{
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless"); // Run in headless mode
//			options.addArguments("--no-sandbox"); // Required for CI environments
//			options.addArguments("--disable-dev-shm-usage"); // Required for CI environments

			switch (br.toLowerCase())
			{
			case "chrome":
				// driver = new ChromeDriver(options);
				driver = new ChromeDriver();
				logger.info("browser opened");

				break;

			case "edge":
				driver = new EdgeDriver();
				logger.info("browser opened");

				break;

			default:
				System.out.println("invalid browser name");
				return; // return- totally exit from the execution
			}
		}

//		driver = new ChromeDriver();
//		logger.info("browser opened");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		logger.info("browser maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl")); // Reading
												// URL
												// from
												// properties
												// file
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

	@AfterMethod(groups =
	{ "regression", "datadriven" })
	public void afterMethod()
	{
		System.out.println("--test execution completed--");
	}

	@AfterClass(groups =
	{ "regression", "datadriven" })
	public void teardown()
	{
		driver.quit();
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

	// Method to highlight/unhighlight the element
	public void highlightElement(WebDriver driver, WebElement element, boolean highlight)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (highlight)
		{
			// Add a red border to highlight the element
			js.executeScript("arguments[0].style.border='3px solid red'", element);
		}
		else
		{
			// Remove the border to unhighlight the element
			js.executeScript("arguments[0].style.border=''", element);
		}
	}

}
