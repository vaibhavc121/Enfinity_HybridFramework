package pageObjects.HRMS.Onboarding;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnboardingTaskPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "(//i[@class='plus-icon white-color-icon'])[2]")
    private WebElement plusIcon;

    @FindBy(xpath = "(//input[contains(@id,'Name')])[3]")
    private WebElement name;

    @FindBy(xpath = "//input[contains(@id,'Category')]")
    private WebElement ecategory;

    @FindBy(xpath = "//input[contains(@id,'ResponsibleEmployeeType')]")
    private WebElement eassignTo;

    @FindBy(xpath = "//input[contains(@id,'TaskDue')]")
    private WebElement edueOn;

    @FindBy(xpath = "//span[@class='dx-checkbox-icon']")
    private WebElement checkbox;

    @FindBy(name = "Description")
    private WebElement description;

    //endregion

    //region Action Methods
    public void clickPlusIcon()
    {
        hoverAndClick(plusIcon, plusIcon);
    }
    public void provideName(String value)
    {
        clearAndProvide1(name, value);
    }
    public void selectCategory(String category)
    {
        clickOnElement1(ecategory);
        selectDropdownOption(category);
    }
    public void selectAssignTo(String assignTo)
    {
        clickOnElement1(eassignTo);
        waitTS(2);
        selectDropdownOption("Manager");
        waitTS(1);
        //clickOnElement1(eassignTo);
    }
    public void provideDueOn(String value)
    {
        clickOnElement1(edueOn);
        clearAndProvide1(edueOn, value);
    }
    public void clickCheckbox()
    {
        clickOnElement1(checkbox);
    }
    public void provideDesc(String value)
    {
        clearAndProvide1(description, value);
    }
    //endregion
}