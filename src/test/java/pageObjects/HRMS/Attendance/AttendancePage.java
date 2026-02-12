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

    @FindBy(xpath = "//label[normalize-space()='Roster Request']")
    private WebElement rosterRequest;

    public static void clickAttendance()
    {
        BasePage.clickMenuIcon();
        clickOnElement1(attendance);
    }

    public void clickShift()
    {
        shift.click();
    }

    public void clickRoster()
    {
        roster.click();
    }

    public void clickRosterRequest()
    {
        clickOnElement1(rosterRequest);
    }
}