package pageObjects.HRMS.SelfService.Setups;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnnouncementPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[text()='Announcement']")
    private WebElement announcement;

    @FindBy(xpath = "//input[contains(@id,'Title')]")
    private WebElement title;

    @FindBy(xpath = "//input[contains(@id,'ExpiryDate')]")
    private WebElement expiryDate;

    @FindBy(xpath = "//div[@aria-label='Editor content']")
    private WebElement body;

    @FindBy(xpath = "//input[contains(@id,'DepartmentIds')]")
    private WebElement department;

    @FindBy(xpath = "//input[contains(@id,'WorkLocationIds')]")
    private WebElement workLocation;

    @FindBy(xpath = "//input[contains(@id,'EmployeeIds')]")
    private WebElement employee;

    @FindBy(xpath = "//span[normalize-space()='Publish']")
    private WebElement publish;

    @FindBy(xpath = "//span[normalize-space()='Delete']")
    private WebElement delete;

    @FindBy(id = "MainMenu_DXI8_P")
    private WebElement contextMenu;
    //endregion

    //region Action Methods
    public void clickAnnouncement()
    {
        clickOnElement1(announcement);
    }
    public void provideTitle(String atitle)
    {
        clearAndProvide1(title, atitle);
    }
    public void provideExpiryDate(String aexpiryDate)
    {
        clearAndProvide1(expiryDate, aexpiryDate);
    }
    public void provideBody(String abody)
    {
        clearAndProvide1(body, abody);
    }
    public void provideDepartment(String adepartment)
    {
        provideAndEnter(department, adepartment);
    }
    public void provideWorkLocation(String aworkLocation)
    {
        provideAndEnter(workLocation, aworkLocation);
    }
    public void provideEmployee(String aemployee)
    {
        provideAndEnter(employee, aemployee);
    }
    public void clickPublish()
    {
        clickOnElement1(publish);
    }
    public void clickDelete()
    {
        clickOnElement1(delete);
    }
    public void clickContextMenu()
    {
        clickOnElement1(contextMenu);
    }
    //endregion
}