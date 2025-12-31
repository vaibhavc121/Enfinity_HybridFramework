package pageObjects.HRMS.Recruitment.Setups;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InterviewTypePage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[normalize-space()='Interview Type']")
    private WebElement interviewType;

    @FindBy(id = "InterviewType.Name_I")
    private WebElement name;
    //endregion

    //region Action Methods
    public void clickInterviewType()
    {
        clickOnElement1(interviewType);
    }
    public void provideName(String typeName)
    {
        clearAndProvide1(name, typeName);
    }

    //endregion
}