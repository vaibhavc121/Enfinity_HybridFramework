package pageObjects.HRMS.Payroll;

import base.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoanPage extends BasePage
{

    public LoanPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Loan']")
    private WebElement loan;

    @FindBy(xpath = "//input[@id='Loan.EmployeeIdLookup_I']")
    private WebElement empdd;

    @FindBy(xpath = "//input[@id='Loan.EffectiveDate_I']")
    private WebElement effectiveDate;

    @FindBy(xpath = "//input[@id='Loan.LoanTypeIdLookup_I']")
    private WebElement loanTypeDD;

    @FindBy(xpath = "//input[@id='Loan.RepaymentStartPeriodIdLookup_I']")
    private WebElement repaymentStartPeriod;

    @FindBy(xpath = "//input[@id='Loan.LoanAmountFC_I']")
    private WebElement loanAmount;

    @FindBy(xpath = "//input[@id='Loan.AmountOfInstallments_I']")
    private WebElement amountOfInstallments;

    @FindBy(xpath = "//textarea[@id='Loan.Description_I']")
    private WebElement remarks;

    public void clickLoan()
    {
        loan.click();
    }

    public void clickNew()
    {
        clickOnNew();
    }

    public void provideEmp(String value)
    {
        clearAndProvide1(empdd, value);
    }

    public void provideEffectiveDate(String value)
    {
        clearAndProvide1(effectiveDate, value);
    }

    public void provideLoanType(String value)
    {
        clearAndProvide1(loanTypeDD, value);
    }

    public void provideRepaymentStartPeriod(String value)
    {
        clearAndProvide1(repaymentStartPeriod, value);
    }

    public void provideLoanAmt(String value)
    {
        clearAndProvide1(loanAmount, value);
    }

    public void provideAmountOfInstallments(String value)
    {
        clearAndProvide1(amountOfInstallments, value);
    }

    public void provideRemarks(String value)
    {
        clearAndProvide1(remarks, value);
    }

    public void clickViewApproveBack()
    {
        clickOnViewApproveBack();
    }
}