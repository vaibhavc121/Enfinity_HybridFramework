package pageObjects.HRMS.Payroll;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class LoanPage extends BasePage
{

	public LoanPage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(xpath = "//span[normalize-space()='Overtime']//following::span[@class='dx-vam'][normalize-space()='Loan']")
	WebElement loan;

	@FindBy(xpath = "//img[@id='Loan.EmployeeIdLookup_B-1Img']")
	WebElement empdd;

	@FindBy(xpath = "//img[@id='Loan.LoanTypeIdLookup_B-1Img']")
	WebElement loanTypeDD;

	@FindBy(xpath = "//input[@id='Loan.RepaymentStartPeriodIdLookup_I']")
	WebElement repaymentStartPeriod;

	@FindBy(xpath = "//img[@id='Loan.RepaymentStartPeriodIdLookup_B-1Img']")
	WebElement loanRepaymentStartPeriod;

	@FindBy(xpath = "//input[@id='Loan.LoanAmountFC_I']")
	WebElement loanAmount;

	@FindBy(xpath = "//input[@id='Loan.AmountOfInstallments_I']")
	WebElement amountOfInstallments;

	public String expEmp = "002";
	public String expLoanAmt = "50";
	public String expInstallment = "2";
	public String expLoanType = "Car Loan";

	public void clkLoan()
	{
		loan.click();
	}

	public void clkNew()
	{
		clickOnNew();
	}

	public void clkEmpDD()
	{
		empdd.click();
	}

	public void slctEmp() throws InterruptedException
	{
		CommonActions.setDropdownValue(expEmp);
	}

	public void clkLoanTypeDD() throws InterruptedException
	{
		loanTypeDD.click();
		Thread.sleep(2000);
	}

	public void slctLoanType() throws InterruptedException
	{
		CommonActions.setDropdownValue(expLoanType);
	}

	public void clkloanRepaymentStartPeriodDD()
	{
		loanRepaymentStartPeriod.click();
	}

	public void setLoanRepaymentStartPeriod() throws InterruptedException
	{
		repaymentStartPeriod.click();
		repaymentStartPeriod.clear();
		repaymentStartPeriod.sendKeys("Jan-2025");
		Thread.sleep(2000);
		repaymentStartPeriod.sendKeys(Keys.ENTER);

	}

	public void provideLoanAmt()
	{
		loanAmount.sendKeys(expLoanAmt);
	}

	public void provideAmountOfInstallments()
	{
		amountOfInstallments.sendKeys(expInstallment);
	}

	public void clkView()
	{
		clickOnView();
	}

	public void clkApprove()
	{
		CommonActions.clkApprove();
	}

	public boolean isTxnCreated()
	{
//		String expEmp="Prachi Rawat";
//		String expLoanAmt="50";
//		String expInstallment="2";
		if (CommonActions.result6().contains(expEmp) && CommonActions.result8().contains(expLoanAmt))
		{
			return true;
		} else
		{
			return false;
		}

	}

}