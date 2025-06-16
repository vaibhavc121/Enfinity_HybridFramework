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

	public void filterAndOpenTxn(String value)
	{
		filterAndOpenTransaction(9, 9, value, "view");
	}

	public void clickContextMenu()
	{
		contextMenu.click();
	}

	public void clickReturn()
	{
		returnBtn.click();
		waitTS(2);
	}

	public void provideReturnDate(String value)
	{
		switchToFrameByElement(iframe);
		actualReturnDt.sendKeys(value);
		clickOnSave();
		switchToDefaultContent();
	}

	public boolean returnDate()
	{
		contextMenu.click();
		return cancelReturn.isDisplayed();
	}

}