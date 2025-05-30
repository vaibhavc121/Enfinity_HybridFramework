package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.BaseTest;
import utilities.CommonActions;

public class DeptPage extends BasePage
{

	public DeptPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	BaseTest bc = new BaseTest();

	@FindBy(css = "#MainMenu_DXI0_Img")
	WebElement newbtn;

	@FindBy(xpath = "//input[@id='Department.Name_I']")
	WebElement deptname;

	@FindBy(xpath = "//img[@id='EmployeeSelfService_CBImg']")
	WebElement selfservice;

	@FindBy(xpath = "//input[@id='Department.ManagerEmployeeIdLookup_I']")
	WebElement deptmgrdd;

	@FindBy(xpath = "//div[@class='lookup-text']")
	WebElement deptmgrname;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;

//	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
//	WebElement filterCell;

	@FindBy(css = "input[aria-describedby='dx-col-4']")
	WebElement filterCell;

//	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]/a[1]")
//	WebElement result;

	@FindBy(css = "td[role='gridcell'][aria-describedby='dx-col-4'][shn-nav='2']")
	WebElement result;

	public void clkNewbtn()
	{
		newbtn.click();
	}

	String temp = randomString();

	public void setDeptName()
	{
		deptname.sendKeys(temp);
	}

	public void clkSelfServiceDD()
	{
		selfservice.click();
	}

	public void clkDeptMgrDD()
	{
		deptmgrdd.click();
	}

	public void setDeptMgrName()
	{
		deptmgrdd.sendKeys("vaibhav chavan");
	}

	public void slctDeptMgr()
	{
		deptmgrname.click();
	}

	public void clkSave() throws InterruptedException
	{
		clickOnSave();
	}

	public boolean isDeptCreated() throws InterruptedException
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
