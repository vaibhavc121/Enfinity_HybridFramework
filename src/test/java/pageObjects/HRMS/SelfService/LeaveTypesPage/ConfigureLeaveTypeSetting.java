package pageObjects.HRMS.SelfService.LeaveTypesPage;

import base.BasePage;
import models.SelfService.SelfService.SelfServiceModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigureLeaveTypeSetting extends BasePage
{
    //region Locators

    //region Reset Settings
    @FindBy(xpath = "(//input[@role='spinbutton'])[2]")
    WebElement spinbutton2;

    @FindBy(xpath = "(//input[@role='spinbutton'])[3]")
    WebElement spinbutton3;
    //endregion

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

    public void resetSettings(String leaveType, SelfServiceModel.EntitlementModel1 entitlement)
    {
        globalSearch("Leave Type");
        BasePage.filterAndOpenTransaction(2, 1, leaveType, "View");

        setInput(spinbutton2, entitlement.maximumLeaveBalance);
        setInput(spinbutton3, entitlement.eligibilityDaysAfterJoining);

        setToggle("IncludeUnpaidDaysInProvision", entitlement.includeUnpaidLeaveInProvisions);
        setToggle("IncludeWeekends", entitlement.countWeekendsAsLeaveDays);
        setToggle("ExcludeWeekendDuringUnpaidDays", entitlement.countWeekendsAsUnpaidDays);
        setToggle("IncludeHolidays", entitlement.countPublicHolidaysAsPublicHolidays);
        setToggle("IgnoreAvailDaysCheckForHoliday", entitlement.grantPublicHolidaysDuringLeave);
        setToggle("ExcludeRestDays", entitlement.countRestDaysAsRestDays);
    }

    public void setToggle(String fieldId, boolean value)
    {
        WebElement toggle = waitForElement1(By.xpath("//div[@id='" + fieldId + "']//div[contains(@class,'dx-switch')]"));
        boolean isOn = toggle.getAttribute("class").contains("dx-switch-on");

        if (value && !isOn)
        {
            toggle.click(); // Turn ON
        } else if (!value && isOn)
        {
            toggle.click(); // Turn OFF
        }
    }

    public void setInput(WebElement element, String value)
    {
        element.clear();
        element.sendKeys(value);
    }

    //endregion
}