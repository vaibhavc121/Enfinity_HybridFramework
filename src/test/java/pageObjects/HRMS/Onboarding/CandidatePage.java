package pageObjects.HRMS.Onboarding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CandidatePage extends BasePage
{

	public CandidatePage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(xpath = "//input[contains(@id,'Name')]")
	WebElement name;

	@FindBy(xpath = "//input[contains(@id,'NameL2')]")
	WebElement nameArabic;

	@FindBy(xpath = "//input[contains(@id,'Email')]")
	WebElement email;

	@FindBy(xpath = "//input[contains(@id,'MobileNumber')]")
	WebElement mobileNumber;

	@FindBy(xpath = "//input[contains(@id,'DateOfBirth')]")
	WebElement dateOfBirth;

	@FindBy(xpath = "//input[contains(@id,'Gender')]")
	WebElement gender;

	@FindBy(xpath = "//input[contains(@id,'MaritalStatus')]")
	WebElement maritalStatus;

	@FindBy(xpath = "//input[contains(@id,'City')]")
	WebElement city;

	@FindBy(xpath = "//input[contains(@id,'State')]")
	WebElement state;

	@FindBy(xpath = "//input[contains(@id,'CountryId')]")
	WebElement country;

	@FindBy(xpath = "//input[contains(@id,'PostalCode')]")
	WebElement postalCode;

	@FindBy(xpath = "//input[contains(@id,'WorkExperienceInYear')]")
	WebElement workExperienceInYear;

	@FindBy(xpath = "//input[contains(@id,'CurrentJobTitle')]")
	WebElement currentJobTitle;

	@FindBy(xpath = "//input[contains(@id,'CurrentEmployer')]")
	WebElement currentEmployer;

	@FindBy(xpath = "//input[contains(@id,'SkillIds')]")
	WebElement skills;

	@FindBy(xpath = "//input[contains(@id,'CurrentSalary')]")
	WebElement currentSalary;

	@FindBy(xpath = "//input[contains(@id,'ExpectedSalary')]")
	WebElement expectedSalary;

	@FindBy(xpath = "//input[contains(@id,'NoticePeriodInDays')]")
	WebElement noticePeriodInDays;

	@FindBy(xpath = "//input[contains(@id,'PassportNumber')]")
	WebElement passportNumber;

	@FindBy(xpath = "//input[contains(@id,'PassportIssueDate')]")
	WebElement passportIssueDate;

	@FindBy(xpath = "//input[contains(@id,'PassportExpiryDate')]")
	WebElement passportExpiryDate;

	@FindBy(xpath = "//input[contains(@id,'VisaType')]")
	WebElement visaType;

	@FindBy(xpath = "//input[contains(@id,'CivilIdNumber')]")
	WebElement civilIdNumber;

	@FindBy(xpath = "//span[normalize-space()='+ Add Qualification']")
	WebElement addQualification;

	@FindBy(xpath = "//input[contains(@id,'candidateQualification[0].University')]")
	WebElement university;

	@FindBy(xpath = "//input[contains(@id,'candidateQualification[0].AcademicDegree')]")
	WebElement academicDegree;

	@FindBy(xpath = "//input[contains(@id,'candidateQualification[0].Major')]")
	WebElement majorDegree;

	@FindBy(xpath = "//input[contains(@id,'candidateQualification[0].YearOfPassing')]")
	WebElement yearOfPassing;

	@FindBy(xpath = "//div[contains(@class,'dx-checkbox-icon')]")
	WebElement checkbox;

	@FindBy(xpath = "//span[normalize-space()='+ Add Experience']")
	WebElement addExperience;

	@FindBy(xpath = "//input[contains(@id,'candidateExperience[0].JobTitle')]")
	WebElement jobTitle;

	@FindBy(xpath = "//input[contains(@id,'candidateExperience[0].PriorCompanyName')]")
	WebElement company;

	@FindBy(xpath = "//input[contains(@id,'candidateExperience[0].StartDate')]")
	WebElement startDate;

	@FindBy(xpath = "//input[contains(@id,'candidateExperience[0].EndDate')]")
	WebElement endDate;

	@FindBy(xpath = "//textarea[contains(@id,'candidateExperience[0].WorkProfile')]")
	WebElement workProfile;

	public void clickNew() throws InterruptedException
	{
		clickOnNew();
		Thread.sleep(2000);
	}

	public String candidateName = randomString();

	public void provideName()
	{
		name.sendKeys(candidateName);
	}

	public void provideEmail()
	{
		email.sendKeys(randomEmail());
	}

	public void provideMbl(String value)
	{
		mobileNumber.sendKeys(value);
	}

	public void provideDob(String value)
	{
		clearAndProvide1(dateOfBirth, value);
	}

	public void provideGender(String value)
	{
		provideAndEnter(gender, value);
	}

	public void provideMaritalStatus(String value)
	{
		provideAndEnter(maritalStatus, value);
	}

	public void provideCity(String value)
	{
		clearAndProvide1(city, value);
	}

	public void provideState(String value)
	{
		clearAndProvide1(state, value);
	}

	public void provideCountry(String value)
	{
		provideAndEnter(country, value);
	}

	public void providePostalCode(String value)
	{
		clearAndProvide1(postalCode, value);
	}

	public void provideWorkExperienceInYear(String value)
	{
		clearAndProvide1(workExperienceInYear, value);
	}

	public void provideCurrentJobTitle(String value)
	{
		clearAndProvide1(currentJobTitle, value);
	}

	public void provideCurrentEmployer(String value)
	{
		clearAndProvide1(currentEmployer, value);
	}

	public void provideSkills(String value)
	{
		provideAndEnter(skills, value);
	}

	public void provideCurrentSalary(String value)
	{
		clearAndProvide1(currentSalary, value);
	}

	public void provideExpectedSalary(String value)
	{
		clearAndProvide1(expectedSalary, value);
	}

	public void provideNoticePeriodInDays(String value)
	{
		clearAndProvide1(noticePeriodInDays, value);
	}

	public void providePassportNumber(String value)
	{
		clearAndProvide1(passportNumber, value);
	}

	public void providePassportIssueDate(String value)
	{
		clearAndProvide1(passportIssueDate, value);
	}

	public void providePassportExpiryDate(String value)
	{
		clearAndProvide1(passportExpiryDate, value);
	}

	public void provideVisaType(String value)
	{
		clearAndProvide1(visaType, value);
	}

	public void provideCivilIdNumber(String value)
	{
		clearAndProvide1(civilIdNumber, value);
	}

	public void clickAddQualification()
	{
		addQualification.click();
	}

	public void provideUniversity(String value)
	{
		clearAndProvide1(university, value);
	}

	public void provideAcademicDegree(String value)
	{
		academicDegree.click();
		selectDropdownOption(value);
	}

	public void provideMajorDegree(String value)
	{
		clearAndProvide1(majorDegree, value);
	}

	public void provideYearOfPassing(String value)
	{
		clearAndProvide1(yearOfPassing, value);
	}

	public void clickCheckbox()
	{
		checkbox.click();
	}

	public void clickAddExperience()
	{
		addExperience.click();
	}

	public void provideJobTitle(String value)
	{
		clearAndProvide1(jobTitle, value);
	}

	public void provideCompany(String value)
	{
		clearAndProvide1(company, value);
	}

	public void provideStartDate(String value)
	{
		clearAndProvide1(startDate, value);
	}

	public void provideEndDate(String value)
	{
		clearAndProvide1(endDate, value);
	}

	public void provideWorkProfile(String value)
	{
		clearAndProvide1(workProfile, value);
	}

	public void clickSave() throws InterruptedException
	{
		clickOnSave();
		Thread.sleep(2000);
	}

	public boolean isTxnCreated()
	{
		String actualCandidateName = driver.findElement(By.xpath("//span[@class='bCardHover']")).getText();
		return actualCandidateName.equals(candidateName);
	}

}
