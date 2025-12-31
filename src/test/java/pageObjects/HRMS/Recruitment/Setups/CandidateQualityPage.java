package pageObjects.HRMS.Recruitment.Setups;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CandidateQualityPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[normalize-space()='Candidate Quality']")
    private WebElement candidateQuality;

    @FindBy(id = "CandidateQuality.Name_I")
    private WebElement name;
    //endregion

    //region Action Methods
    public void clickCandidateQuality()
    {
        clickOnElement1(candidateQuality);
    }
    public void provideName(String qualityName)
    {
        clearAndProvide1(name, qualityName);
    }
    //endregion
}