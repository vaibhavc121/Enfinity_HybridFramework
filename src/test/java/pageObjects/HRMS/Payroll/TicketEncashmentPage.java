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
	
	public void slctEmp()
	{
		CommonActions.setDropdownValue("Vaibhav Chavan");
	}
	
	public void clkSave()
	{
		CommonActions.clkSave();
	}
	
	public boolean checkAvailableTicket()
	{
		String availableTicket= driver.findElement(By.xpath("//div[normalize-space()='-0.391']")).getText();
		
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
