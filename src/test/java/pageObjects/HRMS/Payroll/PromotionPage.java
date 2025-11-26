package pageObjects.HRMS.Payroll;

import base.BasePage;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    //region Job Profile Revision
    @FindBy(xpath = "//input[contains(@id,'NewDepartmentId')]")
    private WebElement department;

    @FindBy(xpath = "//input[contains(@id,'NewDesignationId')]")
    private WebElement designation;

    @FindBy(xpath = "//input[contains(@id,'NewWorkLocationId')]")
    private WebElement workLocation;

    @FindBy(xpath = "//input[contains(@id,'NewManagerEmployeeId')]")
    private WebElement manager;

    @FindBy(xpath = "//input[contains(@id,'NewProjectId')]")
    private WebElement project;

    @FindBy(xpath = "//span[@class='dx-button-text'][normalize-space()='Save']")
    private WebElement save;

    //endregion

    //region Promotion Request
    @FindBy(xpath = "//a[@title='Revise']")
    private WebElement reviseBtn;
    @FindBy(xpath = "//input[contains(@id,'IncrementAmount')]")
    private WebElement addIncrementAmt;
    @FindBy(name = "Remarks")
    private WebElement remarks;

    //endregion

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

    public void providePromotionPeriod(String value)
    {
        waitTS(2);
        WebElement element = waitForElement(effectiveDate);
        element.click();
        Actions actions = new Actions(DriverFactory.getDriver());
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        waitTS(1);
        element.sendKeys(value);
        waitTS(3);
        element.sendKeys(Keys.ENTER);
    }

    public void selectPromotionType(String value)
    {
        promotionTypeDD.click();
        selectDropdownOption(value);
    }

    public void clickAssignNewSalaryComponent()
    {
        waitTS(1);
        clickOnElement1(assignNewSalaryComponent);
    }

    public void provideSalComponent(String value)
    {
        waitTS(2);
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

    //region Job Profile Revision
    public void provideDept(String value)
    {
        provideAndEnter(department, value);
    }
    public void provideDesignation(String value)
    {
        provideAndEnter(designation, value);
    }
    public void provideWorkLocation(String value)
    {
        provideAndEnter(workLocation, value);
    }
    public void provideManager(String value)
    {
        provideAndEnter(manager, value);
    }
    public void provideProject(String value)
    {
        provideAndEnter(project, value);
    }
    public void savePopup()
    {
        waitTS(2);
        clickOnElement1(save);
    }

    //endregion

    //region Promotion Request
    public void clickReviseBtn()
    {
        clickOnElement1(reviseBtn);
    }

    public void provideIncrementAmt(String value)
    {
        clearAndProvide1(addIncrementAmt, value);
    }

    public void provideRemarks(String value)
    {
        clearAndProvide1(remarks, value);
    }

    public boolean isCorrectRviseAmtDisplay(String incrementAmt)
    {
        Double increAmt = Double.parseDouble(incrementAmt);
        Double amount = DataUtils.extractNumericValueFromText(waitForElement1(By.xpath("(//table//tr)[2]//td[2]")));

        String expRevisedAmt = String.valueOf(increAmt + amount);
        Double expRevisedAmt1 = increAmt + amount;

        String actualRevisedAmt = waitForElement1(By.xpath("(//table//tr)[2]//td[3]")).getText();
        Double actReviseAmt2 = Double.parseDouble(actualRevisedAmt);
        if (actualRevisedAmt.contains(expRevisedAmt))
        {
            return true;
        } else
        {
            return false;
        }
    }
    //endregion

    //endregion
}