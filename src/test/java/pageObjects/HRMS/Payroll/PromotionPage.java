package pageObjects.HRMS.Payroll;

import base.BasePage;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.HRMS.HRCore.EmployeePage;
import pageObjects.HRMS.HRCore.EmployeePage1;
import utilities.DataUtils;

public class PromotionPage extends BasePage
{

    //region Locators
    @FindBy(xpath = "//span[contains(text(),'Promotion')]")
    private WebElement promotion;

    @FindBy(xpath = "//input[@id='EmployeePromotion.EmployeeIdLookup_I']")
    WebElement empdd;
    @FindBy(xpath = "//input[@id='EmployeePromotion.EffectiveDate_I']")
    WebElement effectiveDate;
    @FindBy(xpath = "//input[@id='EmployeePromotion.Type_I']")
    WebElement promotionTypeDD;
    @FindBy(xpath = "//input[@id='EmployeePromotion.NewDesignationIdLookup_I']")
    WebElement newDesignation;
    @FindBy(xpath = "//span[text()='Salaries']")
    WebElement salaries;
    @FindBy(xpath = "//input[@id='EmployeePromotionLine_SalaryComponentId_I']")
    WebElement salcompdd;
    //@FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'])[3]") WebElement incrementAmt;
    @FindBy(xpath = "//td[@class=' grid-cell dx-wrap dxgv dx-ellipsis dx-ar']//div[@class='dxgBCTC dx-ellipsis'][normalize-space()='0']")
    WebElement incrementAmt;
    @FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'])[5]")
    WebElement effectiveFromDate;
    @FindBy(xpath = "(//span[text()='Employee'])[2]")
    WebElement employee;
    @FindBy(xpath = "//div[@class='salary-component-info']//p")
    WebElement salCompInfo;

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
        promotionTypeDD.click();
        selectDropdownValueOffice365(value);
    }

    public void provideNewDesignation(String value)
    {
        clearAndProvide1(newDesignation, value);
    }

    public void clickSave()
    {
        clickOnSave();
    }

    public void scrollToElement()
    {
        waitTS(2);
        //scrollIntoView(DriverFactory.getDriver(), salaries);
        scrollToBottom(DriverFactory.getDriver());
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
        provideAndEnter(salcompdd, value);
    }

    public void provideIncrementAmt(String value) throws InterruptedException
    {
        waitTS(2);
        clearAndProvide2(incrementAmt, value);
    }

    public void provideEffectiveFromDate(String value) throws InterruptedException
    {
        waitTS(2);
        clearAndProvide2(effectiveFromDate, value);
    }

    public void clickViewApproveBack()
    {
        clickOnViewApproveBack();
    }

    public double getSalary(String empname)
    {
        employee.click();
        navigateToEmployee(empname);
        EmployeePage ep = new EmployeePage();
        ep.clickPayroll();
        return DataUtils.extractNumericValueFromText(salCompInfo);
    }

    //endregion
}