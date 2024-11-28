package pageObjects.HRMS.Payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.HRMS.HRCore.BasePage;
import utilities.CommonActions;

public class TicketAdjustmentPage extends BasePage
{

	public TicketAdjustmentPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='Ticket Adjustment']") WebElement ticketAdjustment;
	
	@FindBy(xpath="//img[@id='TicketEncashment.EmployeeIdLookup_B-1Img']") WebElement empdd;
	
	public void clkTicketAdjustment()
	{
		ticketAdjustment.click();
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
		CommonActions.setDropdownValue1("Usha Fulzele");
	}
	
	

}
