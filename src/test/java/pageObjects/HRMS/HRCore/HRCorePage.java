package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseTest.BaseClass;

public class HRCorePage extends BasePage
{

	public HRCorePage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	BaseClass bc = new BaseClass();

	@FindBy(xpath = "//span[normalize-space()='HR Core']")
	WebElement hRCore;

	@FindBy(xpath = "//span[normalize-space()='Setups']")
	WebElement setups;

	public void clkHRCore()
	{
		bc.highlightElement(driver, hRCore, true);
		hRCore.click();
		bc.highlightElement(driver, hRCore, false); // Remove highlight
	}

	public void clkSetupForm()
	{
		bc.highlightElement(driver, setups, true);
		setups.click();
		bc.highlightElement(driver, setups, false); // Remove highlight
	}

}
