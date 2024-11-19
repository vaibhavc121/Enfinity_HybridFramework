package pageObjects.HRMS.Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.HRMS.HRCore.BasePage;
import utilities.CommonActions;

public class IndemnityAdjustmentPage extends BasePage
{

	public IndemnityAdjustmentPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@title='Indemnity Adjustment']//span[@class='dx-vam'][normalize-space()='Indemnity Adjustment']") WebElement indemnityAdjustment;
	
	@FindBy(xpath="//img[@id='GratuityAdjustment.EmployeeIdLookup_B-1Img']") WebElement empdd;
	
	@FindBy(xpath="//div[contains(text(),'003 | rahul')]") WebElement emp;
	
	@FindBy(xpath="//img[@id='GratuityAdjustment.GratuityIdLookup_B-1Img']") WebElement indemnitydd;
	
	@FindBy(xpath="//div[contains(text(),'Indemnity')]") WebElement indemnity;
	
	@FindBy(xpath="//input[@id='GratuityAdjustment.PaidDays_I']") WebElement paidDays;
	
	@FindBy(xpath="//td[@class='dx-editor-cell dx-focused']//input[@aria-label='Filter cell']") WebElement filterCell;
	
	@FindBy(xpath="//a[normalize-space()='003 | rahul']") WebElement result;
	
	@FindBy(xpath="//td[@class='dx-editor-cell dx-focused']//input[@aria-label='Filter cell']") WebElement filterIndAmt;
	
	@FindBy(xpath="//tr[@class='dx-row dx-data-row dx-row-lines dx-column-lines dx-state-hover']//td[@role='gridcell'][normalize-space()='19.231']") WebElement resultIndAmt;
	
	
//	String IndemnityBal=driver.findElement(By.xpath("//input[@id='GratuityAdjustment.GratuityBalance_I")).getText();
//	int actIndBalInt=Integer.parseInt(IndemnityBal);
//	int expindbal=actIndBalInt-1;
	
	
	public void clkIndemnityAdjustment()
	{
		indemnityAdjustment.click();
	}
	
	public void clkNewBtn()
	{
		CommonActions.clkNew();
	}
	
	public void clkEmpDD() throws InterruptedException
	{
		empdd.click();
		Thread.sleep(3000);
	}
	
	public void slctEmp() throws InterruptedException
	{
		emp.click();
		Thread.sleep(2000);
	}
	
	public void clkIndemnityDD()
	{
		indemnitydd.click();
	}
	
	public void slctIndemnity()
	{
		indemnity.click();
	}
	
	public void providePaidDays()
	{
		paidDays.clear();
		paidDays.sendKeys("1");
	}
	
	public void clkView()
	{
		CommonActions.clkView();
	}
	
	public void clkApprove() throws InterruptedException
	{
		CommonActions.clkApprove();
		driver.navigate().back();
		Thread.sleep(3000);
	}
	
	
	public boolean isTxnCreated()
	{
		String expemp= emp.getText();
		String expIndAmt="19.231";
		
		filterCell.sendKeys(expemp);
		filterIndAmt.sendKeys(expIndAmt);
		String actemp=result.getText();
		String actIndamt= resultIndAmt.getText();
		
		if(actemp.contains(expemp) && expIndAmt.equals(actIndamt))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	

}
