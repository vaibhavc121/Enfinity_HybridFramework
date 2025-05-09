package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class LicensesPage extends BasePage
{

	public LicensesPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[normalize-space()='New']")
	WebElement newbtn;

	@FindBy(xpath = "//input[@id='GovtRecruitmentContractLicense.Name_I']")
	WebElement name;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]")
	WebElement clkfilenumdd;

	@FindBy(xpath = "//div[@class='lookup-text']")
	WebElement slctfilenum;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement filterCell;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
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

	public void clkFileNumDD()
	{
		clkfilenumdd.click();
	}

	public void slctFileNum() throws InterruptedException
	{
		slctfilenum.click();
		Thread.sleep(3000);
	}

	public void clkSaveBtn() throws InterruptedException
	{
		CommonActions.clkSave();
	}

	public boolean isLicenseCreated()
	{
		filterCell.sendKeys(temp);
		String license = result.getText();
		if (license.contains(temp))
		{
			return true;
		} else
		{
			return false;
		}

	}

}
