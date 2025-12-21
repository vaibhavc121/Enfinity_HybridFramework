package pageObjects.HRMS.SelfService.Setups;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnnouncementPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[text()='Announcement']")
    private WebElement announcement;

    @FindBy(xpath = "//input[contains(@id,'Title')]")
    private WebElement title;

    @FindBy(xpath = "//input[contains(@id,'ExpiryDate')]")
    private WebElement expiryDate;

    @FindBy(xpath = "//div[@aria-label='Editor content']")
    private WebElement body;
    //endregion

    //region Action Methods

    //endregion
}