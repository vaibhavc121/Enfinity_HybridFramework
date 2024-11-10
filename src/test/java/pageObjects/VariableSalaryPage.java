package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VariableSalaryPage extends BasePage 
{

	public VariableSalaryPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[1]")
	WebElement variableSalary;

	@FindBy(xpath = "//span[normalize-space()='New']")
	WebElement newbtn;

	public void clkVariableSal()
	{
		variableSalary.click();
	}
	
	public void clkNewBtn()
	{
		newbtn.click();
	}

}
