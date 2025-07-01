package mobileTesting.base;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.AppiumServerUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest
{
    public static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException
    {
        setup();
    }

    public static void setup() throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:platformVersion", "16.0");
        dc.setCapability("appium:deviceName", "Android Emulator");
        dc.setCapability("appium:automationName", "UiAutomator2");
        //dc.setCapability("appium:app", "C:\\apkfiles\\app-debug.apk"); // Use full path to avoid path issues

        // App already installed - use appPackage and appActivity
        dc.setCapability("appium:appPackage", "com.onenfinity.hrms8");
        dc.setCapability("appium:appActivity", "com.onenfinity.hrms8.MainActivity");

        dc.setCapability("appium:autoGrantPermissions", true);

        // Prevent app reset if you want to retain app data
        //dc.setCapability("appium:noReset", true);

        // Appium server URL
        URL appiumServerUrl = new URL("http://127.0.0.1:4723");

        AppiumServerUtils.startAppiumServer();

        // Initialize AndroidDriver
        driver = new AndroidDriver(appiumServerUrl, dc);

//        Thread.sleep(10000);
//        driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"ion-input-0\"]")).sendKeys("vaibhavc121@demo.com#test");
//        Thread.sleep(10000);
//        driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"ion-input-1\"]")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"ion-input-1\"]")).sendKeys("123");
//        Thread.sleep(10000);
//        driver.findElement(By.xpath("//android.widget.Button[@text=\"Login\"]")).click();

        Thread.sleep(5000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ion-input-0\")")).sendKeys("vaibhavc121@demo.com#test");
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ion-input-1\")")).sendKeys("123");
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Login\")")).click();
        Thread.sleep(5000);

        //region loan request
//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(5)")).click();
//        Thread.sleep(2000);
//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Image\").instance(5)")).click();
//        Thread.sleep(5000);
//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ion-input-2\")")).click();
//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ion-input-2\")")).sendKeys("1");
//        Thread.sleep(2000);
//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ion-input-3\")")).sendKeys("1");
//        Thread.sleep(2000);
//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ion-input-4\")")).sendKeys("1");
//        Thread.sleep(2000);
//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"SUBMIT\")")).click();
        //endregion

        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(36)")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Select one\")")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"001 | Vaibhav Chavan\")")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"SUBMIT\")")).click();
    }

    public void tearDown()
    {
        //driver.quit();
        AppiumServerUtils.stopAppiumServer();
    }
}