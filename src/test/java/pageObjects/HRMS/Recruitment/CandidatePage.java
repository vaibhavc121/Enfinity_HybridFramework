package pageObjects.HRMS.Recruitment;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CandidatePage extends BasePage
{
    public CandidatePage(WebDriver driver)
    {
        super(driver);
    }

    //region Locators
    @FindBy(xpath="(//input[contains(@id,'Name')])[1]") private WebElement name;
    @FindBy(xpath="//input[contains(@id,'Email']") private WebElement email;
    @FindBy(xpath="//input[contains(@id,'MobileNumber']") private WebElement mobileNumber;
    @FindBy(xpath="//input[contains(@id,'DateOfBirth']") private WebElement dateOfBirth;
    //endregion

    //region Action Methods
    public void clickNew()
    {
        clickOnNew();
    }

    public void provideName(String nameValue)
    {
        clearAndProvide1(name, nameValue);
    }
    public void provideEmail(String emailValue)
    {
        clearAndProvide1(email, emailValue);
    }
    public void provideMobileNumber(String mobileNumberValue)
    {
        clearAndProvide1(mobileNumber, mobileNumberValue);
    }
    public void provideDateOfBirth(String dateOfBirthValue)
    {
        clearAndProvide1(dateOfBirth, dateOfBirthValue);
    }
    public void clickSave()
    {
        clickOnSave();
    }

    //endregion
}