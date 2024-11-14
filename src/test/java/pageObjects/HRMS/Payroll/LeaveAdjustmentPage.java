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
	
	@FindBy(xpath="//input[@id='LeaveAdjustment.UnpaidDays_I']") WebElement unpaidDaysTB;
	
	@FindBy(xpath="//textarea[@id='LeaveAdjustment.Description_I']") WebElement remarks;
	
	@FindBy(xpath="//span[normalize-space()='View']") WebElement view;
	
	@FindBy(xpath="//span[normalize-space()='Approve']") WebElement approve;
	
	@FindBy(xpath="/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[6]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]") WebElement filterCell;
	
	@FindBy(xpath="/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/span[1]/a[1]") WebElement result;;
	
	public void clkLeaveAdj()
	{
		leaveAdjustment.click();
	}
	
	public void clkNewBtn()
	{
		newbtn.click();
	}
	
	public void clkEmpDD()
	{
		empdd.click();
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
	
	public void provideUnpaidDaysValue()
	{
		unpaidDaysTB.clear();
		unpaidDaysTB.sendKeys("1");
	}
	
	public void provideRemarks()
	{
		remarks.sendKeys("remarks");
	}
	
	public void clkViewBtn()
	{
		view.click();
	}
	
	public void clkApproveBtn() throws InterruptedException
	{		
		approve.click();
		driver.navigate().back();
		Thread.sleep(2000);
	}
	
	public boolean isTxnCreated()
	{
		String expemp=emp.getText();
		filterCell.sendKeys(expemp);
		String actemp=result.getText();
		
		if(expemp.contains(actemp))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	

}
