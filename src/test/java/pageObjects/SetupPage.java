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

}
