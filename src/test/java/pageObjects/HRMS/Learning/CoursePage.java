package pageObjects.HRMS.Learning;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CoursePage extends BasePage
{

	public CoursePage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(name = "Name")
	WebElement name;

	@FindBy(xpath = "//input[contains(@id,'CourseCategoryId')]")
	WebElement category;

	@FindBy(xpath = "//input[contains(@id,'Mode')]")
	WebElement mode;

	@FindBy(xpath = "//input[contains(@id,'CourseTrainerId')]")
	WebElement courseTrainer;

	@FindBy(xpath = "//input[contains(@id,'Type')]")
	WebElement type;

	@FindBy(xpath = "//input[contains(@id,'Enroller')]")
	WebElement enroller;

	@FindBy(xpath = "//span[normalize-space()='+ Add Skills']")
	WebElement addSkills;

	@FindBy(xpath = "(//input[contains(@id,'SkillName')])[1]")
	WebElement skillName1;

	@FindBy(xpath = "(//input[contains(@id,'Level')])[1]")
	WebElement level1;

	@FindBy(xpath = "(//input[contains(@id,'Weightage')])[1]")
	WebElement weightage1;

	@FindBy(xpath = "(//input[contains(@id,'SkillName')])[2]")
	WebElement skillName2;

	@FindBy(xpath = "(//input[contains(@id,'Level')])[2]")
	WebElement level2;

	@FindBy(xpath = "(//input[contains(@id,'Weightage')])[2]")
	WebElement weightage2;

	@FindBy(xpath = "(//input[contains(@id,'SkillName')])[3]")
	WebElement skillName3;

	@FindBy(xpath = "(//input[contains(@id,'Level')])[3]")
	WebElement level3;

	@FindBy(xpath = "(//input[contains(@id,'Weightage')])[3]")
	WebElement weightage3;

	@FindBy(xpath = "//div[@class='dx-item-content dx-list-item-content'][normalize-space()='HR']")
	WebElement hR;

	@FindBy(xpath = "//span[normalize-space()='+ Add Batch']")
	WebElement addBatch;

	@FindBy(name = "courseBatch[0].Name")
	WebElement batchName;

	@FindBy(xpath = "//input[contains(@id,'StartDate')]")
	WebElement startDate;

	@FindBy(xpath = "//input[contains(@id,'EndDate')]")
	WebElement endDate;

	@FindBy(xpath = "//h4[@class='course-title']")
	List<WebElement> courses;

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideCourseName(String value)
	{
		name.sendKeys(value);
	}

	public void provideCategory(String value)
	{
		category.click();
		selectDropdownOption(value);
	}

	public void provideMode(String value)
	{
		mode.click();
		selectDropdownOption(value);
	}

	public void provideCourseTrainer(String value)
	{
		courseTrainer.click();
		selectDropdownOption(value);
	}

	public void provideType(String value)
	{
		type.click();
		selectDropdownOption(value);
	}

	public void provideEnroller(String value)
	{
		enroller.click();
		hR.click();
	}

	public void clickAddSkillsBtn()
	{
		addSkills.click();
	}

	public void provideSkillName1(String value)
	{
		skillName1.click();
		selectDropdownOption(value);
	}

	public void provideLevel1(String value)
	{
		level1.click();
		selectDropdownOption(value);
	}

	public void provideWeightage1(String value)
	{
		clearAndProvide1(weightage1, value);
	}

	public void provideSkillName2(String value)
	{
		skillName2.click();
		selectDropdownOption(value);
	}

	public void provideLevel2(String value)
	{
		level2.click();
		selectDropdownOption(value);
	}

	public void provideWeightage2(String value)
	{
		clearAndProvide1(weightage2, value);
	}

	public void provideSkillName3(String value)
	{
		skillName3.click();
		selectDropdownOption(value);
	}

	public void provideLevel3(String value)
	{
		level3.click();
		selectDropdownOption(value);
	}

	public void provideWeightage3(String value)
	{
		clearAndProvide1(weightage3, value);
	}

	public void scrollWebPage()
	{
		scrollDownWebPage(addBatch);
	}

	public void clickAddBatch()
	{
		addBatch.click();
	}

	public void provideBatchName(String value)
	{
		batchName.sendKeys(value);
	}

	public void provideStartDate(String value)
	{
		clearAndProvide1(startDate, value);
	}

	public void provideEndDate(String value)
	{
		clearAndProvide1(endDate, value);
	}

	public void clickSaveBack()
	{
		clickSaveAndBack();
	}

	public boolean isTxnCreated(String value)
	{
		return isValuePresent(courses, value);
	}

}
