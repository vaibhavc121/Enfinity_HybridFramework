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

    @FindBy(xpath = "//input[contains(@id,'EmployeeId')]")
    WebElement empdd;
    @FindBy(xpath = "//input[contains(@id,'UIType')]")
    WebElement promotionTypeDD;
    @FindBy(xpath = "//input[contains(@id,'PromotionPeriodId')]")
    WebElement effectiveDate;

    @FindBy(xpath = "//span[normalize-space()='Assign New Salary Component']")
    private WebElement assignNewSalaryComponent;

    @FindBy(xpath = "//input[contains(@id,'SalaryComponentId')]")
    private WebElement SalaryComponentdd;

    @FindBy(xpath = "//input[contains(@id,'CurrentAmount')]")
    private WebElement salAmount;

    @FindBy(xpath = "//input[contains(@id,'EffectiveFromDate')]")
    private WebElement effectiveFromDate;

    @FindBy(xpath = "(//span[text()='Save'])[2]")
    private WebElement savePopup;

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
    WebElement effectiveFromDate1;
    @FindBy(xpath = "(//span[text()='Employee'])[2]")
    WebElement employee;
    @FindBy(xpath = "//div[@class='salary-component-info']//p")
    WebElement salCompInfo;

    //endregion

    //region Action Methods
    public void clickPromotion()
    {
        promotion.click();
        waitTS(2);
    }

    public void clickNew()
    {
        try
        {
            clickOnNew();
        } catch (Exception e)
        {
            clickOnNew();
        }
        waitTS(3);
    }

    public void provideEmployee(String value)
    {
        provideAndEnter(empdd, value);
    }

    public void provideEffectiveDate(String value)
    {
        waitTS(2);
        provideAndEnter(effectiveDate, value);
    }

    public void selectPromotionType(String value)
    {
        promotionTypeDD.click();
        selectDropdownOption(value);
    }

    public void clickAssignNewSalaryComponent()
    {
        clickOnElement1(assignNewSalaryComponent);
    }

    public void provideSalComponent(String value)
    {
        provideAndEnter(SalaryComponentdd, value);
    }

    public void provideAmt(String value)
    {
        clearAndProvide1(salAmount, value);
    }

    public void provideEffectiveFromDt(String value)
    {
        clearAndProvide1(effectiveFromDate, value);
    }

    public void clickSave()
    {
        clickOnElement1(savePopup);
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