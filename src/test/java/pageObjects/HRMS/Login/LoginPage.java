package pageObjects.HRMS.Login;

import org.openqa.selenium.By;
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

   //region Locators
   @FindBy(name = "Username")
   WebElement username;

    @FindBy(name = "Password")
    WebElement password;

    @FindBy(className = "login-btn")
    WebElement signIn;
   //endregion

    //region Action Methods
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

    public void login(String uname, String pwd)
    {
        WebElement usernameField = driver.findElement(By.name("Username"));
        WebElement passwordField = driver.findElement(By.name("Password"));
        WebElement loginButton = driver.findElement(By.className("login-btn"));

        usernameField.sendKeys(uname);
        BaseTest.log("provided username: " + uname);

        passwordField.sendKeys(pwd);
        BaseTest.log("provided password: " + pwd);

        loginButton.click();
        BaseTest.log("clicked on login button");
    }
    //endregion


}