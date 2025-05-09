package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class DelegationPage extends BasePage
{

	public DelegationPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[normalize-space()='New']")
	WebElement newbtn;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]")
	WebElement delegateedd;

	@FindBy(xpath = "//div[contains(text(),'001 | flipkart')]")
	WebElement delegatee;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;

	public void clkNewBtn()
	{
		newbtn.click();
	}

	public void clkDelegateeDD()
	{
		delegateedd.click();
	}

	public void slctDelegatee()
	{
		delegatee.click();
	}

	public void clkSaveBtn()
	{
		CommonActions.clkSave();
	}

}
