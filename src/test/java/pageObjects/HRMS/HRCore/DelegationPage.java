package pageObjects.HRMS.HRCore;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.BrowserUtils;
import utilities.CommonActions;

import java.util.List;

public class DelegationPage extends BasePage
{

    //region Locators
    @FindBy(xpath = "//span[normalize-space()='New']")
    WebElement newbtn;

    @FindBy(xpath = "//input[contains(@id,'FromUserId')]")
    private WebElement delegator;

    @FindBy(xpath = "//input[contains(@id,'ToUserId')]")
    private WebElement delegatee;

    @FindBy(xpath = "//input[contains(@id,'DepartmentSecurityMode')]")
    private WebElement deptSecurityMode;

    @FindBy(xpath = "//input[contains(@id,'FromDate')]")
    private WebElement fromDate;

    @FindBy(xpath = "//input[contains(@id,'ToDate')]")
    private WebElement toDate;

    @FindBy(xpath = "//span[normalize-space()='Delete']")
    private WebElement delete;

    @FindBy(xpath = "(//tr)[6]//td[3]")
    private static WebElement row;

    //endregion

    //region Action Methods
    public void clkNewBtn()
    {
        clickOnNew();
    }

    public void provideDelegator(String delegatorName)
    {
        provideAndEnter(delegator, delegatorName);
    }

    public void provideDelegatee(String delegateeName)
    {
        provideAndEnter(delegatee, delegateeName);
    }

    public void selectOption(String expOption)
    {
        List<WebElement> optionElement = DriverFactory.getDriver().findElements(By.xpath("//div[@class='dx-item-content']"));

        for (WebElement option : optionElement)
        {
            if (option.getText().equals(expOption))
            {
                option.click();
                break;
            }
        }
    }

    public void selectScope(String scope)
    {
        selectOption(scope);
    }
    public void selectDeptSecurityMode(String deptSecMode)
    {
        provideAndEnter(deptSecurityMode, deptSecMode);
    }
    public void selectDelegationType(String delegationType)
    {
        selectOption(delegationType);
    }
    public void provideFromDate(String value)
    {
        clearAndProvide1(fromDate, value);
    }
    public void provideToDate(String value)
    {
        clearAndProvide1(toDate, value);
    }
    public void selectNotification(String notification)
    {
        selectOption(notification);
    }

    public void provideDesc(String value)
    {
        provideDescription(value);
    }

    public void clkSaveBtn()
    {
        CommonActions.clkSave();
    }

    public void clickDelete()
    {
        waitTS(2);
        clickOnElement1(delete);
        waitTS(2);
        pressEnter();
        waitTS(2);
        //BrowserUtils.navigateBack(DriverFactory.getDriver());
    }

    public static void filterAndOpenTransaction(int filterIndex, int resultIndex, String expValue, String mode)
    {
        filterByIndex(filterIndex, expValue);
        waitTS(2);
        String actValue = resultValue(resultIndex);
        if (actValue.contains(expValue))
        {
            selectRow1();
            if (mode.contains("view"))
            {
                clickOnViewListing();
            } else
            {
                clickOnEditListing();
            }
        } else
        {
            throw new RuntimeException("VRC- No matching record found");
        }
    }

    public static void selectRow1()
    {
        clickOnElement1(row);
    }
    //endregion
}