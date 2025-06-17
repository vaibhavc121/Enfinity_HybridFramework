package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //log4j
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pageObjects.HRMS.HRCore.LoginPage;
import pageObjects.HRMS.Login.LoginPageSelenide;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest
{
    //region Global Variables and Logger Initialization
    public static WebDriver driver;
    // public static SelfHealingDriver driver; // updated to SelfHealingDriver
    public Properties p;
    public static Logger logger; // log4j

    //    public static void log(String message)
//    {
//        logger.info(message);
//    }
    public static void log(String message)
    {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        logger.info(methodName + " - " + message);
    }
    //endregion

    //region Setup
    /*
    @SuppressWarnings("deprecation")
    @BeforeClass(groups = {"regression", "datadriven"})
    @Parameters({"os", "browser"})
    public void setup(String os, String browser) throws IOException
    {
        //region CloseBrowserWhenClickStopDebugging
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            if (driver != null)
            {
                driver.quit();
            }
        }));
        //endregion

        //region Selenide Setup
        //Configuration.timeout = 5000;
        //Configuration.browser = "chrome";
        //Configuration.startMaximized = true;
        //open("https://testhrms.onenfinity.com");
        //endregion

        //region config.properties file setup
        // Loading config.properties file
        // read- e- input stream
        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);
        //endregion

        //region Logger Setup
        logger = LogManager.getLogger(this.getClass()); // log4j2
        logger.info(">>======>>======>> Automation Engineer (SDET)- Vaibhav Chavan <<======<<======<<");
        logger.info("--test execution started--");
        //endregion

        //region If execution on selenium grid or Remote Env
        if (p.getProperty("execution_env").equals("remote"))
        {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            //region Set Platform

            // OS (we are getting os from xml file)
            if (os.equalsIgnoreCase("windows"))
            {
                capabilities.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("linux"))
            {
                capabilities.setPlatform(Platform.LINUX);
            } else if (os.equalsIgnoreCase("mac"))
            {
                capabilities.setPlatform(Platform.MAC);
            } else if (os.equalsIgnoreCase("android"))
            {
                capabilities.setPlatform(Platform.ANDROID);
            } else
            {
                System.out.println("no matching os");
                return; // It will automatically exit
            }
            //endregion

            //region Set Browser
            // browser (we are getting browser from xml file)
            switch (browser.toLowerCase())
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
            //endregion

            //region Browser setup using if_else condition (Optional)

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
            //endregion

            //region For selenium grid standalone
            // driver = new RemoteWebDriver(new URL("http://192.168.102.117:4444/wd/hub"), capabilities);
            // driver = SelfHealingDriver.create(_driver);
            //endregion

            //region For docker container on selenium grid
            // driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            // driver = SelfHealingDriver.create(_driver);
            //endregion

            //region For browserstack
//            driver = new RemoteWebDriver(
//                    new URL("https://vaibhavchavan_vXTnjK:VjyZRpR7fkRybdm1cyAb@hub-cloud.browserstack.com/wd/hub"),
//                    capabilities);
            // driver = SelfHealingDriver.create(_driver);
            //endregion

        }
        //endregion

        //region If execution on Local
        if (p.getProperty("execution_env").equals("local"))
        {
            // ChromeOptions options = new ChromeOptions();
            // options.addArguments("--headless"); // Run in headless mode
            // options.addArguments("--no-sandbox"); // Required for CI environments
            // options.addArguments("--disable-dev-shm-usage"); // Required for CI environments

            switch (browser.toLowerCase())
            {
                case "chrome":
                    // driver = new ChromeDriver(options);
                    driver = new ChromeDriver();
                    logger.info("browser opened");
                    // driver = SelfHealingDriver.create(_driver);
                    // logger.info("Chrome browser opened with Healenium");
                    // logger.info("browser opened");

                    break;

                case "edge":
                    driver = new EdgeDriver();
                    logger.info("browser opened");
                    // driver = SelfHealingDriver.create(_driver);
                    // logger.info("Edge browser opened with Healenium");
                    // logger.info("browser opened");

                case "firefox":
                    driver = new FirefoxDriver();
                    logger.info("browser opened");
                    // driver = SelfHealingDriver.create(_driver);
                    // logger.info("Firefox browser opened with Healenium");
                    // logger.info("browser opened");

                    break;

                default:
                    System.out.println("invalid browser name");
                    return; // return- totally exit from the execution
            }
        }
        // region Browser Setup

        // driver = new ChromeDriver();
        // logger.info("browser opened");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        logger.info("browser maximized");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appurl")); // Readin URL from properties file
        logger.info("provided app URL in browser");

        //endregion

        //region Login
        LoginPage lp = new LoginPage(driver);
        lp.setUsername(p.getProperty("username"));
        logger.info("provided username");
        lp.setPwd(p.getProperty("pwd"));
        logger.info("provided password");
        lp.clkSignin();
        logger.info("clicked on sign in button");
        //endregion
        //endregion

    } */
    //endregion

    //region Setup Selenide

    @BeforeClass(groups = {"regression", "datadriven"})
    @Parameters({"os", "browser"})
    public void setupSelenide(String os, String browser) throws IOException
    {
        // region Shutdown Hook (Selenide manages this internally, so skip driver.quit() manually)
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            closeWebDriver();
        }));

        // region config.properties setup
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);
        // endregion

        // region Logger setup
        logger = LogManager.getLogger(this.getClass());
        logger.info(">>======>> Automation Engineer (SDET) - Vaibhav Chavan <<======<<");
        logger.info("-- test execution started --");
        // endregion

        // region Environment Setup
        String env = p.getProperty("execution_env");

        if (env.equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // OS setup
            switch (os.toLowerCase()) {
                case "windows": capabilities.setPlatform(Platform.WIN11); break;
                case "linux": capabilities.setPlatform(Platform.LINUX); break;
                case "mac": capabilities.setPlatform(Platform.MAC); break;
                case "android": capabilities.setPlatform(Platform.ANDROID); break;
                default: logger.error("Invalid OS name"); return;
            }

            // Browser setup
            switch (browser.toLowerCase()) {
                case "chrome": capabilities.setBrowserName("chrome"); capabilities.setVersion("129"); break;
                case "edge": capabilities.setBrowserName("MicrosoftEdge"); capabilities.setVersion("130"); break;
                case "firefox": capabilities.setBrowserName("firefox"); capabilities.setVersion("131"); break;
                case "safari": capabilities.setBrowserName("safari"); break;
                default: logger.error("Invalid browser name"); return;
            }

            // region BrowserStack (adjust if needed)
//            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(
//                    new URL("https://vaibhavchavan_vXTnjK:VjyZRpR7fkRybdm1cyAb@hub-cloud.browserstack.com/wd/hub"),
//                    capabilities
//            );
//            WebDriverRunner.setWebDriver(remoteWebDriver);
            // endregion

        } else if (env.equalsIgnoreCase("local")) {
            Configuration.browser = browser.toLowerCase();
            Configuration.timeout = 10000;
            Configuration.pageLoadTimeout = 20000;
            Configuration.headless = os.equalsIgnoreCase("linux");
        } else {
            logger.error("Invalid execution_env in properties file.");
            return;
        }
        // endregion

        // region Browser Setup

        open(p.getProperty("appurl"));
        logger.info("Browser opened");

        WebDriverRunner.getWebDriver().manage().window().maximize();
        logger.info("browser maximised");

        logger.info("App launched: " + p.getProperty("appurl"));

        clearBrowserCookies();
        logger.info("Cookies cleared");
        // endregion

        // region Login
        LoginPageSelenide lp = new LoginPageSelenide();
        lp.setUsername(p.getProperty("username"));
        logger.info("Username entered");

        lp.setPwd(p.getProperty("pwd"));
        logger.info("Password entered");

        lp.clkSignin();
        logger.info("Clicked on Sign In");
        // endregion
    }


    //endregion

    //region TearDown
    @AfterClass(groups = {"regression", "datadriven"})
    public void teardown()
    {
        logger.info("--test execution completed--");
        driver.quit();
    }
    //endregion

    //region Additional Code
    // used in extent report manager class
    public WebDriver getDriver()
    {
        return driver;
    }
    //endregion
}