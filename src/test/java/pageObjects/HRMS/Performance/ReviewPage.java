package pageObjects.HRMS.Performance;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JavaScriptUtils;

public class ReviewPage extends BasePage
{
    //region Locators

    //region Key Result Areas
    @FindBy(xpath = "(//input[@role='spinbutton'])[1]")
    private WebElement spinbutton1;

    @FindBy(xpath = "(//textarea[@class='dx-texteditor-input'])[1]")
    private WebElement reviewComment1;

    @FindBy(xpath = "//textarea[contains(@id,'Comment')]")
    private WebElement overallComment1;

    @FindBy(xpath = "//textarea[contains(@id,'TrainingRequirements')]")
    private WebElement TrainingRequirements1;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    private WebElement save;

    @FindBy(xpath = "//span[normalize-space()='Submit for Opinion']")
    private WebElement submitForOpinion;
    //endregion

    //region Goals

    @FindBy(xpath = "//span[normalize-space()='Goals']")
    private WebElement goals;

    @FindBy(xpath = "(//input[@role='spinbutton'])[2]")
    private WebElement spinbutton2;

    @FindBy(xpath = "(//textarea[@class='dx-texteditor-input'])[2]")
    private WebElement reviewComment2;

    @FindBy(xpath = "//textarea[contains(@id,'Comment')]")
    private WebElement overallComment2;

    @FindBy(xpath = "//textarea[contains(@id,'TrainingRequirements')]")
    private WebElement TrainingRequirements2;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    private WebElement save2;

    @FindBy(xpath = "//span[normalize-space()='Submit for Opinion']")
    private WebElement submitForOpinion2;

    //endregion

    //region Competencies
    @FindBy(xpath = "//span[normalize-space()='Competencies']")
    private WebElement competenciesCompetencies;

    @FindBy(xpath = "(//input[@role='spinbutton'])[3]")
    private WebElement spinbutton3;

    @FindBy(xpath = "(//textarea[@class='dx-texteditor-input'])[3]")
    private WebElement reviewComment3;

    @FindBy(xpath = "//textarea[contains(@id,'Comment')]")
    private WebElement overallComment3;

    @FindBy(xpath = "//textarea[contains(@id,'TrainingRequirements')]")
    private WebElement TrainingRequirements3;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    private WebElement save3;

    @FindBy(xpath = "//span[normalize-space()='Submit for Opinion']")
    private WebElement submitForOpinion3;
    //endregion

    //region Review Questions
    @FindBy(xpath = "//span[normalize-space()='Review Questions']")
    private WebElement reviewQuestions;

    @FindBy(xpath = "//textarea[contains(@id,'Comment')]")
    private WebElement overallComment4;

    @FindBy(xpath = "//textarea[contains(@id,'TrainingRequirements')]")
    private WebElement learningRequirements;
    //endregion

    //region Performance
    @FindBy(xpath = "//span[normalize-space()='Performance']")
    private WebElement performance;

    @FindBy(xpath = "//input[contains(@id,'HikeAmount')]")
    private WebElement hikeAmount;

    @FindBy(xpath = "//input[contains(@id,'HikePercentage')]")
    private WebElement hikePercentage;

    @FindBy(xpath = "//input[contains(@id,'PromotedDepartment')]")
    private WebElement promotedDepartment;

    @FindBy(xpath = "//input[contains(@id,'PromotedDesignation')]")
    private WebElement promotedDesignation;

    //endregion

    //region Skills & Learning
    @FindBy(xpath = "//span[normalize-space()='Skills & Learning']")
    private WebElement skillsAndLearning;

    @FindBy(xpath = "(//td[@role='gridcell'])[5]")
    private WebElement newLeavel;

    //region Purposed Learning Course
    @FindBy(xpath = "//i[@class='dx-icon dx-icon-add']")
    private WebElement plusButton;
    @FindBy(xpath = "//span[normalize-space()='Select']")
    private WebElement select;
    @FindBy(xpath = "(//i[@class='dx-icon dx-icon-close'])[2]")
    private WebElement closePopup;
    @FindBy(xpath = "//p[@class='course-name']")
    private WebElement javaProgramming;
    @FindBy(xpath = "//i[@class='dx-icon dx-icon-trash']")
    private WebElement trash;
    //press enter

    //endregion
    //endregion

