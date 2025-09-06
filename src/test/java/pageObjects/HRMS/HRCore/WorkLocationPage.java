package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class WorkLocationPage extends BasePage
{

    @FindBy(xpath = "//input[@id='WorkLocation.Name_I']")
    WebElement workLocationName;

    public void clickNew()
    {
        clickOnNew();
    }

    public void provideWorkLocName(String value)
    {
        workLocationName.sendKeys(value);
    }

    public void provideWorkLocName()
    {
        workLocationName.sendKeys(randomString());
    }

    public void clickSaveBack()
    {
        clickSaveAndBack();
    }

    public boolean isTxnCreated()
    {
        return isTransactionCreated();
    }
}