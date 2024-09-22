package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeptPage extends BasePage
{

	public DeptPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[normalize-space()='Department']")
	WebElement department;

	@FindBy(css = "#MainMenu_DXI0_Img")
	WebElement newbtn;

	@FindBy(xpath = "//input[@id='Department.Name_I']")
	WebElement deptname;

	@FindBy(xpath = "//img[@id='EmployeeSelfService_CBImg']")
	WebElement selfservice;

	@FindBy(css = "img[id='Department.ManagerEmployeeIdLookup_B-1Img']")
	WebElement deptmgrdd;

	@FindBy(xpath = "//div[@class='lookup-text']")
	WebElement deptmgrname;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;

	public void clkDept()
	{
		department.click();
	}

	public void clkNewbtn()
	{
		newbtn.click();
	}

	public void setDeptName()
	{
		deptname.sendKeys("hr");
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

	public void clkSave()
	{
		save.click();
	}

}