    //endregion

    //region Action Methods

    //region Key Result Areas
    public void provideRating(String value)
    {
        clearAndProvide1(spinbutton1, value);
    }
    public void enterReviewComment(String value)
    {
        clearAndProvide1(reviewComment1, value);
    }
    public void enterOverallComment(String value)
    {
        clearAndProvide1(overallComment1, value);
    }
    public void enterTrainingRequirements(String value)
    {
        clearAndProvide1(TrainingRequirements1, value);
    }
    public void clickSave()
    {
        waitForElement(save).click();
    }
    public void clickSubmitForOpinion()
    {
        waitForElement(submitForOpinion).click();
    }

    //endregion

    //region Goals
    public void clickGoals()
    {
        clickOnElement1(goals);
    }
    public void provideRating2(String value)
    {
        clearAndProvide1(spinbutton2, value);
    }
    public void enterReviewComment2(String value)
    {
        clearAndProvide1(reviewComment2, value);
    }
    public void enterOverallComment2(String value)
    {
        clearAndProvide1(overallComment2, value);
    }
    public void enterTrainingRequirements2(String value)
    {
        clearAndProvide1(TrainingRequirements2, value);
    }

    //endregion

    //region Competencies
    public void clickCompetencies()
    {
        clickOnElement1(competenciesCompetencies);
    }
    public void provideRating3(String value)
    {
        clearAndProvide1(spinbutton3, value);
    }
    public void enterReviewComment3(String value)
    {
        clearAndProvide1(reviewComment3, value);
    }
    public void enterOverallComment3(String value)
    {
        clearAndProvide1(overallComment3, value);
    }
    public void enterTrainingRequirements3(String value)
    {
        clearAndProvide1(TrainingRequirements3, value);
    }

    //endregion

    //region Review Questions
    public void clickReviewQuestions()
    {
        clickOnElement1(reviewQuestions);
    }
    public void enterOverallComment4(String value)
    {
        clearAndProvide1(overallComment4, value);
    }
    public void enterLearningRequirements(String value)
    {
        clearAndProvide1(learningRequirements, value);
    }
    //endregion

    //region Performance
    public void clickPerformance()
    {
        clickOnElement1(performance);
    }
    public void enterHikeAmount(String value)
    {
        clearAndProvide1(hikeAmount, value);
    }
    public void enterHikePercentage(String value)
    {
        clearAndProvide1(hikePercentage, value);
    }
    public void selectPromotedDepartment(String value)
    {
        provideAndEnter(promotedDepartment, value);
    }
    public void selectPromotedDesignation(String value)
    {
        provideAndEnter(promotedDesignation, value);
    }

    //endregion

    //region Skills & Learning
    public void clickSkillsAndLearning()
    {
        clickOnElement1(skillsAndLearning);
    }
    public void provideNewLevel()
    {
        String currentLevel = waitForElement1(By.cssSelector(".current-level.low-current-level")).getText();

        if (currentLevel.equalsIgnoreCase("Beginner"))
        {
            clickOnElement1(newLeavel);
            provideAndEnter(newLeavel, "Intermidiate");
        } else if (currentLevel.equalsIgnoreCase("Intermidiate"))
        {
            clickOnElement1(newLeavel);
            provideAndEnter(newLeavel, "Expert");
        } else if (currentLevel.equalsIgnoreCase("Expert"))
        {
            System.out.println("Skill is already at highest level- Expert");
        } else
        {
            System.out.println("Current level is not found..");
        }
    }
    public void addRemoveLearningCourse()
    {
        clickOnElement1(plusButton);
        BaseTest.log("Clicked on plus button");
        clickOnElement1(select);
        BaseTest.log("Clicked on select button");
        clickOnElement1(closePopup);
        BaseTest.log("Clicked on close button of popup");
        BasePage.hoverAndClick(javaProgramming, trash);
        waitTS(2);
        BasePage.pressEnter();
        BaseTest.log("pressed enter button");
    }
    public void deleteLearningCourse()
    {
        BasePage.hoverAndClick(javaProgramming, trash);
        waitTS(2);
        BasePage.pressEnter();
        BaseTest.log("pressed enter button");
    }

    public void scrollPage()
    {
        JavaScriptUtils.scrollIntoView(BaseTest.getDriver(), save);
    }

    //endregion

    //endregion
}