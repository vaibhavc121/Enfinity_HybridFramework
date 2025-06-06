package pageObjects.HRMS.SuccessionPlanning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class SuccessionPlanPage extends BasePage
{

	public SuccessionPlanPage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(name = "Name")
	private WebElement name;

	@FindBy(xpath = "//input[contains(@id,'NameL2')]")
	private WebElement nameArabic;

	@FindBy(xpath = "//input[contains(@id,'DesignationId')]")
	private WebElement designation;

	@FindBy(xpath = "//input[contains(@id,'EmployeeId')]")
	private WebElement employee;

	@FindBy(xpath = "//input[contains(@id,'MinimumPercentage')]")
	private WebElement minimumPercentage;

	@FindBy(xpath = "//input[contains(@id,'RequiredQualificationPercentage')]")
	private WebElement qualificationPercentage;

	@FindBy(xpath = "//input[contains(@id,'RequiredExperiencePercentage')]")
	private WebElement experiencePercentage;

	@FindBy(xpath = "//input[contains(@id,'RequiredSkillPercentage')]")
	private WebElement skillsPercentage;

	@FindBy(xpath = "//input[contains(@id,'RequiredAppraisalPercentage')]")
	private WebElement appraisalPercentage;

	@FindBy(xpath = "//input[contains(@id,'RequiredCoursePercentage')]")
	private WebElement coursePercentage;

	@FindBy(xpath = "//textarea[contains(@id,'Description')]")
	private WebElement description;

	// Action methods

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideName(String value)
	{
		name.sendKeys(value);
	}

	public void provideNameArabic(String value)
	{
		clearAndProvide1(nameArabic, value);
	}

	public void provideDesignation(String value)
	{
		provideAndEnter(designation, value);
	}

	public void provideEmployee(String value)
	{
		provideAndEnter(employee, value);
	}

	public void provideMinimumPercentage(String value)
	{
		clearAndProvide1(minimumPercentage, value);
	}

	public void provideQualificationPercentage(String value)
	{
		clearAndProvide1(qualificationPercentage, value);
	}

	public void provideExperiencePercentage(String value)
	{
		clearAndProvide1(experiencePercentage, value);
	}

	public void provideSkillsPercentage(String value)
	{
		clearAndProvide1(skillsPercentage, value);
	}

	public void provideAppraisalPercentage(String value)
	{
		clearAndProvide1(appraisalPercentage, value);
	}

	public void provideCoursePercentage(String value)
	{
		clearAndProvide1(coursePercentage, value);
	}

	public void provideDesc(String value)
	{
		clearAndProvide1(description, value);
	}

	public void clickSave()
	{
		clickSaveAndBack();
	}

	public boolean isTxnCreated(String value)
	{
		List<WebElement> results = driver.findElements(By.xpath("(//tbody)[7]//tr"));

		for (WebElement result : results)
		{
			String resultName = result.getText();
			if (resultName.contains(value))
			{
				return true;
			}
		}
		return false;
	}

}
