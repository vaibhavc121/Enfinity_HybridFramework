package pageObjects.HRMS.SelfService;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HRAssetRequestPage extends BasePage
{

	public HRAssetRequestPage(WebDriver driver)
	{
		super(driver);

	}

	// Locators
	@FindBy(xpath = "//span[text()='HR Asset Request']")
	WebElement hrAssetRequest;

	@FindBy(xpath = "//input[@id='HrAssetRequest.TxnDate_I']")
	WebElement txnDate;

	@FindBy(xpath = "//input[@id='HrAssetRequest.EffectiveDate_I']")
	WebElement effectiveDate;

	@FindBy(id = "HrAssetRequestLine_HrAssetId_B-1Img")
	WebElement hrAsset;

	@FindBy(id = "HrAssetRequestLine_DXEditor3_I")
	WebElement expReturnDate;

	// Action Methods
	public void clickHRAssetRequest()
	{
		hrAssetRequest.click();
	}

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideTxnDate(String value)
	{
		clearAndProvide1(txnDate, value);
	}

	public void provideEffectiveDate(String value)
	{
		clearAndProvide1(effectiveDate, value);
	}

	public void clickSave()
	{
		clickOnSave();
	}

	public void clickNewLine()
	{
		clickOnNewLine();
	}

	public void clickHRAssetDD()
	{
		hrAsset.click();
	}

	public void selectHRAsset(String value) throws InterruptedException
	{
		while (true)
		{
			List<WebElement> valuesList = driver.findElements(By.xpath("//div[@class='lookup-text']"));
			for (WebElement valueElement : valuesList)
			{
				String actualValue = valueElement.getText();
				if (actualValue.contains(value))
				{
					valueElement.click();
					Thread.sleep(2000);
					return;
				}
			}
			driver.findElement(By.xpath("//img[@alt='Next']")).click();
			Thread.sleep(3000);
		}
	}

	public void provideExpReturnDate(String value)
	{
		expReturnDate.click();
		expReturnDate.sendKeys(value);
	}

	public void clickView()
	{
		clickOnView();
		waitTS(2);
	}

	public void clickOnApproveBack()
	{
		clickApproveAndBack();
	}

	public static boolean isTransactionCreated(String expDate, String expEmp, String expStatus)
			throws InterruptedException
	{
		filterDateByIndex(2, expDate);
		Thread.sleep(2000);
		filterByIndex(5, expEmp);
		Thread.sleep(2000);
		filterByIndex(7, expStatus);
		Thread.sleep(2000);

		String actualDate = resultValue(2);
		String actualEmp = resultValue(5);
		String actualStatus = resultValue(7);

		return actualDate.contains(expDate) && actualEmp.contains(expEmp) && actualStatus.contains(expStatus);
	}

	public void test()
	{
		String value = driver.findElement(By.xpath("(//tbody//tr)[12]//td[2]")).getText();
		System.out.println(value);
	}

}
