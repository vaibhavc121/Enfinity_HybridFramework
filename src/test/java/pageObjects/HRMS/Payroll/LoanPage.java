package pageObjects.HRMS.Payroll;

import base.SelenideBasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import base.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoanPage extends SelenideBasePage
{



	SelenideElement loan = $("//span[normalize-space()='Loan']");
	SelenideElement empdd = $x("//input[@id='Loan.EmployeeIdLookup_I']");
	SelenideElement effectiveDate = $x("//input[@id='Loan.EffectiveDate_I']");
	SelenideElement loanTypeDD = $x("//input[@id='Loan.LoanTypeIdLookup_I']");
	SelenideElement repaymentStartPeriod = $x("//input[@id='Loan.RepaymentStartPeriodIdLookup_I']");
	SelenideElement loanAmount = $x("//input[@id='Loan.LoanAmountFC_I']");
	SelenideElement amountOfInstallments = $x("//input[@id='Loan.AmountOfInstallments_I']");
	SelenideElement remarks = $x("//textarea[@id='Loan.Description_I']");



	public void clickLoan()
	{
		loan.click();
	}

	public void clickNew()
	{
		SelenideBasePage.clickOnNew();
	}

	public void provideEmp(String value)
	{
		SelenideBasePage.clearAndProvide1(empdd, value);
	}

	public void provideEffectiveDate(String value)
	{
		SelenideBasePage.clearAndProvide1(effectiveDate, value);
	}

	public void provideLoanType(String value)
	{
		SelenideBasePage.clearAndProvide1(loanTypeDD, value);
	}

	public void provideRepaymentStartPeriod(String value)
	{
		SelenideBasePage.clearAndProvide1(repaymentStartPeriod, value);
	}

	public void provideLoanAmt(String value)
	{
		SelenideBasePage.clearAndProvide1(loanAmount,value);
	}

	public void provideAmountOfInstallments(String value)
	{
		SelenideBasePage.clearAndProvide1(amountOfInstallments, value);
	}

	public void provideRemarks(String value)
	{
		SelenideBasePage.clearAndProvide1(remarks, value);
	}

	public void clickViewApproveBack()
	{
		SelenideBasePage.clickOnViewApproveBack();
	}






}