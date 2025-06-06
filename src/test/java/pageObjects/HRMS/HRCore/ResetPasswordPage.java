package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class ResetPasswordPage extends BasePage
{

	public ResetPasswordPage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(xpath = "//input[@id='NewPassword_I']")
	WebElement newPassword;

	@FindBy(xpath = "//input[@id='ReConfirmPassword_I']")
	WebElement confirmPassword;

	@FindBy(xpath = "//img[@alt='Close']")
	WebElement close;

	public void resetPwd(String pwd) throws InterruptedException
	{
		driver.switchTo().frame("PopupWindow_CIF-1");
		Thread.sleep(2000);
		newPassword.sendKeys(pwd);
		confirmPassword.sendKeys(pwd);
		clickOnSave();
		driver.switchTo().defaultContent();
		close.click();
	}

}
