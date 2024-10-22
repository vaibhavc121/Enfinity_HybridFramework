package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class CalendarPage extends BasePage
{

	public CalendarPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	BaseClass bc = new BaseClass();

	@FindBy(xpath = "//span[normalize-space()='New']")
	WebElement newbtn;

	@FindBy(name = "Name")
	WebElement calname;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement caldate;

	@FindBy(xpath = "//div[@id='SundayAsWeeklyoff']//span[@class='dx-checkbox-icon']")
	WebElement weekoffcheckbox;

	@FindBy(xpath = "//div[@id='SaturdayAsRestDay']//span[@class='dx-checkbox-icon']")
	WebElement restdaycheckbox;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement savebtn;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement filterCell;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/a[1]")
	WebElement result;

	public void clkNewBtn()
	{
		newbtn.click();
	}

	String temp = bc.randomString();

	public void setCalName()
	{
		calname.sendKeys(temp);
	}

	public void setCalDate()
	{
		caldate.clear();
		caldate.sendKeys("01-Jan-2024");
	}

	public void setWeekoff()
	{
		weekoffcheckbox.click();
	}

	public void setRestday() throws InterruptedException
	{
		restdaycheckbox.click();
		driver.navigate().back();
		Thread.sleep(2000);
	}

	public void clkSave()
	{
		savebtn.click();
	}

	public boolean isCalendarCreated() throws InterruptedException
	{
		filterCell.sendKeys(temp);
		Thread.sleep(2000);
		String cal = result.getText();

		if (temp.equals(cal))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

}
