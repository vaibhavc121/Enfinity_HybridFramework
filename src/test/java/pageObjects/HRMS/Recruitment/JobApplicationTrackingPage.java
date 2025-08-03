package pageObjects.HRMS.Recruitment;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobApplicationTrackingPage extends BasePage
{
    public JobApplicationTrackingPage(WebDriver driver)
    {
        super(driver);
    }

    //region Locators

    //region Job Listing
    @FindBy(xpath = "(//td[@class='list-hyperlink'])[1]") private WebElement jobName;
    @FindBy(xpath = "(//tr)[12]") private WebElement jobRow;
    //endregion

    //region Advance Candidate Search
    @FindBy(xpath="(//span[@class='dx-tab-text-span'])[1]") private WebElement description;
    @FindBy(xpath="(//span[@class='dx-tab-text-span'])[2]") private WebElement candidates;
    @FindBy(xpath="(//span[@class='dx-tab-text-span'])[3]") private WebElement edit;
    @FindBy(xpath="(//span[@class='dx-tab-text-span'])[4]") private WebElement assesment;
    @FindBy(xpath="(//span[@class='dx-tab-text-span'])[5]") private WebElement advanceCandidateSearch;

    //region Skills
    @FindBy(xpath = "//input[contains(@id,'Skills')]") private WebElement skills;
    //endregion

    //region Experience (In Years)
    @FindBy(xpath = "//input[contains(@id,'MinimumWorkExperience')]") private WebElement minimumWorkExperience;
    @FindBy(xpath = "//input[contains(@id,'MaximumWorkExperience')]") private WebElement maximumWorkExperience;
    //endregion

    //region Salary Range
    @FindBy(xpath = "//input[contains(@id,'MinimumSalaryRange')]") private WebElement minimumSalaryRange;
    @FindBy(xpath = "//input[contains(@id,'MaximumSalaryRange')]") private WebElement maximumSalaryRange;
    //endregion

    //region Notic Period (In Days)
    @FindBy(xpath = "//input[contains(@id,'MinimumNoticePeriodInDays')]") private WebElement minimumNoticePeriodInDays;
    @FindBy(xpath = "//input[contains(@id,'MaximumNoticePeriodInDays')]") private WebElement maximumNoticePeriodInDays;
    //endregion

    //region Personal
    @FindBy(xpath = "//input[contains(@id,'NationalityCountries')]") private WebElement nationalityCountries;
    @FindBy(xpath = "//input[contains(@id,'VisaType')]") private WebElement visaType;
    @FindBy(xpath = "(//input[contains(@id,'Gender')])[2]") private WebElement gender;
    @FindBy(xpath="(//span[@class='dx-checkbox-icon'])[3]") private WebElement drivingLicense;
    //endregion

    //region Age
    @FindBy(xpath = "//input[contains(@id,'MinimumAge')]") private WebElement minimumAge;
    @FindBy(xpath = "//input[contains(@id,'MaximumAge')]") private WebElement maximumAge;
    @FindBy(xpath = "//span[normalize-space()='Search Candidates']") private WebElement searchCandidates;
    //endregion

    @FindBy(xpath="//span[normalize-space()='Assign']") private WebElement assign;

    //endregion

    //endregion

    //region Action Methods

    //region Job Listing
    public String getJobName()
    {
        String jobNameText = waitForElement(jobName).getText();
        return jobNameText;
    }

    public void openJob()
    {
        waitForElement(jobRow).click();
        clickOnEdit();
    }

    public void openJobFromListing(String jobNameValue)
    {
        BasePage.navigateToEmployee(jobNameValue);
    }
    //endregion

    //region Advance Candidate Search

    public void clickAdvanceCandidateSearch()
    {
        waitForElement(advanceCandidateSearch).click();
    }

    //region Skills
     public void provideSkills(String skillsValue)
     {
         provideAndEnter(skills, skillsValue);
     }
    //endregion

    //region Experience (In Years)
    public void provideMinimumWorkExperience(String minimumWorkExperienceValue)
    {
        clearAndProvide1(minimumWorkExperience, minimumWorkExperienceValue);
    }
    public void provideMaximumWorkExperience(String maximumWorkExperienceValue)
    {
        clearAndProvide1(maximumWorkExperience, maximumWorkExperienceValue);
    }

    //endregion

    //region Salary Range
    public void provideMinimumSalaryRange(String minimumSalaryRangeValue)
    {
        clearAndProvide1(minimumSalaryRange, minimumSalaryRangeValue);
    }
    public void provideMaximumSalaryRange(String maximumSalaryRangeValue)
    {
        clearAndProvide1(maximumSalaryRange, maximumSalaryRangeValue);
    }

    //endregion

    //region Notic Period (In Days)
    public void provideMinimumNoticePeriodInDays(String minimumNoticePeriodInDaysValue)
    {
        clearAndProvide1(minimumNoticePeriodInDays, minimumNoticePeriodInDaysValue);
    }
    public void provideMaximumNoticePeriodInDays(String maximumNoticePeriodInDaysValue)
    {
        clearAndProvide1(maximumNoticePeriodInDays, maximumNoticePeriodInDaysValue);
    }

    //endregion

    //region Personal
    public void provideNationality(String nationalityValue)
    {
        provideAndEnter(nationalityCountries, nationalityValue);
    }
    public void provideVisaType(String visaTypeValue)
    {
        clearAndProvide1(visaType, visaTypeValue);
    }
    public void provideGender(String genderValue)
    {
        provideAndEnter(gender, genderValue);
    }
    public void clickDrivingLicense()
    {
        waitForElement(drivingLicense).click();
    }

    //endregion

    //region Age
    public void provideMinimumAge(String minimumAgeValue)
    {
        clearAndProvide1(minimumAge, minimumAgeValue);
    }
    public void provideMaximumAge(String maximumAgeValue)
    {
        clearAndProvide1(maximumAge, maximumAgeValue);
    }
    public void clickSearchCandidates()
    {
        waitForElement(searchCandidates).click();
    }

    public void scrollToTop()
    {
        scrollIntoView(driver,advanceCandidateSearch);
    }

    //endregion

    public void selectCandidate(String candidateName)
    {
        waitTS(2);
        waitForElement1(By.xpath("//span[normalize-space()='\" + candidateName + \"']/../../../../..//span[@class='dx-checkbox-icon']")).click();
    }

    public void clickAssign()
    {
        waitForElement(assign).click();
    }

    //endregion

    //endregion
}