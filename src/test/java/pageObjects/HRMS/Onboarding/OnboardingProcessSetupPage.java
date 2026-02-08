package pageObjects.HRMS.Onboarding;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnboardingProcessSetupPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "(//input[contains(@id,'Name')])[2]")
    private WebElement name;

    @FindBy(xpath = "//input[contains(@id,'ArrivalTime')]")
    private WebElement arrivalTime;

    @FindBy(xpath = "//input[contains(@id,'WorkLocationId')]")
    private WebElement workLocation;

    @FindBy(xpath = "//input[contains(@id,'ContactEmployeeId')]")
    private WebElement contactPerson;

    @FindBy(xpath = "//div[@aria-label='Editor content']")
    private WebElement editorContent;

    @FindBy(xpath = "//div[@aria-label='Data grid with 0 rows and 2 columns']//i[contains(@class,'dx-icon-edit-button-addrow')]")
    private WebElement addIcon;

    @FindBy(xpath = "//input[contains(@id,'QuestionName')]")
    private WebElement questionName;

    @FindBy(xpath = "//input[contains(@id,'QuestionFormatType')]")
    private WebElement type;

    @FindBy(xpath = "//span[@class='dx-button-text' and normalize-space()='Save']")
    private WebElement save;

    //endregion

    //region Action Methods
    public void provideName(String value)
    {
        clearAndProvide1(name, value);
    }

    public void provideArrivalTime(String value)
    {
        clearAndProvide1(arrivalTime, value);
    }

    public void selectWorkLocation(String location)
    {
        clickOnElement1(workLocation);
        selectDropdownOption(location);
    }
    public void selectContactPerson(String cperson)
    {
        clickOnElement1(contactPerson);
        selectDropdownOption(cperson);
    }
    public void welcomeNote(String value)
    {
        clearAndProvide1(editorContent, value);
    }

    //endregion
}