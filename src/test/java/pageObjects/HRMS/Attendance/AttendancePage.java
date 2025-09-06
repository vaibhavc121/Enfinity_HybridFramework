package pageObjects.HRMS.Attendance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class AttendancePage extends BasePage
{

    @FindBy(xpath = "//span[normalize-space()='Attendance']")
    static WebElement attendance;

    @FindBy(xpath = "//label[normalize-space()='Shift']")
    WebElement shift;

    @FindBy(xpath = "//label[normalize-space()='Roster']")
    WebElement roster;

    public static void clickAttendance()
    {
        BasePage.clickMenuIcon();
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