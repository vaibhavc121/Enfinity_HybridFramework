package pageObjects.HRMS.Payroll;

import base.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PromotionPage extends BasePage
{
    public PromotionPage(WebDriver driver)
    {
        super(driver);
    }

    //region Locators
    @FindBy(xpath = "(//span[text()='Promotion'])[2]")
    WebElement promotion;

    @FindBy(xpath="//input[@id='EmployeePromotion.EmployeeIdLookup_I']") WebElement empdd;
    @FindBy(xpath="//input[@id='EmployeePromotion.EffectiveDate_I']") WebElement effectiveDate;
    @FindBy(xpath="//input[@id='EmployeePromotion.Type_I']") WebElement type;
    @FindBy(xpath="//span[text()='Salaries']") WebElement salaries;
    @FindBy(xpath="//input[@id='EmployeePromotionLine_SalaryComponentId_I']") WebElement salcompdd;
    @FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'])[3]") WebElement incrementAmt;
    @FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'])[5]") WebElement effectiveFromDate;

    //endregion

    //region Action Methods
    public void clickPromotion()
    {
        promotion.click();
    }

    public void clickNew()
    {
        clickOnNew();
    }

	public void provideEmployee(String value)
	{
        clearAndProvide1(empdd, value);
    }

	public void provideEffectiveDate(String value)
	{
        clearAndProvide1(effectiveDate, value);
	}

	public void selectPromotionType(String value)
	{
        selectDropdownValueOffice365(value);
	}

    public void clickSave()
    {
        clickOnSave();
    }

    public void scrollToElement()
    {
        scrollIntoView(driver, salaries);
    }

	public void clickSalaries()
	{
        salaries.click();
	}

    public void clickNew1()
    {
        clickOnNewLine();
    }

	public void provideSalComp(String value)
	{
        clearAndProvide1(salcompdd,value);
	}

    public void provideIncrementAmt(String value) throws InterruptedException
    {
        clearAndProvide2(incrementAmt, value);
    }

    public void provideEffectiveFromDate(String value) throws InterruptedException
    {
        clearAndProvide2(effectiveFromDate, value);
    }

    public void clicViewApproveBack()
    {
        clickOnViewApproveBack();
    }
    //todo: validate from emp sal component






    //endregion
}