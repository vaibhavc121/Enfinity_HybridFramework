package pageObjects.HRMS.Learning.Setups;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseRoomPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[text()='Course Room']")
    private WebElement courseRoomLink;

    @FindBy(id = "CourseRoom.Name_I")
    private WebElement name;

    @FindBy(id = "CourseRoom.Capacity_I")
    private WebElement capacity;

    @FindBy(id = "CourseRoom.Location_I")
    private WebElement location;

    @FindBy(id = "CourseRoom.Facilities_I")
    private WebElement facilities;
    //endregion

    //region Action Methods
    public void clickCourseRoom()
    {
        clickOnElement1(courseRoomLink);
    }
    public void provideName(String crname)
    {
        clearAndProvide1(name, crname);
    }
    public void provideCapacity(String crcapacity)
    {
        clearAndProvide1(capacity, crcapacity);
    }
    public void provideLocation(String crlocation)
    {
        clearAndProvide1(location, crlocation);
    }
    public void provideFacilities(String crfacilities)
    {
        clearAndProvide1(facilities, crfacilities);
    }

    //endregion
}