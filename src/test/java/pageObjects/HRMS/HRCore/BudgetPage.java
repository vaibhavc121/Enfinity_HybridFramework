package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.BaseTest;
import utilities.CommonActions;

public class BudgetPage extends BasePage
{

	public BudgetPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	BaseTest bc = new BaseTest();

	@FindBy(xpath = "//span[normalize-space()='New']")
	WebElement newbtn;

	@FindBy(xpath = "//input[@id='HrBudget.Name_I']")
	WebElement name;

	@FindBy(xpath = "//input[@id='HrBudget.StartDate_I']")
	WebElement startDate;

	@FindBy(xpath = "//input[@id='HrBudget.EndDate_I']")
	WebElement endDate;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;

	@FindBy(xpath = "//input[@aria-label='Filter cell']")
	WebElement filterCell;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/a[1]")
	WebElement result;

	public void clkNewBtn()
	{
		newbtn.click();
	}

	String temp = randomString();

	public void setName()
	{
		name.sendKeys(temp);
	}

	public void setStartDt()
	{
		startDate.sendKeys("01-01-2024");
	}

	public void setEndDt()
	{
		endDate.sendKeys("31-12-2024");
	}

	public void clkSaveBtn() throws InterruptedException
	{
		CommonActions.clkSave();
	}

	public boolean isBudgetCreated() throws InterruptedException
	{
		filterCell.sendKeys(temp);
		Thread.sleep(2000);
		String budget = result.getText();

		if (temp.equals(budget))
		{
			return true;
		} else
		{
			return false;
		}
	}

}
