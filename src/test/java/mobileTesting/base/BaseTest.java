package mobileTesting.base;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.AppiumServerUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest
{
    //region Global Variables and Logger Initialization
    public static AndroidDriver driver;
    public static Logger logger; // log4j

    public static void log(String message)
    {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        log(methodName + " - " + message);
    }
    //endregion

    //region Setup
    @BeforeClass
    public void setup() throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:platformVersion", "16.0");
        dc.setCapability("appium:deviceName", "Android Emulator");
        dc.setCapability("appium:automationName", "UiAutomator2");
        dc.setCapability("appium:app", "C:\\apkfiles\\erp.apk"); // Use full path to avoid path issues

        // App already installed - use appPackage and appActivity
//        dc.setCapability("appium:appPackage", "com.onenfinity.hrms8");
//        dc.setCapability("appium:appActivity", "com.onenfinity.hrms8.MainActivity");

        //dc.setCapability("appium:autoGrantPermissions", true);

        // Prevent app reset if you want to retain app data
        //dc.setCapability("appium:noReset", true);

        // Appium server URL
        URL appiumServerUrl = new URL("http://127.0.0.1:4723");

        //AppiumServerUtils.startAppiumServer();

        // Initialize AndroidDriver
        driver = new AndroidDriver(appiumServerUrl, dc);

        //region Logger Setup
        logger = LogManager.getLogger(this.getClass()); // log4j2
        log(">>======>>======>> Automation Engineer (SDET)- Vaibhav Chavan <<======<<======<<");
        log("--test execution started--");
        //endregion

        //region Login
//        Thread.sleep(10000);
//        driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"ion-input-0\"]")).sendKeys("vaibhavc121@demo.com#test");
//        Thread.sleep(10000);
//        driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"ion-input-1\"]")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"ion-input-1\"]")).sendKeys("123");
//        Thread.sleep(10000);
//        driver.findElement(By.xpath("//android.widget.Button[@text=\"Login\"]")).click();

        Thread.sleep(5000);
//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ion-input-0\")")).sendKeys("vaibhavc121@demo.com#test");
//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ion-input-1\")")).sendKeys("123");
//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Login\")")).click();

        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)")).sendKeys("admin@demo.com#test");
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)")).sendKeys("123");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"LOGIN\"]")).click();

        Thread.sleep(5000);
        //endregion

    }
    //endregion

    //region TearDown
    @AfterClass
    public void tearDown()
    {
        //driver.quit();
        //AppiumServerUtils.stopAppiumServer();
    }
    //endregion
}