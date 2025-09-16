package pageObjects.HRMS.Performance;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewPage extends BasePage
{
    //region Locators

    //region Key Result Areas
    @FindBy(xpath = "(//input[@role='spinbutton'])[1]")
    private WebElement spinbutton1;

    @FindBy(xpath = "(//textarea[@class='dx-texteditor-input'])[1]")
    private WebElement reviewComment;

    @FindBy(xpath = "//textarea[contains(@id,'Comment')]")
    private WebElement overallComment;

    @FindBy(xpath = "//textarea[contains(@id,'TrainingRequirements')]")
    private WebElement TrainingRequirements;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    private WebElement save;

    @FindBy(xpath = "//span[normalize-space()='Submit for Opinion']")
    private WebElement submitForOpinion;
    //endregion

    //region Goals
    //endregion

    //region Competencies
    //endregion

    //region Review Questions
    //endregion

    //region Performance
    //endregion

    //region Skills & Learning
    //endregion

    //endregion

    //region Action Methods

    //region Key Result Areas
    //endregion

    //region Goals
    //endregion

    //region Competencies
    //endregion

    //region Review Questions
    //endregion

    //region Performance
    //endregion

    //region Skills & Learning
    //endregion

    //endregion
}