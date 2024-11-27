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
	
	@FindBy(xpath="/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[3]/td[7]") WebElement issueTicket;
	
	@FindBy(xpath="//input[@id='TicketEncashment.EffectiveDate_I']") WebElement effectiveDate;
	
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
	
	String effectiveDt= CommonActions.formattedDateMM();
	public void provideEffectiveDate() throws InterruptedException
	{
		effectiveDate.clear();
		//Thread.sleep(2000);
		effectiveDate.sendKeys(effectiveDt);
	}
	
	public void clkSave()
	{
		CommonActions.clkSave();
	}
	
	public boolean checkAvailableTicket()
	{
		String availableTicket= driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[3]/td[5]")).getText();
		
		double availableTicketDouble = Double.parseDouble(availableTicket);
		if(availableTicketDouble < 1)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void provideIssueTicket()
	{
		issueTicket.click();
		issueTicket.click();
		issueTicket.sendKeys("1");
	}
	
	public void clkView()
	{
		CommonActions.clkView();
	}
	
	public void clkApprove()
	{
		CommonActions.clkApprove();
	}
	
	public boolean isTicketIssued()
	{
		String expemp= "Vaibhav Chavan";
		String expEffectiveDate=effectiveDt;
		
		CommonActions.filterCell5(effectiveDt);
		CommonActions.filterCell6("Vaibhav Chavan");
		
		if(expEffectiveDate.equals(CommonActions.result5()) && CommonActions.result6().contains(expemp))
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	
	
	

}
