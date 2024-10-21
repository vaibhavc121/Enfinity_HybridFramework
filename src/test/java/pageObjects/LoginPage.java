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

	@FindBy(xpath = "/html[1]/body[1]/div[1]/section[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement username;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/section[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
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
