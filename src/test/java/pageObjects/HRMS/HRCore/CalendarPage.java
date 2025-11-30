package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.BaseTest;
import utilities.CommonActions;

public class CalendarPage extends BasePage
{

    //region Locators
    @FindBy(name = "Name")
    WebElement calname;

    @FindBy(xpath = "(//input[contains(@id,'FromDate')])[2]")
    WebElement fromDate;

    @FindBy(xpath = "//div[@id='SundayAsWeeklyoff']//span[@class='dx-checkbox-icon']")
    WebElement weekoffcheckbox;

    @FindBy(xpath = "//div[@id='SaturdayAsRestDay']//span[@class='dx-checkbox-icon']")
    WebElement restdaycheckbox;
    //endregion

    //region Action Methods
    public void clickNewButton()
    {
        clickOnNew();
    }

    public void provideCalendarName()
    {
        calname.sendKeys(randomString());
    }

    public void provideCalendarName(String value)
    {
        clearAndProvide1(calname, value);
    }

    public void provideFromDate(String value)
    {
        clearAndProvide1(fromDate, value);
    }

    public void setWeekoff()
    {
        clickOnElement1(weekoffcheckbox);
    }

    public void setRestday()
    {
        clickOnElement1(restdaycheckbox);
    }

    public void clickSaveBack()
    {
        clickSaveAndBack();
    }
    //endregion
}