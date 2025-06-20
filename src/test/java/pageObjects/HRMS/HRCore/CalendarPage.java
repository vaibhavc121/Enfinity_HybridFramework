package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.BaseTest;
import utilities.CommonActions;

public class CalendarPage extends BasePage
{

    public CalendarPage(WebDriver driver)
    {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    @FindBy(name = "Name")
    WebElement calname;

    @FindBy(xpath = "//input[contains(@id,'FromDate')]")
    WebElement fromDate;

    @FindBy(xpath = "//div[@id='SundayAsWeeklyoff']//span[@class='dx-checkbox-icon']")
    WebElement weekoffcheckbox;

    @FindBy(xpath = "//div[@id='SaturdayAsRestDay']//span[@class='dx-checkbox-icon']")
    WebElement restdaycheckbox;

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

        calname.sendKeys(value);
    }

    public void provideFromDate(String value)
    {

        fromDate.clear();
        fromDate.sendKeys(value);
    }

    public void setWeekoff()
    {
        weekoffcheckbox.click();
    }

    public void setRestday()
    {
        restdaycheckbox.click();
    }

    public void clickSaveBack()
    {
        clickSaveAndBack();
    }
}