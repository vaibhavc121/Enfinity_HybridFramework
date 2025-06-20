package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.BaseTest;
import utilities.CommonActions;

public class BankPage extends BasePage
{

    public BankPage(WebDriver driver)
    {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    @FindBy(xpath = "//input[@id='Bank.Name_I']")
    WebElement bankName;

    public void clickNew()
    {
        clickOnNew();
    }

    public void provideBankName(String value)
    {
       
        bankName.sendKeys(value);
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
}