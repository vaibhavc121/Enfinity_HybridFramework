package pageObjects.HRMS.Global;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Ref;

public class TopNavigationBar extends BasePage
{
    public TopNavigationBar(WebDriver driver)
    {
        super(driver);
    }

    //region Locators
    @FindBy(xpath = "//i[@class='dx-icon dx-icon-bell-light']")
    private WebElement bellIcon;

    //region Notification Popup

    //region My Approvals Section
    //endregion

    //region Announcements Section
    //endregion

    //region Notifications Section
    @FindBy(xpath = "//span[normalize-space()='Notifications']")
    private WebElement notifications;

    @FindBy(xpath = "//span[@class='notification-subject']")
    private WebElement notificationSubject;

    @FindBy(xpath = "(//i[@class='dx-icon dx-icon-overflow'])[3]")
    private WebElement settingsIcon;

    @FindBy(xpath = "//span[normalize-space()='Acknowledged']")
    private WebElement acknowledged;
    //endregion

    //endregion

    //endregion

    //region Action Methods
    public void clickBellIcon()
    {
        clickOnElement1(bellIcon);
    }

    //region Notification Popup

    //region My Approvals Section
    //endregion

    //region Announcements Section
    //endregion

    //region Notifications Section
    public void clickNotifications()
    {
        clickOnElement1(notifications);
    }
    public boolean checkNotificationContent(String expectedText)
    {
        String notificationText = waitForElement(notificationSubject).getText().trim();
        if (notificationText.isEmpty())
        {
            throw new RuntimeException("No notifications available.");
        } else if (notificationText.contains(expectedText))
        {
            waitForElement(settingsIcon).click();
            BaseTest.log("clicked on settings icon");

            waitForElement(acknowledged).click();
            BaseTest.log("clicked on acknowledged");

            return true;
        } else
        {
            return false;
        }
    }

    //endregion

    //endregion

    //endregion
}