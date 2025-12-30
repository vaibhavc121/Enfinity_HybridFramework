package pageObjects.HRMS.Learning.Setups;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseTrainerPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[normalize-space()='Course Trainer']")
    private WebElement courseTrainer;

    @FindBy(id = "CourseTrainer.TrainerName_I")
    private WebElement trainerName;
    //endregion

    //region Action Methods
    public void clickCourseTrainer()
    {
        clickOnElement1(courseTrainer);
    }
    public void provideTrainerName(String ctrainerName)
    {
        clearAndProvide1(trainerName, ctrainerName);
    }
    //endregion
}