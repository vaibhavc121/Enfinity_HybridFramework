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
		CommonActions.setDropdownValue("155");
	}
	
	public void clkLoanTypeDD()
	{
		loanTypeDD.click();
	}
	
	public void slctLoanType() throws InterruptedException
	{
		CommonActions.setDropdownValue("Car Loan");
	}
	
	public void clkloanRepaymentStartPeriodDD()
	{
		loanRepaymentStartPeriod.click();
	}
	
	public void setLoanRepaymentStartPeriod() throws InterruptedException
	{
		CommonActions.setDropdownValue("Jan-2025");
	}

}
