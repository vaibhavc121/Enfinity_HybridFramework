package pageObjects.HRMS.SelfService.LeaveTypesPage;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigureLeaveTypeSetting extends BasePage
{
    //region Locators
    @FindBy(xpath = "(//input[@role='spinbutton'])[3]")
    public WebElement spinbutton;
    //endregion

    //region Action Methods
    public void configureLeaveType(String leaveType, String settingName, int value)
    {
        String stringValue = String.valueOf(value);

        globalSearch("Leave Type");
        BasePage.filterAndOpenTransaction(2, 1, leaveType, "View");

        WebElement spinbutton = waitForElement1(By.xpath("(//input[@role='spinbutton'])[3]"));
        if (settingName.equalsIgnoreCase("EligibilityDaysAfterJoining0"))
        {
            clearAndProvide1(spinbutton, stringValue);
        } else if (settingName.equalsIgnoreCase("EligibilityDaysAfterJoining30"))
        {
            clearAndProvide1(spinbutton, stringValue);
        }
        clickOnSave();
    }
    //endregion
}