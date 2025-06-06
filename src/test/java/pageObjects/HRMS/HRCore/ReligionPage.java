package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class ReligionPage extends BasePage
{

	public ReligionPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='Religion.Name_I']")
	WebElement religionName;

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideReligionName(String value)
	{
		religionName.sendKeys(value);
	}

	public void clickSaveBack()
	{
		clickSaveAndBack();
	}

}
