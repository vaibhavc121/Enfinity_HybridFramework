package pageObjects.HRMS.Global;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JavaScriptUtils;

import java.sql.Ref;

public class TopNavigationBar extends BasePage
{
    public TopNavigationBar(WebDriver driver)
    {
        super(driver);
    }

    //region Locators

    //region Global Search
    //endregion

    //region Notification

    @FindBy(xpath = "//i[@class='dx-icon dx-icon-bell-light']")
    private WebElement bellIcon;

    //region My Approvals Section
    @FindBy(xpath = "//span[normalize-space()='Open']")
    WebElement open;

    @FindBy(xpath = "(//i[@class='dx-icon dx-icon-overflow'])[1]")
    private WebElement contextMenuMyApprovals;
    //endregion

    //region Announcements Section
    //endregion

    //region Notifications Section
    @FindBy(xpath = "//span[normalize-space()='Notifications']")
    private WebElement notifications;

    @FindBy(xpath = "//span[@class='notification-subject']")
    private WebElement notificationSubject;

    @FindBy(xpath = "(//i[@class='dx-icon dx-icon-overflow'])[3]")
    private WebElement contextMenuNotifications;

    @FindBy(xpath = "//span[normalize-space()='Acknowledged']")
    private WebElement acknowledged;
    //endregion

    //endregion

    //region My Account
    //endregion

    //endregion

    //region Action Methods

    //region Global Search
    public static void globalSearch(String value)
    {
        clearAndProvide(By.xpath("//input[@placeholder='Type to search (Ctrl + K)']"), value);
        BaseTest.log("Global search input provided with value: " + value);
        waitTS(2);
        selectDropdownOption(value);
    }
    //endregion

    //region Notification Popup

    public void clickBellIcon()
    {
        clickOnElement1(bellIcon);
    }

    //region My Approvals Section

    public void isLeaveDataCorrect(String expEmpName, String status)
    {
        String notificationData = waitForElement1(By.xpath("//p[normalize-space()='002-Rohit Chavan']")).getText();
        if (notificationData.contains(expEmpName))
        {
            contextMenuMyApprovals.click();
            BaseTest.log("clicked on setting icon");

            open.click();
            BaseTest.log("clicked on open");

            BasePage.switchTab();
            BaseTest.log("tab switched");

            switch (status)
            {
                case "Approve":
                    BasePage.clickOnApprove();
                    BaseTest.log("clicked on approve");
                    break;
                case "Revise":
                    BasePage.clickRevise();
                    BaseTest.log("clicked on revise");
                    break;
                case "Reject":
                    BasePage.clickReject();
                    BaseTest.log("clicked on reject");
                    break;
                default:
                    throw new IllegalArgumentException("Invalid leave status: " + status);
            }

            BasePage.acceptAlert(driver);
            BaseTest.log("alert accepted");
            // BasePage.closeCurrentTab();
            // BasePage.closeTab();
        } else
        {
            throw new RuntimeException("Leave data is not correct");
        }
    }

    //endregion

    //region Announcements Section
    //endregion

    //region Notifications Section
    public void clickNotifications()
    {
        //clickOnElement1(notifications);
        JavaScriptUtils.clickElementByJavaScript(driver, notifications);
    }
    public boolean checkNotificationContent(String expectedText)
    {
        String notificationText = waitForElement(notificationSubject).getText().trim();
        if (notificationText.isEmpty())
        {
            throw new RuntimeException("No notifications available.");
        } else if (notificationText.contains(expectedText))
        {
            //waitForElement(settingsIcon).click();
            JavaScriptUtils.clickElementByJavaScript(driver, contextMenuNotifications);
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

    //region My Account
    //endregion

    //endregion
}