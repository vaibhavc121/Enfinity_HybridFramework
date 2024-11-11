package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class QualificationPage extends BasePage
{
	public QualificationPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	BaseClass bc = new BaseClass();

	@FindBy(xpath = "//span[normalize-space()='New']")
	WebElement newbtn;

	@FindBy(xpath = "//input[@id='Qualification.Name_I']")
	WebElement name;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/img[1]")
	WebElement QualificationType;

	@FindBy(xpath = "//div[normalize-space()='Diploma']")
	WebElement diploma;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;

	@FindBy(xpath = "//input[@aria-label='Filter cell']")
	WebElement filter;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/a[1]")
	WebElement result;

	public void clkNewBtn()
	{
		newbtn.click();
	}

	String temp = bc.randomString();

	public void setName()
	{
		name.sendKeys(temp);
	}

	public void clickQualificationDD()
	{
		QualificationType.click();
	}

	public void slctType()
	{
		QualificationType.click();
	}

	public void clkSaveBtn() throws InterruptedException
	{
		save.click();
		driver.navigate().back();
		Thread.sleep(2000);
	}

	public boolean isQualificationCreated() throws InterruptedException
	{
		filter.sendKeys(temp);
		Thread.sleep(2000);
		String qualification = result.getText();

		if (temp.equals(qualification))
		{
			return true;
		}
		else
		{
			return false;
		}

	}
}
