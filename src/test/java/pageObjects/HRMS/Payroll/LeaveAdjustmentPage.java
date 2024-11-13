package pageObjects.HRMS.Payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.HRMS.HRCore.BasePage;

public class LeaveAdjustmentPage extends BasePage
{

	public LeaveAdjustmentPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[normalize-space()='Leave Adjustment']") WebElement leaveAdjustment;
	
	@FindBy(xpath="//span[normalize-space()='New']") WebElement newbtn;
	
	@FindBy(css="img[id='LeaveAdjustment.EmployeeIdLookup_B-1Img']") WebElement empdd;
	
	@FindBy(xpath="//div[contains(text(),'001 | Vaibhav Chavan')]") WebElement emp;
	
	@FindBy(css="img[id='LeaveAdjustment.LeaveTypeIdLookup_B-1Img']") WebElement leavetypedd;
	
	@FindBy(xpath="//div[contains(text(),'Sick Leave')]") WebElement sickLeave;
	
	@FindBy(xpath="//input[@id='LeaveAdjustment.PaidDays_I']") WebElement paidDaysTB;
	
	public void clkLeaveAdj()
	{
		leaveAdjustment.click();
	}
	
	public void clkNewBtn()
	{
		newbtn.click();
	}
	
	public void slctEmp()
	{
		emp.click();
	}
	
	public void clkLeaveTypeDD()
	{
		leavetypedd.click();
	}
	
	public void slctLeaveType()
	{
		sickLeave.click();
	}
	
	public void providePaidDaysValue()
	{
		paidDaysTB.clear();
		paidDaysTB.sendKeys("1");
	}

}
