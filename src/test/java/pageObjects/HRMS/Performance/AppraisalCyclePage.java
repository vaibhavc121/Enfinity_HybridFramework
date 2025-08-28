package pageObjects.HRMS.Performance;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.DataUtils;
import utilities.DateUtils;
import utilities.JavaScriptUtils;

public class AppraisalCyclePage extends BasePage
{
    public AppraisalCyclePage(WebDriver driver)
    {
        super(driver);
    }

    //region Locators

    //region Header
    @FindBy(xpath = "//input[contains(@id,'Name')]")
    private WebElement name;
    @FindBy(xpath = "//input[contains(@id,'AppraisalCycleFromDate')]")
    private WebElement appraisalFromDate;
    @FindBy(xpath = "//input[contains(@id,'AppraisalCycleToDate')]")
    private WebElement appraisalToDate;
    @FindBy(xpath = "//input[contains(@id,'AppraisalProcessFromDate')]")
    private WebElement processFromDate;
    @FindBy(xpath = "//input[contains(@id,'AppraisalProcessToDate')]")
    private WebElement processToDate;
    @FindBy(xpath = "//textarea[contains(@id,'Description')]")
    private WebElement description;
    //endregion

    //region Feature to be included
    @FindBy(xpath = "(//div[@class='dx-switch-on'][normalize-space()='ON'])[1]")
    private WebElement Goals;
    @FindBy(xpath = "(//div[@class='dx-switch-on'][normalize-space()='ON'])[2]")
    private WebElement KRA;
    @FindBy(xpath = "(//div[@class='dx-switch-on'][normalize-space()='ON'])[3]")
    private WebElement Competency;
    @FindBy(xpath = "(//div[@class='dx-switch-on'][normalize-space()='ON'])[4]")
    private WebElement reviewQuestions;

    @FindBy(xpath = "(//input[@role='spinbutton'])[1]")
    private WebElement goalsWeightage;
    @FindBy(xpath = "(//input[@role='spinbutton'])[2]")
    private WebElement KRAWeightage;
    @FindBy(xpath = "(//input[@role='spinbutton'])[3]")
    private WebElement competencyWeightage;
    //endregion

    //region Rating

    @FindBy(xpath = "//input[contains(@id,'GoalRatingTypeId')]")
    private WebElement goalRating;
    @FindBy(xpath = "//input[contains(@id,'KeyResultAreaRatingTypeId')]")
    private WebElement keyResultAreaRating;
    @FindBy(xpath = "//input[contains(@id,'CompetencyRatingTypeId')]")
    private WebElement competencyRating;
    @FindBy(xpath = "//input[contains(@id,'OverallRatingTypeId')]")
    private WebElement overallRating;

    //endregion

    //region Applicable For
    @FindBy(xpath = "//input[contains(@id,'JoiningDateUntil')]")
    private WebElement joiningDateUntil;
    @FindBy(xpath = "//input[contains(@id,'EmployeeIds')]")
    private WebElement employee;
    //endregion

    //region Reviewers
    @FindBy(xpath = "//span[@class='dx-checkbox-icon']")
    private WebElement allowManualWorkflow;
    @FindBy(xpath = "//input[contains(@id,'WorkflowId')]")
    private WebElement workflow;

    @FindBy(xpath = "(//div[@class='dx-switch-on'][normalize-space()='Yes'])[1]")
    private WebElement enableReviewerOpinion;
    @FindBy(xpath = "(//div[@class='dx-switch-on'][normalize-space()='Yes'])[2]")
    private WebElement enableSkillSetAssessment;
    //endregion

    //endregion

    //region Action Methods
    public void clickNew()
    {
        waitTS(2);
        clickOnNew();
    }

    //region Header
    public void enterName(String acname)
    {
        clearAndProvide1(name, acname);
    }
    public void enterAppraisalFromDate(String fromDate)
    {
        clearAndProvide1(appraisalFromDate, fromDate);
    }
    public void enterAppraisalToDate(String toDate)
    {
        clearAndProvide1(appraisalToDate, toDate);
    }
    public void enterProcessFromDate(String fromDate)
    {
        clearAndProvide1(processFromDate, fromDate);
    }
    public void enterProcessToDate(String toDate)
    {
        clearAndProvide1(processToDate, toDate);
    }
    public void enterDescription(String desc)
    {
        clearAndProvide1(description, desc);
    }
    //endregion

    //region Feature to be included
    public void enableGoals(boolean value)
    {
        if (value)
        {
            JavaScriptUtils.clickElementByJavaScript(driver, Goals);
        }
    }
    public void enableKRA(boolean value)
    {
        if (value)
        {
            JavaScriptUtils.clickElementByJavaScript(driver, KRA);
        }
    }
    public void enableCompetency(boolean value)
    {
        if (value)
        {
            JavaScriptUtils.clickElementByJavaScript(driver, Competency);
        }
    }
    public void enableReviewQuestions(boolean value)
    {
        if (value)
        {
            JavaScriptUtils.clickElementByJavaScript(driver, reviewQuestions);
        }
    }

    public void enterGoalsWeightage(String weightage)
    {
        clearAndProvide1(goalsWeightage, weightage);
    }
    public void enterKRAWeightage(String weightage)
    {
        clearAndProvide1(KRAWeightage, weightage);
    }
    public void enterCompetencyWeightage(String weightage)
    {
        clearAndProvide1(competencyWeightage, weightage);
    }

    //endregion

    //region Rating

    public void scrollPageGoalRating()
    {
        JavaScriptUtils.scrollIntoView(driver, goalRating);
    }
    public void selectGoalRating(String rating)
    {
        provideAndEnter(goalRating, rating);
    }
    public void selectKeyResultAreaRating(String rating)
    {
        provideAndEnter(keyResultAreaRating, rating);
    }
    public void selectCompetencyRating(String rating)
    {
        provideAndEnter(competencyRating, rating);
    }
    public void selectOverallRating(String rating)
    {
        provideAndEnter(overallRating, rating);
    }

    //endregion

    //region Applicable For
    public void enterJoiningDateUntil()
    {
        clearAndProvide1(joiningDateUntil, DateUtils.getCurrentDate("dd-MMM-yyyy"));
    }
    public void selectEmployee(String emp)
    {
        provideAndEnter(employee, emp);
    }

    //endregion

    //region Reviewers

    public void scrollPageToManualWorkflow()
    {
        JavaScriptUtils.scrollIntoView(driver, allowManualWorkflow);
    }
    public void checkAllowManualWorkflow(boolean value)
    {
        if (value)
        {
            clickOnElement1(allowManualWorkflow);
        }
    }
    public void selectWorkflow(String wf)
    {
        provideAndEnter(workflow, wf);
    }
    public void enableReviewerOpinion(boolean value)
    {
        if (value)
        {
            clickOnElement1(enableReviewerOpinion);
        }
    }
    public void enableSkillSetAssessment(boolean value)
    {
        if (value)
        {
            clickOnElement1(enableSkillSetAssessment);
        }
    }

    //endregion
    //endregion
}