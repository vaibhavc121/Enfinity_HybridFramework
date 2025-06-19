package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.BaseTest;

public class SetupPage extends BasePage
{

	public SetupPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@class='dxnb-link']//span[@class='dx-vam'][normalize-space()='Employee']")
	WebElement employee;

	@FindBy(xpath = "//span[text()='Department']")
	WebElement department;

	@FindBy(xpath = "//span[normalize-space()='Designation']")
	WebElement designation;

	@FindBy(xpath = "//span[normalize-space()='Grade']")
	WebElement grade;

	@FindBy(xpath = "//span[normalize-space()='Calendar']")
	WebElement calendar;

	@FindBy(xpath = "//span[normalize-space()='Religion']")
	WebElement religion;

	@FindBy(xpath = "//span[normalize-space()='Work Location']")
	WebElement workLocation;

	@FindBy(xpath = "//span[normalize-space()='Bank']")
	WebElement bank;

	@FindBy(xpath = "//span[normalize-space()='Qualification']")
	WebElement qualification;

	@FindBy(xpath = "//span[normalize-space()='Document Type']")
	WebElement documentType;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[5]/ul[1]/li[1]/ul[1]/li[4]/span[1]")
	WebElement assetIssue;

	@FindBy(xpath = "//span[@class='dx-vam'][normalize-space()='Delegation']")
	WebElement delegation;

	@FindBy(xpath = "//span[normalize-space()='License']")
	WebElement license;

	public void clickEmployee()
	{
		employee.click();
	}

	public void clickDepartment()
	{
		department.click();
	}

	public void clickDesignation()
	{
		designation.click();
	}

	public void clickGrade()
	{
		grade.click();
	}

	public void clickCalendar()
	{
		calendar.click();
	}

	public void clickReligion()
	{
		religion.click();
	}

	public void clickWorkLocation()
	{
		workLocation.click();
	}

	public void clickBank()
	{
		bank.click();
	}

	public void clickQualification()
	{
		qualification.click();
	}

	public void clickDocumentType()
	{
		documentType.click();
	}

	public void clickAssetIssue()
	{
		assetIssue.click();
	}

	public void clickDelegation()
	{
		delegation.click();
	}

	public void clickLicense()
	{
		license.click();
	}

}