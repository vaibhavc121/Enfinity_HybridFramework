package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.BaseTest;
import utilities.CommonActions;

public class BankPage extends BasePage
{

    //region Locators
    @FindBy(xpath = "//input[@id='Bank.Name_I']")
    WebElement bankName;
    //endregion

    //region Action Methods
    public void clickNew()
    {
        clickOnNew();
    }

    public void provideBankName(String value)
    {
        clearAndProvide1(bankName, value);
    }

    public void provideBankName()
    {
        bankName.sendKeys(randomString());
    }

    public void clickSaveBack()
    {
        clickSaveAndBack();
    }

    public boolean isTxnCreated()
    {
        return isTransactionCreated();
    }
    //endregion
}