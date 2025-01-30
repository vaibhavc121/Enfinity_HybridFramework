package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseTest.BaseClass;
import utilities.CommonActions;

public class GradePage extends BasePage
{

	public GradePage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	BaseClass bc = new BaseClass();

	@FindBy(xpath = "//span[normalize-space()='New']")
	WebElement newbtn;

	@FindBy(xpath = "//input[@id='Grade.Name_I']")
	WebElement gradename;

	@FindBy(xpath = "//input[@id='Grade.MinimumSalary_I']")
	WebElement minsal;

	@FindBy(xpath = "//input[@id='Grade.MaximumSalary_I']")
	WebElement maxsal;

	@FindBy(css = "img[id='Grade.GratuityIdLookup_B-1Img']")
	WebElement indemnitydd;

	@FindBy(css = "td[id='Grade.GratuityIdLookup_DDD_gv_tcrow0'] div[class='lookup-text']")
	WebElement slctindemnity;

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

	String temp = bc.randomString();

	public void setGrade()
	{
		gradename.sendKeys(temp);
	}

	public void setMinSal()
	{
		minsal.clear();
		minsal.sendKeys("100");
	}

	public void setMaxSal()
	{
		maxsal.clear();
		maxsal.sendKeys("1000");
	}

	public void clkIndemnityDD()
	{
		indemnitydd.click();
	}

	public void slctIndemnity()
	{
		slctindemnity.click();
	}

	public void btnSave() throws InterruptedException
	{
		CommonActions.clkSave();
	}

	public boolean isGradeCreated() throws InterruptedException
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
