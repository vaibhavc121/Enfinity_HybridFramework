package pageObjects.HRMS.Payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.WaitUtils;

public class ReportsPage extends BasePage
{

	public ReportsPage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[2]")
	WebElement filtercolumn;

	@FindBy(xpath = "//td[normalize-space()='Ticket Balance']")
	WebElement resultcolumn;

	@FindBy(xpath = "//span[normalize-space()='Preview']")
	WebElement preview;

	@FindBy(xpath = "//input[contains(@id,'EmployeeId')]")
	WebElement empdd;

	@FindBy(xpath = "//span[@class='dx-button-text']")
	WebElement submit;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[6]")
	WebElement availableTicket;

	public void openReport(String value)
	{
		filtercolumn.sendKeys(value);
		resultcolumn.click();
		preview.click();
		WaitUtils.waitTS(2);
		switchTab();
		WaitUtils.waitTS(2);
	}

	public double getTicketBalance(String emp)
	{
		clearAndProvide1(empdd, emp);
		submit.click();
		String bal = availableTicket.getText();
		double expBal = Double.parseDouble(bal);
		return expBal;
	}

}
