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

	//region Locators
	@FindBy(xpath = "//span[normalize-space()='New']")
	WebElement newbtn;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]")
	WebElement delegateedd;

	@FindBy(xpath = "//div[contains(text(),'001 | flipkart')]")
	WebElement delegatee;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;
	//endregion

	//region Action Methods
	public void clkNewBtn()
	{
		clickOnNew();
	}

	public void clkDelegateeDD()
	{
		clickOnElement1(delegateedd);
	}

	public void slctDelegatee()
	{
		clickOnElement1(delegatee);
	}

	public void clkSaveBtn()
	{
		CommonActions.clkSave();
	}
	//endregion





}