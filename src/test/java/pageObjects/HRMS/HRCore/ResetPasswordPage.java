package pageObjects.HRMS.HRCore;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class ResetPasswordPage extends BasePage
{

    @FindBy(xpath = "//input[@id='NewPassword_I']")
    WebElement newPassword;

    @FindBy(xpath = "//input[@id='ReConfirmPassword_I']")
    WebElement confirmPassword;

    @FindBy(xpath = "//img[@alt='Close']")
    WebElement close;

    public void resetPwd(String pwd) throws InterruptedException
    {
        DriverFactory.getDriver().switchTo().frame("PopupWindow_CIF-1");
        Thread.sleep(2000);
        newPassword.sendKeys(pwd);
        confirmPassword.sendKeys(pwd);
        clickOnSave();
        DriverFactory.getDriver().switchTo().defaultContent();
        close.click();
    }
}