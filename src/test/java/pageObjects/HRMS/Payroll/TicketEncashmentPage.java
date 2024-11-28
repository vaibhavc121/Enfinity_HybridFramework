package pageObjects.HRMS.Payroll;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		//issueTicket.click();
		//issueTicket.sendKeys("1");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[3]/td[7]")));

		if (element.isDisplayed() && element.isEnabled()) {
		    try {
		        element.click(); // Clear existing text, if any
		        element.sendKeys("1"); // Send value to the textbox
		    } catch (ElementNotInteractableException e) {
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].value='1';", element); // Set value using JavaScript
		    }
		} else {
		    System.out.println("Element is either not visible or not enabled.");
		}
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
		String expEffectiveDate=CommonActions.formattedDateMMM();;
		
		CommonActions.filterCell5(expEffectiveDate);
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
