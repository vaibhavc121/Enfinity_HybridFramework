package mobileTesting.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class BasePage
{
    public static WebDriver driver;

    //region Constructor
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //endregion
}