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

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-add']")
	WebElement addIcon;

	@FindBy(id = "DocumentType.Name_I")
	WebElement name;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	WebElement nameAr;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;

	@FindBy(xpath = "//a[normalize-space()='Document Type']")
	WebElement documentType;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement filter;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]/a[1]")
	WebElement result;

	public void clkAddIcon() throws InterruptedException
	{
		addIcon.click();
		Thread.sleep(5000);

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

	String temp = randomString();

	public void setName()
	{
		name.sendKeys(temp);
	}

	public void clkSaveBtn() throws InterruptedException
	{
		CommonActions.clkSave();
	}

	public void clkDocType()
	{
		documentType.click();
	}

	public boolean isDocTypeCreated() throws InterruptedException
	{
		filter.sendKeys(temp);
		Thread.sleep(2000);
		String doctype = result.getText();
		if (temp.equals(doctype))
		{
			return true;
		}
		{
			return false;
		}
	}

}
