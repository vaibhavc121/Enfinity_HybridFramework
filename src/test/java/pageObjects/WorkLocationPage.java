package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class WorkLocationPage extends BasePage
{
	BaseClass bc = new BaseClass();

	public WorkLocationPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[normalize-space()='New']")
	WebElement newbtn;

	@FindBy(xpath = "//input[@id='WorkLocation.Name_I']")
	WebElement name;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement filter;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]/a[1]")
	WebElement result;

	public void clkNewBtn()
	{
		newbtn.click();
	}

	String wc = bc.randomString();

	public void setName()
	{
		name.sendKeys(wc);
	}

	public void clkSaveBtn() throws InterruptedException
	{
		save.click();
		driver.navigate().back();
		Thread.sleep(3000);
	}

	public boolean isWorkLocCreated()
	{
		filter.sendKeys(wc);
		String workloc = result.getText();
		if (wc.equals(workloc))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}