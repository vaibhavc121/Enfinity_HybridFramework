package pageObjects.HRMS.Performance;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    private WebElement checkbox;
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
        clickOnNew();
    }

    //region Header
    //endregion

    //region Feature to be included
    //endregion

    //region Rating
    //endregion

    //region Applicable For
    //endregion

    //region Reviewers
    //endregion
    //endregion
}