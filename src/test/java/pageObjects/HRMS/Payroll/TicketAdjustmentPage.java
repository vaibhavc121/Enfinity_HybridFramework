package pageObjects.HRMS.Payroll;

import org.openqa.selenium.By;
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

	@FindBy(xpath = "//input[@id='TicketEncashment.EmployeeIdLookup_I']")
	WebElement empdd;

	@FindBy(xpath = "//td[@id='TicketEncashment.PaymentType_B-1']")
	WebElement paymentTypeDD;

	@FindBy(xpath = "//td[@id='TicketEncashment.PaymentType_DDD_L_LBI0T0']")
	WebElement payWithPayroll;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-new-icon']")
	WebElement newLine;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[3]/td[7]/div[1]")
	WebElement issueTicket;

	@FindBy(xpath = "//tbody/tr[@id='TicketEncashmentLine_DXDataRow-1']/td[7]/div[1]")
	WebElement issueTicket1;

	@FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'])[6]")
	WebElement issueTicket2;

	@FindBy(xpath = "//td[@class='dx-ellipsis']")
	WebElement grid;

	public void clickTicketAdjustment()
	{
		ticketAdjustment.click();
	}

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideEmployee(String value)
	{
		clearAndProvide1(empdd, value);
		waitTS(2);
	}

	public void selectPaymentType(String value)
	{
		paymentTypeDD.click();
		selectDropdownValueOffice365(value);
		waitTS(2);
	}

	public void clickSave()
	{
		clickOnSave();
	}

//	public void clkNewline()
//	{
//		newLine.click();
//	}
	public boolean checkAvailableTicket()
	{
		String availableTicket = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[3]/td[5]"))
				.getText();

		// String availableTicket = driver.findElement(By.xpath("(//div[@class='dxgBCTC
		// dx-ellipsis'])[4]")).getText();

		double availableTicketDouble = Double.parseDouble(availableTicket);
		if (availableTicketDouble > 1)
		{
			return true;
		} else
		{
			return false;
		}
	}

	public void provideIssueTickets(String value) throws Exception
	{
		if (checkAvailableTicket())
		{
			// clearAndProvide2(issueTicket, value);
			// clearAndProvide2(issueTicket, value);
			grid.click();
			clearAndProvide2(issueTicket1, value);
			issueTicket.sendKeys(value);

			// clearAndProvide1(issueTicket, value);
		} else
		{
			throw new Exception("VRC- ticket balance is less than 1");
		}
	}

	public void clickView()
	{
		clickOnView();
	}

	public void clickApproveBack()
	{
		clickApproveAndBack();
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
