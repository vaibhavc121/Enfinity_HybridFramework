package pageObjects.HRMS.Global;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class NotificationPage extends BasePage
{

    public NotificationPage(WebDriver driver)
    {
        super(driver);
    }

    //region Locators
    @FindBy(xpath = "//i[@class='dx-icon bell-icon white-color-icon']")
    WebElement bellIcon;

    @FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[1]")
    WebElement notificationSection;

    @FindBy(xpath = "//i[@class='dx-icon dx-icon-ellipsis-icon']")
    WebElement settingIcon;

    @FindBy(xpath = "//span[normalize-space()='Open']")
    WebElement open;
    //endregion

    //region Action Methods
    public void clickBellIcon()
    {
        bellIcon.click();
    }

    public void isLeaveDataCorrect(String expEmpName, String status)
    {
        String notificationData = waitForElement1(By.xpath("//p[normalize-space()='002-Rohit Chavan']")).getText();
        if (notificationData.contains(expEmpName))
        {
            settingIcon.click();
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
}