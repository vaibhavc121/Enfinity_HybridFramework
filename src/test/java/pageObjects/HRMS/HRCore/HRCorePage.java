package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HRCorePage extends BasePage
{

	public HRCorePage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[normalize-space()='HR Core']")
	WebElement hRCore;

	@FindBy(xpath = "(//span[text()='Employee'])[2]")
	WebElement employee;

	@FindBy(xpath = "//span[normalize-space()='Setups']")
	WebElement setups;

	@FindBy(xpath = "//span[normalize-space()='Asset Issue']")
	WebElement assetIssue;

	public void clickHRCore()
	{
		highlightElement(driver, hRCore, true);
		hRCore.click();
		highlightElement(driver, hRCore, false); // Remove highlight
	}

	public void clickEmployee()
	{
		employee.click();
	}

	public void clickSetupForm()
	{
		highlightElement(driver, setups, true);
		setups.click();
		highlightElement(driver, setups, false); // Remove highlight
	}

	public void clickAssetIssue()
	{
		assetIssue.click();
	}

}