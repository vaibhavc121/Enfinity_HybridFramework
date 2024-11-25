package pageObjects.HRMS.Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.HRMS.HRCore.BasePage;
import utilities.CommonActions;

public class TicketEncashmentPage extends BasePage
{

	public TicketEncashmentPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='Ticket Encashment']") WebElement ticketEncashment;
	
	@FindBy(xpath="//img[@id='TicketEncashment.EmployeeIdLookup_B-1Img']") WebElement empdd;
	
	public void clkTicketEncashment()
	{
		ticketEncashment.click();
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
		CommonActions.setDropdownValue("Vaibhav Chavan");
	}
	
	public void clkSave()
	{
		CommonActions.clkSave();
	}
	
	public boolean checkAvailableTicket()
	{
		String availableTicket= driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[3]/td[5]")).getText();
		
		int availableTicketInt=Integer.parseInt(availableTicket);
		if(availableTicketInt < 1)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

}
