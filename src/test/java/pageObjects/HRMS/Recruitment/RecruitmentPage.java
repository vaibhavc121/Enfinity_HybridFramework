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
    private static WebElement recruitment;

    @FindBy(xpath = "//label[normalize-space()='Job']")
    WebElement job;

    @FindBy(xpath = "//span[@class='dx-vam'][normalize-space()='Candidate']")
    private WebElement candidate;

    public void clickOnSidebar()
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

    public static void clickRecruitment()
    {
        waitTS(3);
        BasePage.clickMenuIcon();
        try
        {
            clickOnElement1(recruitment);
        } catch (Exception e)
        {
            clickOnElement1(recruitment);
            //clickElementByJavaScript(driver, recruitment);
        }
    }

    public void clickJob()
    {
        clickOnElement1(job);
    }

    public void clickCandidate()
    {
        waitForElement(candidate).click();
    }
}