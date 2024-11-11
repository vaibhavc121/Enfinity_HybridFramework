package pageObjects.HRMS.Payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.HRMS.HRCore.BasePage;

public class VariableSalaryPage extends BasePage 
{

	public VariableSalaryPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[1]")
	WebElement variableSalary;

	@FindBy(xpath = "//span[normalize-space()='New']")
	WebElement newbtn;
	
	@FindBy(xpath="/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/img[1]") WebElement clkempdd;

	@FindBy(xpath="//div[contains(text(),'001 | Vaibhav Chavan')]") WebElement slctemp;
	
	@FindBy(xpath="//span[normalize-space()='Save']") WebElement save;
	
	@FindBy(xpath="//i[@class='dx-icon dx-icon-new-icon']") WebElement newLine;
	
	@FindBy(xpath="/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[5]/td[2]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/img[1]") WebElement clksalcompdd;
	
	@FindBy(xpath="/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[5]/td[2]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/img[1]") WebElement slctsalcomp;
	
	@FindBy(xpath="/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[5]/td[5]/div[1]") WebElement amtfield;
	
	@FindBy(xpath="//span[normalize-space()='View']") WebElement viewbtn;
	
	@FindBy(xpath="//span[normalize-space()='Approve']") WebElement approvebtn;
	
	@FindBy(xpath="//a[normalize-space()='Variable Salary']") WebElement variablesal;
	
	public void clkVariableSal()
	{
		variableSalary.click();
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
		slctemp.click();
	}
	
	public void clkSave()
	{
		save.click();
	}
	
	public void clkNewline()
	{
		newLine.click();
	}
	
	public void clkSalaryCompDD()
	{
		clksalcompdd.click();
	}
	
	public void slctSalComp()
	{
		slctsalcomp.click();
	}
	
	public void clkAmt()
	{
		amtfield.click();
		amtfield.clear();
	}
	
	public void provideAmt()
	{
		amtfield.sendKeys("100");
	}
	
	public void clkViewBtn()
	{
		viewbtn.click();
	}
	
	public void clkApproveBtn()
	{
		approvebtn.click();
	}
	
	public void clkVariableSalLabel()
	{
		variablesal.click();
	}

}
