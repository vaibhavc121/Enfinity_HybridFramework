package pageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class AssetIssuePage extends BasePage
{

	public AssetIssuePage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	BaseClass bc = new BaseClass();

	@FindBy(xpath = "//span[normalize-space()='New']")
	WebElement newbtn;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-add']")
	WebElement addIcon;

	@FindBy(xpath = "//input[@id='HrAsset.Name_I']")
	WebElement name;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/img[1]")
	WebElement assetcatdd;

	@FindBy(xpath = "//div[normalize-space()='Accessories']")
	WebElement accessories;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;

	@FindBy(xpath = "//a[normalize-space()='Asset']")
	WebElement asset;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement filterCell;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/a[1]")
	WebElement result;

	public void clkNewBtn()
	{
		newbtn.click();
	}

	public void clkAddIcon() throws InterruptedException
	{
		addIcon.click();
		Thread.sleep(10000);
		String originalWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows)
		{
			if (!windowHandle.equals(originalWindow))
			{
				driver.switchTo().window(windowHandle);
				break;
			}
		}

	}

	String temp = bc.randomString();

	public void setName()
	{
		name.sendKeys(temp);
	}

	public void clkAssetCatDD()
	{
		assetcatdd.click();
	}

	public void slctDDValue()
	{
		accessories.click();
	}

	public void clkSaveBtn() throws InterruptedException
	{
		save.click();
//		driver.navigate().back();
//		Thread.sleep(2000);
	}

	public void clkAsset()
	{
		asset.click();
	}

	public boolean isHrAssetCreated() throws InterruptedException
	{
		filterCell.sendKeys(temp);
		Thread.sleep(2000);
		String hrasset = result.getText();

		if (temp.equals(hrasset))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

}
