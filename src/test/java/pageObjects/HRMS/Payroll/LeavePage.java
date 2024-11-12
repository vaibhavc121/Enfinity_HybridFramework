package pageObjects.HRMS.Payroll;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.HRMS.HRCore.BasePage;
import testBase.BaseClass;

public class LeavePage extends BasePage
{

	public LeavePage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	BaseClass bc=new BaseClass();
	
	@FindBy(css="a[id='TxnInstanceView_I0i3_T'] span[class='dx-vam']") WebElement leave;
	
	@FindBy(xpath="//span[normalize-space()='New']") WebElement newbtn;
	
	@FindBy(xpath="/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/img[1]") WebElement clkempdd;
	
	@FindBy(xpath="//input[@id='Leave.EffectiveDate_I']") WebElement effectiveDate;
	
	@FindBy(xpath="/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/img[1]") WebElement leavetypedd;
	
	@FindBy(xpath="//div[contains(text(),'Absent leave')]") WebElement absentLeave;
	
	@FindBy(xpath="//input[@id='Leave.FromDate_I']") WebElement fromDate;
	
	@FindBy(xpath="//input[@id='Leave.UptoDate_I']") WebElement uptoDate;
	
	@FindBy(xpath="//span[normalize-space()='View']") WebElement view;
	
	@FindBy(xpath="//span[normalize-space()='Approve']") WebElement approve;
	
	@FindBy(xpath="//a[normalize-space()='Leave']") WebElement leavelink;
	
	public void clkLeave()
	{
		leave.click();
	}
	
	public void clkNewBtn()
	{
		newbtn.click();
	}
	
	public void clkEmpDD()
	{
		clkempdd.click();
	}
	
	public void slctEmp()
	{
		List<WebElement> emplist= driver.findElements(By.xpath("//div[@class='lookup-text']"));
		
		for(WebElement empnm:emplist)
		{
			String actemp= empnm.getText();
			if(actemp.contains("alka"))
			{
				empnm.click();
				break;
			}
		}
	
	}
	
	public void provideEffectiveDt()
	{
		effectiveDate.clear();
		effectiveDate.sendKeys("11-11-2024");
	}
	
	public void clkLeaveTypeDD()
	{
		leavetypedd.click();
	}
	
	public void slctLeaveType()
	{
		absentLeave.click();
	}
	
	public void provideFromDt()
	{
		fromDate.clear();
		fromDate.sendKeys("11-11-2024");
	}
	
	public void provideUpToDt()
	{
		uptoDate.clear();
		uptoDate.sendKeys("11-11-2024");
	}	
	
	public void clkView()
	{
		view.click();
	}
	
	public void clkApprove()
	{
		approve.click();
	}
	
	public void clkLeaveLink()
	{
		leavelink.click(); 	
	}
	

}
