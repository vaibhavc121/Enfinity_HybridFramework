package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GradePage extends BasePage
{

	public GradePage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

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

	public void clkNewBtn()
	{
		newbtn.click();
	}

	public void setGrade()
	{
		gradename.sendKeys("grade0");
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

	public void btnSave()
	{
		save.click();
	}

}
