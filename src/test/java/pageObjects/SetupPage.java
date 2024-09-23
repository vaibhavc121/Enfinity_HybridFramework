package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetupPage extends BasePage
{

	public SetupPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[normalize-space()='Department']")
	WebElement department;

	@FindBy(xpath = "//span[normalize-space()='Designation']")
	WebElement designation;

	public void clkDept()
	{
		department.click();
	}

	public void clkDesignation()
	{
		designation.click();
	}

}
