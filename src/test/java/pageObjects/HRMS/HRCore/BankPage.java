package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseTest.BaseClass;
import utilities.CommonActions;

public class BankPage extends BasePage
{

	public BankPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	BaseClass bc = new BaseClass();

	@FindBy(xpath = "//span[normalize-space()='New']")
	WebElement newbtn;

	@FindBy(xpath = "//input[@id='Bank.Name_I']")
	WebElement name;

	@FindBy(xpath = "//span[@id='Bank.CheckIbanValidation_S_D']")
	WebElement toggle;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;

	@FindBy(xpath = "//input[@aria-label='Filter cell']")
	WebElement filter;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/a[1]")
	WebElement result;

	public void clkNewBtn()
	{
		newbtn.click();
	}

	String temp = bc.randomString();

	public void setName()
	{
		name.sendKeys(temp);
	}

	public void checkToggle()
	{
		toggle.click();
	}

	public void clkSave() throws InterruptedException
	{
		CommonActions.clkSave();
	}

	public boolean isBankCreated() throws InterruptedException
	{
		filter.sendKeys(temp);
		Thread.sleep(2000);
		String bank = result.getText();
		if (temp.equals(bank))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
