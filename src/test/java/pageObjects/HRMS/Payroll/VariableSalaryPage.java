package pageObjects.HRMS.Payroll;

import org.openqa.selenium.By;
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

	@FindBy(xpath = "(//span[text()='Variable Salary'])[2]")
	WebElement variableSalary;

	@FindBy(xpath = "//input[@id='VariableSalary.EmployeeIdLookup_I']")
	WebElement empdd;

	@FindBy(xpath = "//input[@id='VariableSalary.EffectiveDate_I']")
	WebElement effectiveDate;

	@FindBy(id = "VariableSalary.Description_I")
	WebElement remarks;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-new-icon']")
	WebElement newLine;

	@FindBy(xpath = "//input[@id='VariableSalaryLine_SalaryComponentId_I']")
	WebElement SalaryCompo;

//	@FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'])[4]")
//	WebElement amtfield;

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
		clickOnNew();
	}

	public void provideEmp(String value)
	{
		clearAndProvide1(empdd, value);

	}

	public void provideEffectiveDate(String value)
	{
		clearAndProvide1(effectiveDate, value);
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
		clickOnNewLine();
	}

	public void provideSalaryComp(String value)
	{
		waitTS(2);
		provideAndEnter(SalaryCompo, value);
	}

	public void provideAmt(String value) throws InterruptedException
	{

		clearAndProvide2(amtfield, value);
		clickOnSave();
	}

	public void clkViewBtn()
	{
		viewbtn.click();
		waitTS(2);
	}

	public void clkApproveBack()
	{
		clickApproveAndBack();
	}

}
