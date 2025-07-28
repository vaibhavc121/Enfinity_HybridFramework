package pageObjects.HRMS.Recruitment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class RecruitmentPage extends BasePage
{

	public RecruitmentPage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(xpath = "//span[normalize-space()='Recruitment']")
	private WebElement recruitment;

	@FindBy(xpath = "//a[@title='Job']//span[@class='dx-vam'][normalize-space()='Job']")
	private WebElement job;

	@FindBy(xpath="//span[@class='dx-vam'][normalize-space()='Candidate']") private WebElement candidate;

	public void clickRecruitment()
	{
		recruitment.click();
	}

	public void clickJob()
	{
		job.click();
	}

	public void clickCandidate()
	{
		waitForElement(candidate).click();
	}

}