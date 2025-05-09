package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "div[id='TenantCompanyShortName_DXI0_T'] span[class='dx-vam dxm-contentText']")
	WebElement doNotUse;

	public boolean isCompanyNameDisplay()
	{
		String cname = doNotUse.getText();
		if (cname.equalsIgnoreCase("Do Not Use"))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

}
