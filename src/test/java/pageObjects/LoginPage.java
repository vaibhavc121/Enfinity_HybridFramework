package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{

	public LoginPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name = "Username")
	WebElement username;

	@FindBy(name = "Password")
	WebElement password;

	@FindBy(xpath = "//div[@aria-label='Sign In']//div[@class='dx-button-content']")
	WebElement signIn;

	public void setUsername(String uname)
	{
		username.sendKeys(uname);
	}

	public void setPwd(String pwd)
	{
		password.sendKeys(pwd);
	}

	public void clkSignin()
	{
		signIn.click();
	}
}
