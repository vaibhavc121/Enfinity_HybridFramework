package pageObjects.HRMS.Payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class IndemnityAdjustmentPage extends BasePage
{

	public IndemnityAdjustmentPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@title='Indemnity Adjustment']//span[@class='dx-vam'][normalize-space()='Indemnity Adjustment']")
	WebElement indemnityAdjustment;

	@FindBy(xpath = "//img[@id='GratuityAdjustment.EmployeeIdLookup_B-1Img']")
	WebElement empdd;

	@FindBy(xpath = "//div[contains(text(),'003 | rahul')]")
	WebElement emp;

	@FindBy(xpath = "//img[@id='GratuityAdjustment.GratuityIdLookup_B-1Img']")
	WebElement indemnitydd;

	@FindBy(xpath = "//div[contains(text(),'Indemnity')]")
	WebElement indemnity;

	@FindBy(xpath = "//input[@id='GratuityAdjustment.PaidDays_I']")
	WebElement paidDays;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[6]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement filterCell;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/span[1]/a[1]")
	WebElement result;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[9]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement filterIndAmt;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[9]")
	WebElement resultIndAmt;

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

	public void providePaidDays() throws InterruptedException
	{
		paidDays.clear();
		paidDays.sendKeys("1");
		Thread.sleep(2000);
	}

	public void clkView()
	{
		clickOnView();
	}

	public void clkApprove() throws InterruptedException
	{
		clickOnApprove();
		driver.navigate().back();
		Thread.sleep(3000);
	}

	public boolean isTxnCreated()
	{
		String expemp = "rahul";
		// String expIndAmt="19.231";

		filterCell.sendKeys(expemp);
		// filterIndAmt.sendKeys(expIndAmt);
		String actemp = result.getText();
		// String actIndamt= resultIndAmt.getText();

		if (actemp.contains(expemp))
		{
			return true;
		} else
		{
			return false;
		}
	}

}
