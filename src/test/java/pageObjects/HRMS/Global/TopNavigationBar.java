package pageObjects.HRMS.Global;

import base.BasePage;
import base.BaseTest;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JavaScriptUtils;

import java.sql.Ref;

public class TopNavigationBar extends BasePage
{

    //region Locators

    //region Global Search
    //endregion

    //region Notification

    @FindBy(xpath = "//i[@class='dx-icon dx-icon-bell-light']")
    WebElement bellIcon;

    //region My Approvals Section
    @FindBy(xpath = "//span[normalize-space()='Open']")
    WebElement open;

    @FindBy(xpath = "//img[@alt='Employee Picture']//following::i[@class='dx-icon dx-icon-overflow']")
    public WebElement contextMenuMyApprovals;
    //endregion

    //region Announcements Section
    //endregion

    //region Notifications Section
    @FindBy(xpath = "//span[normalize-space()='Notifications']")
    WebElement notifications;

    @FindBy(xpath = "//span[@class='notification-subject']")
    WebElement notificationSubject;

    @FindBy(xpath = "(//i[@class='dx-icon dx-icon-overflow'])[3]")
    WebElement contextMenuNotifications;

    @FindBy(xpath = "//span[normalize-space()='Acknowledged']")
    WebElement acknowledged;
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
        String notificationData = waitForElement1(By.xpath("(//span[contains(text(),'002-Rohit Chavan')])[1]")).getText();
        if (notificationData.contains(expEmpName))
        {

            try
            {
                JavaScriptUtils.clickElementByJavaScript(DriverFactory.getDriver(), contextMenuMyApprovals);
            } catch (Exception e)
            {
                contextMenuMyApprovals.click();
            }

            BaseTest.log("clicked on context menu icon");

            open.click();
            BaseTest.log("clicked on open");

            waitTS(2);

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

            BasePage.acceptAlert(DriverFactory.getDriver());
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
        JavaScriptUtils.clickElementByJavaScript(DriverFactory.getDriver(), notifications);
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
            JavaScriptUtils.clickElementByJavaScript(DriverFactory.getDriver(), contextMenuNotifications);
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