package pageObjects.HRMS.Payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

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

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/img[1]")
	WebElement clkempdd;

	@FindBy(xpath = "//div[contains(text(),'001 | Vaibhav Chavan')]")
	WebElement slctemp;

	@FindBy(id = "VariableSalary.Description_I")
	WebElement remarks;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-new-icon']")
	WebElement newLine;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[5]/td[2]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/img[1]")
	WebElement clksalcompdd;

	@FindBy(xpath = "//div[normalize-space()='SC001 | Basic Salary']")
	WebElement basic;

	@FindBy(xpath = "//td[@class=' grid-cell dx-wrap dxgv dx-ellipsis dx-ar']//div[@class='dxgBCTC dx-ellipsis'][normalize-space()='0']")
	WebElement amtfield;

	@FindBy(xpath = "//span[normalize-space()='View']")
	WebElement viewbtn;

	@FindBy(xpath = "//span[normalize-space()='Approve']")
	WebElement approvebtn;

	@FindBy(xpath = "//a[normalize-space()='Variable Salary']")
	WebElement variablesal;

	public void clkVariableSal()
	{
		variableSalary.click();
	}

	public void clkNewBtn()
	{
		newbtn.click();
	}

	public void clkEmpDD() throws InterruptedException
	{
		clkempdd.click();
		Thread.sleep(2000);
	}

	public void slctEmp() throws InterruptedException
	{
		slctemp.click();
		Thread.sleep(2000);
	}

	public void provideRemarks(String value)
	{
		remarks.sendKeys(value);
	}

	public void clkSave() throws InterruptedException
	{
		clickOnSave();
		Thread.sleep(2000);
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
		basic.click();
	}

	public void clkAmt()
	{
		amtfield.click();
		// amtfield.clear();
	}

	public void provideAmt(String value)
	{
		amtfield.sendKeys(value);
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
