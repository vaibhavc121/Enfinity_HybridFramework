package pageObjects.HRMS.HRCore;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class AssetIssuePage extends BasePage
{

	public AssetIssuePage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//region Locators
	@FindBy(xpath = "//img[@id='MainMenu_DXI19_PImg']")
	WebElement contextMenu;

	@FindBy(xpath = "//span[normalize-space()='Return']")
	WebElement returnBtn;

	@FindBy(xpath = "//input[@id='HrAssetIssue.ActualReturnDate_I']")
	WebElement actualReturnDate;

	@FindBy(xpath = "//iframe[contains(@id,'PopupWindow')]")
	WebElement iframe;

	@FindBy(xpath = "//input[@id='HrAssetIssue.ActualReturnDate_I']")
	WebElement actualReturnDt;

	@FindBy(xpath = "//span[normalize-space()='Cancel Return']")
	WebElement cancelReturn;
	//endregion

	//region Action Methods
	public void filterAndOpenTxn(String value)
	{
		filterAndOpenTransaction(9, 9, value, "view");
	}

	public void clickContextMenu()
	{
		clickOnElement1(contextMenu);
	}

	public void clickReturn()
	{
		clickOnElement1(returnBtn);
		waitTS(2);
	}

	public void provideReturnDate(String value)
	{
		switchToFrameByElement(iframe);
		clearAndProvide1(actualReturnDt, value);
		clickOnSave();
		switchToDefaultContent();
	}

	public boolean returnDate()
	{
		clickOnElement1(contextMenu);
		return waitForElement(cancelReturn).isDisplayed();
	}
	//endregion



}