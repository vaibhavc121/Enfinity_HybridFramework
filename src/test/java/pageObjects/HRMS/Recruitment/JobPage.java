package pageObjects.HRMS.Recruitment;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.DateUtils;

public class JobPage extends BasePage
{

	public JobPage(WebDriver driver)
	{
		super(driver);

	}

	//region Locators
	@FindBy(xpath="//div[@class='jobTemplateUpload']") private WebElement templateUploadbutton;
	@FindBy(xpath = "//input[contains(@id,'Template')]") private WebElement templateDD;
	@FindBy(xpath="//span[normalize-space()='Select']") private WebElement select;

	@FindBy(name = "JobTitle")
	private WebElement jobTitle;

	@FindBy(xpath = "//input[contains(@id,'JobCompanyId')]") private WebElement company;

	@FindBy(xpath = "//input[contains(@id,'DepartmentId')]")
	private WebElement department;

	@FindBy(xpath = "//input[contains(@id,'DesignationId')]")
	private WebElement designation;

	@FindBy(xpath = "//input[contains(@id,'NumberOfPosition')]")
	private WebElement numberOfPosition;

	@FindBy(xpath = "//input[contains(@id,'EmploymentType')]")
	private WebElement employmentType;

	@FindBy(name = "Industry")
	private WebElement industry;

	@FindBy(xpath = "//input[contains(@id,'TargetDate')]")
	private WebElement targetDate;

	@FindBy(xpath = "//input[contains(@id,'Salary')]")
	private WebElement monthlySalary;

	@FindBy(xpath = "//input[contains(@id,'AssignedManagerIds')]")
	private WebElement assignedManager;

	@FindBy(xpath = "//input[contains(@id,'AssignedRecruiterIds')]")
	private WebElement assignedRecruiter;

	@FindBy(xpath = "//input[contains(@id,'WorkExperienceInYear')]")
	private WebElement workExperience;

	@FindBy(xpath = "//input[contains(@id,'SkillIds')]")
	private WebElement skills;

	@FindBy(xpath = "//input[contains(@id,'City')]")
	private WebElement city;

	@FindBy(xpath = "//input[contains(@id,'State')]")
	private WebElement state;

	@FindBy(xpath = "(//input[contains(@id,'CountryId')])[1]")
	private WebElement country;

	@FindBy(xpath = "//input[contains(@id,'PostalCode')]")
	private WebElement postalCode;

	@FindBy(xpath = "//input[contains(@id,'Gender')]")
	private WebElement gender;

	@FindBy(xpath = "//input[contains(@id,'MaritalStatus')]")
	private WebElement maritalStatus;

	@FindBy(xpath = "//input[contains(@id,'NationalityCountryId')]")
	private WebElement nationality;

	@FindBy(xpath="//div[@aria-label='To enrich screen reader interactions, please activate Accessibility in Grammarly extension settings']") private WebElement description;

	@FindBy(xpath = "//tr[@class='dx-row dx-data-row dx-row-lines dx-column-lines']//td[1]//span")
	private WebElement col1;

	@FindBy(xpath="//span[@class='bCardHover']") private WebElement jobName;
	//endregion

	//region Action Methods
	public void clickNew()
	{
		clickOnNew();
	}

	public void selectJobTemplate(String templateName)
	{
		templateUploadbutton.click();
		provideAndEnter(templateDD, templateName);
		waitForElement(select).click();
	}

	public void provideJobTitle(String value)
	{
		clearAndProvide1(jobTitle, value);
	}

	public void provideCompany(String value)
	{
		provideAndEnter(company, value);
	}

	public void provideDepartment(String value)
	{
		provideAndEnter(department, value);
	}

	public void provideDesignation(String value)
	{
		provideAndEnter(designation, value);
	}

	public void provideNumberOfPosition(String value)
	{
		clearAndProvide1(numberOfPosition, value);
	}

	public void provideEmploymentType(String value)
	{
		employmentType.click();
		selectDropdownOption(value);
	}

	public void provideIndustry(String value)
	{
		industry.sendKeys(value);
	}

	public void provideTargetDate()
	{
		clearAndProvide1(targetDate, DateUtils.addDaysToCurrentDate(7,"dd-MMM-yyyy"));
	}

	public void provideMonthlySal(String value)
	{
		clearAndProvide1(monthlySalary, value);
	}

	public void provideAssignedManager(String value)
	{
		provideAndEnter(assignedManager, value);
	}

	public void provideAssignedRecruiter(String value)
	{
		provideAndEnter(assignedRecruiter, value);
	}

	public void provideWorkExperience(String value)
	{
		clearAndProvide1(workExperience, value);
	}

	public void provideSkills(String value)
	{
		provideAndEnter(skills, value);
	}

	public void provideCity(String value)
	{
		city.sendKeys(value);
	}

	public void provideState(String value)
	{
		state.sendKeys(value);
	}

	public void provideCountry(String value)
	{
		provideAndEnter(country, value);
	}

	public void providePostalCode(String value)
	{
		postalCode.sendKeys(value);
	}

	public void provideGender(String value)
	{
		provideAndEnter(gender, value);
	}

	public void provideMaritalStatus(String value)
	{
		provideAndEnter(maritalStatus, value);
	}

	public void provideNationality(String value)
	{
		provideAndEnter(nationality, value);
	}

	public void provideDescription(String jobTitle)
	{
		clearAndProvide1(description, "Job Opening for the position of: " + jobTitle +": "+ new Faker().lorem().paragraph());
	}

	public void clickSave()
	{
		clickOnSave();
	}

	public boolean isTxnCreated(String value)
	{
		String jobTitleText = jobName.getText();
		return jobTitleText.contains(value);
	}
	//endregion





}