package pageObjects.HRMS.HRCore;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class DocumentTypePage extends BasePage
{

	public DocumentTypePage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='DocumentType.Name_I']")
	private WebElement documentType;

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideDocumentTypeName(String value)
	{
		documentType.sendKeys(value);
	}

	public void provideDocumentTypeName()
	{
		documentType.sendKeys(randomString());
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