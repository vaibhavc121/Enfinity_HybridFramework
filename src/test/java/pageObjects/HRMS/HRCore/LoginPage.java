package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.BaseTest;

public class LoginPage extends BasePage
{

	public LoginPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	BaseTest bc = new BaseTest();

	@FindBy(xpath = "/html[1]/body[1]/div[1]/section[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement username;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/section[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement password;

	@FindBy(xpath = "//div[@aria-label='Sign In']//div[@class='dx-button-content']")
	WebElement signIn;

	// Locate, highlight, enter data, and remove highlight for "Username" field
	public void setUsername(String uname)
	{
		highlightElement(driver, username, true);
		username.sendKeys(uname);
		highlightElement(driver, username, false); // Remove highlight
	}

	public void setPwd(String pwd)
	{
		highlightElement(driver, password, true);
		password.sendKeys(pwd);
		highlightElement(driver, password, false); // Remove highlight
	}

	public void clkSignin()
	{
		highlightElement(driver, signIn, true);
		signIn.click();
		// bc.highlightElement(driver, signIn, false); // Remove highlight
	}
}
