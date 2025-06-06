package pageObjects.HRMS.Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LearningPage extends BasePage
{

	public LearningPage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(xpath = "//span[normalize-space()='Learning']")
	WebElement learning;

	@FindBy(xpath = "//span[normalize-space()='My Course']//preceding::span[@class='dx-vam'][normalize-space()='Course']")
	WebElement course;

	public void clickLearning()
	{
		learning.click();
	}

	public void clickCourse()
	{
		course.click();
	}

}
