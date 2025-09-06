package factory;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory
{
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    private DriverFactory()
    {
        // prevent external instantiation
    }

    public static WebDriver getDriver()
    {
        return tlDriver.get();
    }

    public static void setDriver(WebDriver driver)
    {
        tlDriver.set(driver);
    }

    public static void cleanupDriver()
    {
        if (tlDriver.get() != null)
        {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}