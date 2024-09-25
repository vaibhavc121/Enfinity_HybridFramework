package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarPage extends BasePage
{

	public CalendarPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

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

	public void clkNewBtn()
	{
		newbtn.click();
	}

	public void setCalName()
	{
		calname.sendKeys("cal1");
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

	public void setRestday()
	{
		restdaycheckbox.click();
	}

	public void clkSave()
	{
		savebtn.click();
	}

}
