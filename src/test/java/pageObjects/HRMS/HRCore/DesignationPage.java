package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class DesignationPage extends BasePage
{

    public DesignationPage(WebDriver driver)
    {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    @FindBy(css = "#MainMenu_DXI0_Img")
    private WebElement newBtnCss;

    @FindBy(xpath = "//span[normalize-space()='New']")
    private WebElement newBtnXpath;

    @FindBy(name = "Code")
    private WebElement code;

    @FindBy(name = "Name")
    private WebElement desgName;

    @FindBy(xpath = "//input[contains(@id,'GradeId')]")
    private WebElement clickGrade;

    @FindBy(xpath = "//div[contains(text(),'Contributor')]")
    private WebElement selectGrade;

    @FindBy(xpath = "//div[@aria-label='Editor content']")
    private WebElement jobDescription;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    private WebElement save;

    @FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
    private WebElement filterCell;

    @FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]/a[1]")
    private WebElement result;

    public void clickNewButton()
    {
        clickOnNew();
    }

    public void setDesignationCode()
    {
        code.sendKeys(randomNumber());
    }

    public void setDesignation(String value)
    {

        desgName.sendKeys(value);
    }

    public void clickGrade()
    {
        clickGrade.click();
    }

    public void selectGrade()
    {
        selectGrade.click();
    }

    public void setJobDescription()
    {

        jobDescription.sendKeys(randomString());
    }

    public void clickSaveBack()
    {
        clickSaveAndBack();
    }
}