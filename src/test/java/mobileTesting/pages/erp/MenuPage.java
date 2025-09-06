package mobileTesting.pages.erp;

import io.appium.java_client.AppiumBy;
import mobileTesting.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage
{

    //region Locators
    private By hambergur = AppiumBy.xpath("//android.view.View[@resource-id=\"drawer-button\"]/android.widget.Button");
    public MenuPage(WebDriver driver)
    {
        super(driver);
    }
    //endregion
}