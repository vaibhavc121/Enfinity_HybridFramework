package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class LoginPage extends BasePage
{

	public LoginPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	BaseClass bc = new BaseClass();

	@FindBy(xpath = "/html[1]/body[1]/div[1]/section[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement username;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/section[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement password;

	@FindBy(xpath = "//div[@aria-label='Sign In']//div[@class='dx-button-content']")
	WebElement signIn;

	// Locate, highlight, enter data, and remove highlight for "Username" field
	public void setUsername(String uname)
	{
		bc.highlightElement(driver, username, true);
		username.sendKeys(uname);
		bc.highlightElement(driver, username, false); // Remove highlight
	}

	public void setPwd(String pwd)
	{
		bc.highlightElement(driver, password, true);
		password.sendKeys(pwd);
		bc.highlightElement(driver, password, false); // Remove highlight
	}

	public void clkSignin()
	{
		bc.highlightElement(driver, signIn, true);
		signIn.click();
		// bc.highlightElement(driver, signIn, false); // Remove highlight
	}
}
