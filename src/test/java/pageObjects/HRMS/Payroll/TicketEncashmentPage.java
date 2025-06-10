package pageObjects.HRMS.Payroll;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;
import utilities.CommonActions;

public class TicketEncashmentPage extends BasePage
{

	public TicketEncashmentPage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(xpath = "//span[normalize-space()='Ticket Encashment']")
	WebElement ticketEncashment;

	@FindBy(xpath = "//input[@id='TicketEncashment.EmployeeIdLookup_I']")
	WebElement empdd;

	@FindBy(xpath = "//input[@id='TicketEncashment.EffectiveDate_I']")
	WebElement effectiveDate;

	@FindBy(xpath = "//input[@id='TicketEncashment.PaymentType_I']")
	WebElement paymentType;
//	@FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'])[6]")
//	WebElement issueTicket;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[3]/td[7]")
	WebElement issueTicket;

	public void clickTicketEncashment()
	{
		ticketEncashment.click();
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

	public void providePaymentType(String value)
	{
		paymentType.click();
		selectDropdownValueOffice365(value);
		waitTS(2);
	}

	public void clickSave()
	{
		clickOnSave();
	}

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
			clearAndProvide2(issueTicket, value);
		} else
		{
			throw new Exception("VRC- ticket balance is less than 1");
		}
	}

	public void clickSave1()
	{
		clickOnSave();
	}

	public void clickView()
	{
		clickOnView();
	}

	public void clickApproveBack()
	{
		clickApproveAndBack();
	}

	public boolean isTicketIssued()
	{
		String expemp = "Vaibhav Chavan";
		String expEffectiveDate = CommonActions.formattedDateMMM();
		;

		CommonActions.filterCell5(expEffectiveDate);
		CommonActions.filterCell6("Vaibhav Chavan");

		if (expEffectiveDate.equals(CommonActions.result5()) && CommonActions.result6().contains(expemp))
		{
			return true;
		} else
		{
			return false;
		}

	}

}
