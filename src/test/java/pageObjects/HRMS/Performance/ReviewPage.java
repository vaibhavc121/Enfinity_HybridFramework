package pageObjects.HRMS.Performance;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JavaScriptUtils;

import java.util.HashMap;
import java.util.Map;

public class ReviewPage extends BasePage
{
    //region Locators

    //region Key Result Areas
    @FindBy(xpath = "(//input[@role='spinbutton'])[1]")
    private WebElement spinbutton1;

    @FindBy(xpath = "(//textarea[@class='dx-texteditor-input'])[1]")
    private WebElement reviewComment1;

    @FindBy(xpath = "(//textarea[@class='dx-texteditor-input'])[2]")
    private WebElement empOpinionKRA;

    @FindBy(xpath = "//textarea[contains(@id,'Comment')]")
    private WebElement overallComment1;

    @FindBy(xpath = "//textarea[contains(@id,'TrainingRequirements')]")
    private WebElement TrainingRequirements1;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    private WebElement save;

    @FindBy(xpath = "//span[normalize-space()='Approve']")
    private WebElement approve;

    @FindBy(xpath = "//span[normalize-space()='Submit for Opinion']")
    private WebElement submitForOpinion;
    //endregion

    //region Goals

    @FindBy(xpath = "//span[normalize-space()='Goals']")
    private WebElement goals;

    @FindBy(xpath = "(//input[@role='spinbutton'])[3]")
    private WebElement spinbutton2;

    @FindBy(xpath = "(//textarea[@class='dx-texteditor-input'])[2]")
    private WebElement reviewComment2;

    @FindBy(xpath = "(//textarea[@class='dx-texteditor-input'])[3]")
    private WebElement empOpiniongoals;

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

    @FindBy(xpath = "(//input[@role='spinbutton'])[5]")
    private WebElement spinbutton3;

    @FindBy(xpath = "(//textarea[@class='dx-texteditor-input'])[3]")
    private WebElement reviewComment3;

    @FindBy(xpath = "(//textarea[@class='dx-texteditor-input'])[5]")
    private WebElement empOpinionCompetencies;

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

    //region Validation

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
    public void provideEmpOpinionKRA()
    {
        clearAndProvide1(empOpinionKRA, "Emp Opinion for KRA");
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
    public void scrollPageSubmitForOpinion()
    {
        JavaScriptUtils.scrollIntoView(BaseTest.getDriver(), submitForOpinion);
    }
    public void clickSubmitForOpinion()
    {
        waitForElement(submitForOpinion).click();
    }

    //endregion

    //region Goals
    public void clickGoals()
    {
        JavaScriptUtils.clickElementByJavaScript(BaseTest.getDriver(), goals);
    }
    public void provideRating2(String value)
    {
        clearAndProvide1(spinbutton2, value);
    }
    public void enterReviewComment2(String value)
    {
        clearAndProvide1(reviewComment2, value);
    }
    public void provideEmpOpinionGoal()
    {
        clearAndProvide1(empOpiniongoals, "Emp Opinion for Goals");
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
        JavaScriptUtils.clickElementByJavaScript(BaseTest.getDriver(), competenciesCompetencies);
    }
    public void provideRating3(String value)
    {
        clearAndProvide1(spinbutton3, value);
    }
    public void enterReviewComment3(String value)
    {
        clearAndProvide1(reviewComment3, value);
    }
    public void provideEmpOpinionCompetencies()
    {
        clearAndProvide1(empOpinionCompetencies, "Emp Opinion for Competencies");
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
        JavaScriptUtils.clickElementByJavaScript(BaseTest.getDriver(), reviewQuestions);
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
        JavaScriptUtils.clickElementByJavaScript(BaseTest.getDriver(), performance);
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
        clickOnElement1(promotedDepartment);
        selectDropdownOption(value);
    }
    public void selectPromotedDesignation(String value)
    {
        BasePage.waitTS(2);
        clickOnElement1(promotedDesignation);
        selectDropdownOption(value);
    }

    //endregion

    //region Skills & Learning
    public void clickSkillsAndLearning()
    {
        JavaScriptUtils.clickElementByJavaScript(BaseTest.getDriver(), skillsAndLearning);
    }
    public void provideNewLevel()
    {
        String currentLevel = waitForElement1(By.xpath("//td[@class='current-level']")).getText();

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
        waitTS(3);
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

    public void scrollPageApprove()
    {
        JavaScriptUtils.scrollIntoView(BaseTest.getDriver(), approve);
    }

    public boolean verifyStatus()
    {
        String opinionStatus = waitForElement1(By.xpath("//span[@id='opinion_status']")).getText();
        if (opinionStatus.contains("Pending for employee's opinion"))
        {
            return true;
        } else
        {
            return false;
        }
    }

    //endregion

    //region Validation
    public Map<String, String> extractRating1()
    {
        String finalScore = waitForElement1(By.xpath("(//span[@id='finalAvg'])[2]")).getText().trim();
        String finalRating = waitForElement1(By.xpath("(//span[@id='ratingName'])[1]")).getText().trim();

        Map<String, String> data = new HashMap<>();
        data.put("finalScore", finalScore);
        data.put("finalRating", finalRating);

        return data;
    }

    public boolean extractRating(String expectedFinalScore, String expectedFinalRating)
    {
        String finalScore = waitForElement1(By.xpath("(//span[@id='finalAvg'])[2]")).getText().trim();
        String finalRating = waitForElement1(By.xpath("(//span[@id='ratingName'])[1]")).getText().trim();

        if (finalScore.equals(expectedFinalScore) && finalRating.equals(expectedFinalRating))
        {
            return true;
        } else
        {
            return false;
        }
    }

    //endregion

    //endregion
}