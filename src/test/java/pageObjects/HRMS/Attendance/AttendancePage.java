package pageObjects.HRMS.Attendance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class AttendancePage extends BasePage
{

    public AttendancePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Attendance']")
    WebElement attendance;

    @FindBy(xpath = "//label[normalize-space()='Shift']")
    WebElement shift;

    @FindBy(xpath = "//label[normalize-space()='Roster']")
    WebElement roster;

    public void clickAttendance()
    {
        attendance.click();
    }

    public void clickShift()
    {
        shift.click();
    }

    public void clickRoster()
    {
        roster.click();
    }
}