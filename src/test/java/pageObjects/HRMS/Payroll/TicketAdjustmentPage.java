package pageObjects.HRMS.Payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class TicketAdjustmentPage extends BasePage
{

	public TicketAdjustmentPage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(xpath = "//span[normalize-space()='Ticket Adjustment']")
	WebElement ticketAdjustment;

	@FindBy(xpath = "//img[@id='TicketEncashment.EmployeeIdLookup_B-1Img']")
	WebElement empdd;

	@FindBy(xpath = "//td[@id='TicketEncashment.PaymentType_B-1']")
	WebElement paymentTypeDD;

	@FindBy(xpath = "//td[@id='TicketEncashment.PaymentType_DDD_L_LBI0T0']")
	WebElement payWithPayroll;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-new-icon']")
	WebElement newLine;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[5]/td[7]")
	WebElement issueTicket;

	@FindBy(xpath = "//tbody/tr[@id='TicketEncashmentLine_DXDataRow-1']/td[7]/div[1]")
	WebElement issueTicket1;

	public void clkTicketAdjustment()
	{
		ticketAdjustment.click();
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
		CommonActions.setDropdownValue("Vaibhav Chavan");
	}

	public void clkPaymentTypeDD()
	{
		paymentTypeDD.click();
	}

	public void slctPaymentType()
	{
		payWithPayroll.click();
	}

	public void clkSave()
	{
		clickOnSave();
	}

//	public void clkNewline()
//	{
//		newLine.click();
//	}

	public void provideIssueTicket()
	{
		issueTicket1.click();
		issueTicket1.sendKeys("2");
	}

	public void clkView()
	{
		clickOnView();
	}

	public void clkApprove()
	{
		clickOnApprove();
	}

	public boolean isTxnCreated()
	{
		String expectedEmp = "Vaibhav Chavan";
		String expectedDate = CommonActions.formattedDateMMM();

		CommonActions.filterCell5(expectedDate);
		CommonActions.filterCell6(expectedEmp);

		if (CommonActions.result5().contains(expectedDate) && CommonActions.result6().contains(expectedEmp))
		{
			return true;
		} else
		{
			return false;
		}

	}
}
