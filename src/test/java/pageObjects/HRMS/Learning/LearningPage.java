package pageObjects.HRMS.Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LearningPage extends BasePage
{

    @FindBy(xpath = "//span[normalize-space()='Learning']")
    static WebElement learning;

    @FindBy(xpath = "//span[normalize-space()='My Course']//preceding::span[@class='dx-vam'][normalize-space()='Course']")
    WebElement course;

    public static void clickLearning()
    {
        BasePage.clickMenuIcon();
        learning.click();
    }

    public void clickCourse()
    {
        course.click();
    }
}