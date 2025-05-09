package pageObjects.HRMS.Payroll;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class LeaveEncashmentPage extends BasePage
{

	public LeaveEncashmentPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[normalize-space()='Leave Encashment']")
	WebElement leaveEncashment;

	@FindBy(xpath = "//span[normalize-space()='New']")
	WebElement newbtn;

	@FindBy(xpath = "//img[@id='LeaveAdjustment.EmployeeIdLookup_B-1Img']")
	WebElement empdd;

	@FindBy(xpath = "//img[@id='LeaveAdjustment.LeaveTypeIdLookup_B-1Img']")
	WebElement leaveTypeDD;

	@FindBy(xpath = "//div[contains(text(),'Condolence Leave')]")
	WebElement condolenceLeave;

	@FindBy(xpath = "//input[@id='LeaveAdjustment.PaidDays_I']")
	WebElement paidDaysTB;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[6]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement filterCell;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/span[1]/a[1]")
	WebElement result;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[7]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement filterCellPaidDays;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]")
	WebElement resultPaidDays;

	@FindBy(xpath = "//td[normalize-space()='1']")
	WebElement countPaidDays;

	public void clkLeaveEncashment()
	{
		leaveEncashment.click();
	}

	public void clkNewBtn()
	{
		newbtn.click();
	}

	public void clkEmpDD() throws InterruptedException
	{
		empdd.click();
		Thread.sleep(3000);
	}

	public void slctEmp() throws InterruptedException
	{
		List<WebElement> employees = driver.findElements(By.xpath("//div[@class='grid-row-template']"));

		for (WebElement emp : employees)
		{
			String expemp = "rohit";
			String actemp = emp.getText();

			if (actemp.contains(expemp))
			{
				emp.click();
			}
		}

		Thread.sleep(2000);
	}

	public void clkLeaveTypeDD()
	{
		leaveTypeDD.click();
	}

	public void slctLeaveType()
	{
		condolenceLeave.click();
	}

	public void providePaidDays()
	{
		paidDaysTB.clear();
		paidDaysTB.sendKeys("1");
	}

	public void clkViewBtn()
	{
		CommonActions.clkView();
	}

	public void clkApproveBtn() throws InterruptedException
	{
		CommonActions.clkApprove();
		;
		driver.navigate().back();
		Thread.sleep(2000);
	}

	public boolean isTxnCreated()
	{
		String expemp = "rohit";
		String paidDays = "1";
		String actemp = result.getText();
		String actPaidDays = resultPaidDays.getText();

		filterCell.sendKeys(expemp);
		filterCellPaidDays.sendKeys(paidDays);

		if (actemp.contains(expemp) && paidDays.equals(actPaidDays))
		{
			return true;
		} else
		{
			return false;
		}

	}

}
