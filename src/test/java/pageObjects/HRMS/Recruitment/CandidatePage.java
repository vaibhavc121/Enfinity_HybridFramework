package pageObjects.HRMS.Recruitment;

import base.BasePage;
import base.BaseTest;
import factory.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JavaScriptUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class CandidatePage extends BasePage
{

    //region Locators

    //region Personal Information
    @FindBy(xpath = "(//input[contains(@id,'Name')])[1]")
    private WebElement name;
    @FindBy(xpath = "//input[contains(@id,'Email')]")
    private WebElement email;
    @FindBy(xpath = "//input[contains(@id,'MobileNumber')]")
    private WebElement mobileNumber;
    @FindBy(xpath = "//input[contains(@id,'DateOfBirth')]")
    private WebElement dateOfBirth;
    @FindBy(xpath = "//span[@class='bCardHover']")
    private WebElement candidateName;
    @FindBy(xpath = "//input[contains(@id,'Gender')]")
    private WebElement gender;
    @FindBy(xpath = "//input[contains(@id,'MaritalStatus')]")
    private WebElement maritalStatus;
    @FindBy(xpath = "//div[@class='dx-form-group-content']//div[@class='dx-first-col dx-last-col dx-field-item dx-col-0 dx-field-item-optional dx-field-item-has-group']//div[@class='dx-form-group-content']//span[@class='dx-checkbox-icon']")
    private WebElement checkbox1;
    @FindBy(xpath = "(//span[@class='dx-button-text'][contains(text(),'Browse…')])[1]")
    WebElement pictureBrowse;
    @FindBy(xpath = "(//span[@class='dx-button-text'][contains(text(),'Browse…')])[2]")
    WebElement cvBrowse;
    //endregion

    //region Address Information
    @FindBy(xpath = "//input[contains(@id,'City')]")
    private WebElement city;
    @FindBy(xpath = "//input[contains(@id,'State')]")
    private WebElement state;
    @FindBy(xpath = "//input[contains(@id,'CountryId')]")
    private WebElement country;
    @FindBy(xpath = "//input[contains(@id,'PostalCode')]")
    private WebElement postalCode;
    //endregion

    //region Professional Information
    @FindBy(xpath = "//input[contains(@id,'WorkExperienceInYear')]")
    private WebElement workExperienceInYear;
    @FindBy(xpath = "//input[contains(@id,'CurrentJobTitle')]")
    private WebElement currentJobTitle;
    @FindBy(xpath = "//input[contains(@id,'CurrentEmployer')]")
    private WebElement currentEmployer;
    @FindBy(xpath = "//input[contains(@id,'SkillIds')]")
    private WebElement skills;
    @FindBy(xpath = "//input[contains(@id,'CurrentSalary')]")
    private WebElement currentSalary;
    @FindBy(xpath = "//input[contains(@id,'ExpectedSalary')]")
    private WebElement expectedSalary;
    @FindBy(xpath = "//input[contains(@id,'NoticePeriodInDays')]")
    private WebElement noticePeriodInDays;
    @FindBy(xpath = "(//span[@class='dx-checkbox-icon'])[2]")
    private WebElement checkbox2;
    //endregion

    //region Document Information
    @FindBy(xpath = "//input[contains(@id,'PassportNumber')]")
    private WebElement passportNumber;
    @FindBy(xpath = "//input[contains(@id,'PassportIssueDate')]")
    private WebElement passportIssueDate;
    @FindBy(xpath = "//input[contains(@id,'PassportExpiryDate')]")
    private WebElement passportExpiryDate;
    @FindBy(xpath = "//input[contains(@id,'VisaType')]")
    private WebElement visaType;
    @FindBy(xpath = "//input[contains(@id,'CivilIdNumber')]")
    private WebElement civilIdNumber;
    //endregion

    //region Qualification Details

    //endregion

    //region Experience Details

    //endregion

    //endregion

    //region Action Methods
    public void clickNew()
    {
        clickOnNew();
    }

    //region Personal Information
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
    public void selectGender(String genderValue)
    {
        provideAndEnter(gender, genderValue);
    }
    public void selectMaritalStatus(String maritalStatusValue)
    {
        provideAndEnter(maritalStatus, maritalStatusValue);
    }
    public void clickDrivingLicense()
    {
        waitForElement(checkbox1).click();
    }

    public void clickPictureBrowse()
    {
        clickOnElement1(pictureBrowse);
    }

    public void clickCVBrowse()
    {
        clickOnElement1(cvBrowse);
    }
    //endregion

    //region Address Information
    public void provideCity(String value)
    {
        clearAndProvide1(city, value);
    }
    public void provideState(String value)
    {
        clearAndProvide1(state, value);
    }
    public void provideCountry(String value)
    {
        provideAndEnter(country, value);
    }
    public void providePostalCode(String value)
    {
        clearAndProvide1(postalCode, value);
    }

    //endregion

    //region Professional Information
    public void scrollDown()
    {
        JavaScriptUtils.scrollIntoView(DriverFactory.getDriver(), workExperienceInYear);
    }
    public void provideWorkExpInYears(String value)
    {
        clearAndProvide1(workExperienceInYear, value);
    }
    public void provideCurrentJobTitle(String value)
    {
        clearAndProvide1(currentJobTitle, value);
    }
    public void provideCurrentEmployer(String value)
    {
        clearAndProvide1(currentEmployer, value);
    }
    public void provideSkills(String value)
    {
        provideAndEnter(skills, value);
    }
    public void provideCurrentSalary(String value)
    {
        clearAndProvide1(currentSalary, value);
    }
    public void provideExpectedSalary(String value)
    {
        clearAndProvide1(expectedSalary, value);
    }
    public void provideNoticePeriodInDays(String value)
    {
        clearAndProvide1(noticePeriodInDays, value);
    }
    public void clickOverseas()
    {
        waitForElement(checkbox2).click();
    }

    //endregion

    //region Document Information
    public void providePassportNumber(String value)
    {
        clearAndProvide1(passportNumber, value);
    }
    public void providePassportIssueDate(String value)
    {
        clearAndProvide1(passportIssueDate, value);
    }
    public void providePassportExpiryDate(String value)
    {
        clearAndProvide1(passportExpiryDate, value);
    }
    public void provideVisaType(String value)
    {
        clearAndProvide1(visaType, value);
    }
    public void provideCivilIdNumber(String value)
    {
        clearAndProvide1(civilIdNumber, value);
    }
    //endregion

    public void clickSave()
    {
        clickOnSave();
    }
    public String getCandidateName()
    {
        String candidateNm = candidateName.getText();
        return candidateNm;
    }

    //endregion
}