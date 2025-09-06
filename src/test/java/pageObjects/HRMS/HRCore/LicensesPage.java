package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class LicensesPage extends BasePage
{

    @FindBy(xpath = "//span[normalize-space()='New']")
    WebElement newbtn;

    @FindBy(xpath = "//input[@id='GovtRecruitmentContractLicense.Name_I']")
    WebElement name;

    @FindBy(id = "GovtRecruitmentContractLicense.GovtRecruitmentContractIdLookup_I")
    private WebElement fileNumDD;

    //region Action Methods
    public void clkNewBtn()
    {
        newbtn.click();
    }

    public void provideName()
    {
        clearAndProvide1(name, "Licenses");
    }
    public void selectFileNum()
    {
        provideAndEnter(fileNumDD, "2802210222");
        waitTS(2);
    }

    //endregion
}