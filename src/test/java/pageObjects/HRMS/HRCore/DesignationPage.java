package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class DesignationPage extends BasePage
{

	public DesignationPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[normalize-space()='New']")
	WebElement newbtn;

	@FindBy(name = "Code")
	WebElement code;

	@FindBy(name = "Name")
	WebElement desgname;

	@FindBy(id = "dx_dx-be8794c6-5fd6-a4cd-4fc5-18a13967b6ab_GradeId")
	WebElement clkgrade;

	@FindBy(xpath = "//div[contains(text(),'Contributor')]")
	WebElement slctgrade;

	@FindBy(xpath = "//div[@aria-label='Editor content']")
	WebElement jobdesc;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement filterCell;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]/a[1]")
	WebElement result;

	public void clkNewBtn()
	{
		newbtn.click();
	}

	String num = randomNumber();

	public void setDesigCode()
	{
		code.sendKeys(num);
	}

	String temp = randomString();

	public void setDesignation()
	{
		desgname.sendKeys(temp);
	}

	public void clkGrade()
	{
		clkgrade.click();
	}

	public void slctGrade()
	{
		slctgrade.click();
	}

	public void setJobDesc()
	{
		jobdesc.sendKeys("job desc");
	}

	public void clkSave() throws InterruptedException
	{
		clickOnSave();
	}

	public boolean isDesgCreated() throws InterruptedException
	{
		filterCell.sendKeys(temp);
		Thread.sleep(2000);
		String hrasset = result.getText();

		if (temp.equals(hrasset))
		{
			return true;
		} else
		{
			return false;
		}

	}

}
