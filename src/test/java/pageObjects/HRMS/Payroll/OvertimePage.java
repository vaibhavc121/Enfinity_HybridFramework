package pageObjects.HRMS.Payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.HRMS.HRCore.BasePage;
import utilities.CommonActions;

public class OvertimePage extends BasePage
{

	public OvertimePage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='Overtime']") WebElement overtime;
	
	@FindBy(xpath="//img[@id='Overtime.EmployeeIdLookup_B-1Img']") WebElement empdd;
	
	public void clkOvertime()
	{
		overtime.click();
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

}
