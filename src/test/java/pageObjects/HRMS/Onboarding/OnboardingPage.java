package pageObjects.HRMS.Onboarding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class OnboardingPage extends BasePage
{

	public OnboardingPage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(xpath = "//img[@id='applicationMenu_DXI10_PImg']")
	WebElement menu;

	@FindBy(xpath = "//span[normalize-space()='Onboarding']")
	WebElement onboarding;

	@FindBy(xpath = "//a[@title='Candidate']//span[@class='dx-vam'][normalize-space()='Candidate']")
	WebElement candidate;

	public void clickMenu()
	{
		menu.click();
	}

	public void clickOnboarding()
	{
		onboarding.click();
	}

	public void clickCandidate()
	{
		candidate.click();
	}

}
