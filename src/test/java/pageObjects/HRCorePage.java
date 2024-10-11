package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HRCorePage extends BasePage
{

	public HRCorePage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[normalize-space()='HR Core']")
	WebElement hRCore;

	@FindBy(xpath = "//span[normalize-space()='Setups']")
	WebElement setups;

	public void clkHRCore()
	{
		hRCore.click();
	}

	public void clkSetupForm()
	{
		setups.click();
	}

}
