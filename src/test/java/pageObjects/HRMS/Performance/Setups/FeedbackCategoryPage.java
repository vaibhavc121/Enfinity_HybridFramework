package pageObjects.HRMS.Performance.Setups;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FeedbackCategoryPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[normalize-space()='360 Feedback Category']")
    private WebElement FeedbackCategory;

    @FindBy(id = "EvaluationCategory.Name_I")
    private WebElement name;
    //endregion

    //region Action Methods
    public void clickFeedbackCategory()
    {
        clickOnElement1(FeedbackCategory);
    }
    public void provideName(String fcname)
    {
        clearAndProvide1(name, fcname);
    }

    //endregion
}