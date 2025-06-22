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

	public void clickSalaries()
	{
        salaries.click();
	}
//
//	public void a()
//	{
//	}
//
//	public void a()
//	{
//	}
//
//	public void a()
//	{
//	}
//
//	public void a()
//	{
//	}
//
//	public void a()
//	{
//	}
//
//	public void a()
//	{
//	}
    //endregion
}