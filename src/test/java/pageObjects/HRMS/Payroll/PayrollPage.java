package pageObjects.HRMS.Payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class PayrollPage extends BasePage
{

	public PayrollPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[normalize-space()='Payroll']")
	WebElement payroll;

	@FindBy(xpath = "//span[@class='dxnb-ghtext']")
	WebElement transactions;

	@FindBy(xpath = "//span[normalize-space()='Reports']")
	WebElement reports;

	public void clkPayroll()
	{
		payroll.click();
	}

	public void clkTxn()
	{
		transactions.click();
	}

	public void clickReports()
	{
		reports.click();
	}

}
