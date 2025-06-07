package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class GradePage extends BasePage
{

	public GradePage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='Grade.Name_I']")
	private WebElement gradeName;

	@FindBy(xpath = "//input[@id='Grade.MinimumSalary_I']")
	private WebElement minimumSalary;

	@FindBy(xpath = "//input[@id='Grade.MaximumSalary_I']")
	private WebElement maximumSalary;

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideGradeName(String value)
	{
		gradeName.sendKeys(value);
	}

	public void provideMinSal(String value)
	{
		clearAndProvide1(minimumSalary, value);
	}

	public void provideMaxSal(String value)
	{
		clearAndProvide1(maximumSalary, value);
	}

	public void clickSaveBack()
	{
		clickSaveAndBack();
	}

}
