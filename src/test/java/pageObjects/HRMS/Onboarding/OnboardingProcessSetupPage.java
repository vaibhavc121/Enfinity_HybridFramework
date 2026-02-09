package pageObjects.HRMS.Onboarding;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JavaScriptUtils;

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

    @FindBy(xpath = "//input[contains(@id,'WelcomeUrl')]")
    private WebElement url;

    @FindBy(xpath = "//textarea[contains(@id,'OtherInstructions')]")
    private WebElement otherInstructions;

    @FindBy(xpath = "//input[contains(@id,'EmployeeIntroEmailTemplateId')]")
    private WebElement empEntroEmailTemplate;

    @FindBy(xpath = "//input[contains(@id,'EmployeeIntroEmailParticipantIds')]")
    private WebElement emailParticipants;

    @FindBy(xpath = "//textarea[contains(@id,'OtherEmailRecipient')]")
    private WebElement emailRecipient;

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
        provideAndEnter(contactPerson, cperson);
    }
    public void provideWelcomeNote(String value)
    {
        clearAndProvide1(editorContent, value);
    }
    public void provideURL()
    {
        clearAndProvide1(url, "www.google.com");
    }
    public void provideOtherInstructions(String value)
    {
        clearAndProvide1(otherInstructions, value);
    }
    public void selectEmpIntroEmailTemplate(String template)
    {
        provideAndEnter(empEntroEmailTemplate, template);
    }
    public void scrollToEmpIntroEmailTemplate()
    {
        JavaScriptUtils.scrollIntoView(BaseTest.getDriver(), empEntroEmailTemplate);
    }

    public void selectEmailParticipants(String participant)
    {
        provideAndEnter(emailParticipants, participant);
    }
    public void provideEmailRecipient(String value)
    {
        clearAndProvide1(emailRecipient, value);
    }

    //endregion
}