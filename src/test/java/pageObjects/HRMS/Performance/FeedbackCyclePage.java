package pageObjects.HRMS.Performance;

import base.BasePage;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JavaScriptUtils;

public class FeedbackCyclePage extends BasePage
{
    //region Locators

    //region Header & Settings
    @FindBy(xpath = "//input[contains(@id,'Name')]")
    private WebElement name;
    @FindBy(xpath = "//textarea[contains(@id,'Description')]")
    private WebElement description;
    @FindBy(xpath = "//input[contains(@id,'ProcessFromDate')]")
    private WebElement processFromDate;
    @FindBy(xpath = "//input[contains(@id,'ProcessToDate')]")
    private WebElement processToDate;
    @FindBy(xpath = "//input[contains(@id,'RatersSelectionWorkflowId')]")
    private WebElement workflow;
    @FindBy(xpath = "//input[contains(@id,'MinimumRater')]")
    private WebElement minimumRater;
    @FindBy(xpath = "//input[contains(@id,'MaximumRater')]")
    private WebElement maximumRater;
    @FindBy(xpath = "(//span[@class='dx-checkbox-icon'])[1]")
    private WebElement allowRatingCheckbox;
    @FindBy(xpath = "//input[contains(@id,'OverallRatingTypeId')]")
    private WebElement overallRating;
    @FindBy(xpath = "(//span[@class='dx-checkbox-icon'])[2]")
    private WebElement manualOverallRatingCheckbox;
    @FindBy(xpath = "//input[contains(@id,'JoiningDateUntil')]")
    private WebElement joiningDateUntil;
    @FindBy(xpath = "//input[contains(@id,'EmployeeIds')]")
    private WebElement employeeDD;
    @FindBy(xpath = "//span[normalize-space()='Next']")
    private WebElement next;
    //endregion

    //region Questions
    @FindBy(xpath = "//span[normalize-space()='Add Question']")
    private WebElement addQuestion;

    @FindBy(xpath = "//div[@aria-label='Editor content']")
    private WebElement editorContent;

    @FindBy(xpath = "//input[contains(@id,'EvaluationCategoryName')]")
    private WebElement category;

    @FindBy(xpath = "//input[contains(@id,'RatingTypeId')]")
    private WebElement ratingType;

    @FindBy(xpath = "(//span[@class='dx-checkbox-icon'])[3]")
    private WebElement mandatoryCheckbox;

    @FindBy(xpath = "//div[@id='CreateButton']")
    private WebElement add;

    @FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
    private WebElement closeIcon;

    //endregion

    //endregion

    //region Action Methods

    //region Header & Settings
    public void provideName(String value)
    {
        waitTS(2);
        clearAndProvide1(name, value);
    }
    public void provideDesc(String value)
    {
        clearAndProvide1(description, value);
    }
    public void provideProcessFromDate(String value)
    {
        clearAndProvide1(processFromDate, value);
    }
    public void provideProcessToDate(String value)
    {
        clearAndProvide1(processToDate, value);
    }
    public void selectWorkflow(String value)
    {
        provideAndEnter(workflow, value);
    }
    public void provideMinimumRater(String value)
    {
        //clearAndProvide1(minimumRater, value);
        JavaScriptUtils.provideValueJS(minimumRater, value);
    }
    public void provideMaximumRater(String value)
    {
        //clearAndProvide1(maximumRater, value);
        JavaScriptUtils.provideValueJS(maximumRater, value);
    }
    public void checkAllowRating()
    {
        clickOnElement1(allowRatingCheckbox);
    }
    public void selectOverallRating(String value)
    {
        provideAndEnter(overallRating, value);
    }
    public void checkManualOverallRating()
    {
        clickOnElement1(manualOverallRatingCheckbox);
    }
    public void scrollDownTOJoiningDateUntil()
    {
        JavaScriptUtils.scrollIntoView(DriverFactory.getDriver(), joiningDateUntil);
    }
    public void provideJoiningDateUntil(String value)
    {
        clearAndProvide1(joiningDateUntil, value);
    }
    public void selectEmployee(String value)
    {
        provideAndEnter(employeeDD, value);
    }
    public void clickNext()
    {
        clickOnElement1(next);
    }

    //endregion

    //region Questions
    public void clickAddQuestion()
    {
        clickOnElement1(addQuestion);
    }
    public void provideQuestion(String value)
    {
        clearAndProvide1(editorContent, value);
    }

    public void selectValueFromDD(String value)
    {
        waitForElement1(By.xpath("//span[normalize-space()='Category']//following::div[text()=' " + value + " ']")).click();
    }

    public void provideCategory(String value)
    {
        clickOnElement1(category);
        //selectDropdownOption(value);

        WebElement element = DriverFactory.getDriver().findElement((By.xpath("//span[normalize-space()='Category']//following::div[normalize-space()=' " + value + " ']")));
        JavaScriptUtils.clickElementByJavaScript(DriverFactory.getDriver(), element);
    }
    public void selectRatingType(String value)
    {
        clickOnElement1(ratingType);
        //selectDropdownOption(value);
        WebElement element = waitForElement1(By.xpath("//span[normalize-space()='Rating Type']//following::div[text()=' " + value + " ']"));
        JavaScriptUtils.clickElementByJavaScript(DriverFactory.getDriver(), element);
    }
    public void checkMandatory()
    {
        clickOnElement1(mandatoryCheckbox);
    }
    public void clickAdd()
    {
        clickOnElement1(add);
    }
    public void closeQuestionsPopup()
    {
        clickOnElement1(closeIcon);
    }
    //endregion

    //endregion
}