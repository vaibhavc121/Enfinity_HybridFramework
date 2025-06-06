package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class QualificationPage extends BasePage
{
	public QualificationPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='Qualification.Name_I']")
	WebElement qualificationName;

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideQualificationName(String value)
	{
		qualificationName.sendKeys(value);
	}

	public void provideQualificationName()
	{
		qualificationName.sendKeys(randomString());
	}

	public void clickSaveBack()
	{
		clickSaveAndBack();
	}

	public boolean isTxnCreated()
	{
		return isTransactionCreated();
	}

}
