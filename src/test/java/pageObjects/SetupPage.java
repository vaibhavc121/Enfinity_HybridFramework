package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetupPage extends BasePage
{

	public SetupPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[normalize-space()='Department']")
	WebElement department;

	@FindBy(xpath = "//span[normalize-space()='Designation']")
	WebElement designation;

	@FindBy(xpath = "//span[normalize-space()='Grade']")
	WebElement grade;

	@FindBy(xpath = "//span[normalize-space()='Calendar']")
	WebElement calendar;

	@FindBy(xpath = "//a[@class='dxnb-link']//span[@class='dx-vam'][normalize-space()='Employee']")
	WebElement employee;

	@FindBy(xpath = "//span[normalize-space()='Religion']")
	WebElement religion;

	@FindBy(xpath = "//span[normalize-space()='Work Location']")
	WebElement workLocation;

	@FindBy(xpath = "//span[normalize-space()='Bank']")
	WebElement bank;

	@FindBy(xpath = "//span[normalize-space()='Qualification']")
	WebElement qualification;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[5]/ul[1]/li[1]/ul[1]/li[5]/span[1]")
	WebElement documentIssue;

	@FindBy(xpath = "//span[normalize-space()='Budget']")
	WebElement budget;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[5]/ul[1]/li[1]/ul[1]/li[2]/span[1]")
	WebElement assetIssue;

	@FindBy(xpath = "//span[@class='dx-vam'][normalize-space()='Delegation']")
	WebElement delegation;

	@FindBy(xpath = "//span[normalize-space()='License']")
	WebElement license;

	public void clkDept()
	{
		department.click();
	}

	public void clkDesignation()
	{
		designation.click();
	}

	public void clkGrade()
	{
		grade.click();
	}

	public void clkCalendar()
	{
		calendar.click();
	}

	public void clkEmployee()
	{
		employee.click();
	}

	public void clkReligion()
	{
		religion.click();
	}

	public void clkWorkLocation()
	{
		workLocation.click();
	}

	public void clkBank()
	{
		bank.click();
	}

	public void clkQualification()
	{
		qualification.click();
	}

	public void clkDocIsuue()
	{
		documentIssue.click();
	}

	public void clkBudget()
	{
		budget.click();
	}

	public void clkAsset()
	{
		assetIssue.click();
	}

	public void clkDelegation()
	{
		delegation.click();
	}

	public void clkLicense()
	{
		license.click();
	}

}
