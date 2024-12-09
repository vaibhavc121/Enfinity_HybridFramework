package pageObjects.HRMS.Payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.HRMS.HRCore.BasePage;
import utilities.CommonActions;

public class LoanPage extends BasePage
{

	public LoanPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//a[@id='TxnInstanceView_I0i13_T']//span[@class='dx-vam'][normalize-space()='Loan']") WebElement loan;
	
	@FindBy(xpath="//img[@id='Loan.EmployeeIdLookup_B-1Img']") WebElement empdd;
	
	@FindBy(xpath="//img[@id='Loan.LoanTypeIdLookup_B-1Img']") WebElement loanTypeDD;
	
	@FindBy(xpath="//img[@id='Loan.RepaymentStartPeriodIdLookup_B-1Img']") WebElement loanRepaymentStartPeriod;
	
	@FindBy(xpath="//input[@id='Loan.LoanAmountFC_I']") WebElement loanAmount;
	
	@FindBy(xpath="//input[@id='Loan.AmountOfInstallments_I']") WebElement amountOfInstallments;
	
	public String expEmp="155";
	public String expLoanAmt="50";
	public String expInstallment="2";
	public String expLoanType="Car Loan";
	
	
	
	public void clkLoan()
	{
		loan.click();
	}
	
	public void clkNew()
	{
		CommonActions.clkNew();
	}
	
	public void clkEmpDD()
	{
		empdd.click();
	}
	
	public void slctEmp() throws InterruptedException
	{
		CommonActions.setDropdownValue(expEmp);
	}
	
	public void clkLoanTypeDD()
	{
		loanTypeDD.click();
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
		CommonActions.setDropdownValue("Jan-2025");
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
		CommonActions.clkView();
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
		if(CommonActions.result6().contains(expEmp) && CommonActions.result8().contains(expLoanAmt))
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}

}
