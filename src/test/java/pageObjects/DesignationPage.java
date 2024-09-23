package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	public void clkNewBtn()
	{
		newbtn.click();
	}

	public void setDesigCode()
	{
		code.sendKeys("DE0035");
	}

	public void setDesignation()
	{
		desgname.sendKeys("BA");
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

	public void clkSave()
	{
		save.click();
	}

}
