package pageObjects.HRMS.Learning.Setups;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseCategoryPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[text()='Course Category']")
    private WebElement courseCategory;

    @FindBy(id = "CourseCategory.Name_I")
    private WebElement name;
    //endregion

    //region Action Methods
    public void clickCourseCategory()
    {
        clickOnElement1(courseCategory);
    }
    public void provideName(String categoryName)
    {
        clearAndProvide1(name, categoryName);
    }
    //endregion
}