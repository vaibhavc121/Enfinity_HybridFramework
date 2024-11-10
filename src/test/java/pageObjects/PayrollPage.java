package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayrollPage extends BasePage
{

	public PayrollPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[normalize-space()='Payroll']") WebElement payroll;
	
	public void clkPayroll()
	{
		payroll.click();
	}
	

}
