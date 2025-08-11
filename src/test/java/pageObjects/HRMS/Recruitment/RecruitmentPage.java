package pageObjects.HRMS.Recruitment;

import base.BaseTest;
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

    @FindBy(xpath = "//span[@class='dx-vam'][normalize-space()='Candidate']")
    private WebElement candidate;

    public void clickOnHambergurIcon()
    {
        boolean value = waitForElement(job).isDisplayed();
        if (!value)
        {
            clickOnHamburgerMenu();
            BaseTest.log("Hamburger icon clicked");
        } else
        {
            BaseTest.log("Job Name is already displayed, no need to click on Hamburger icon");
        }
    }

    public void clickRecruitment()
    {
        waitTS(3);
        try
        {
            clickOnElement1(recruitment);
        } catch (Exception e)
        {
            //clickOnElement1(recruitment);
            clickElementByJavaScript(driver, recruitment);
        }
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