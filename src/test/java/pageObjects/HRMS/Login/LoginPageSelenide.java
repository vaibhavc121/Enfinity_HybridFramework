package pageObjects.HRMS.Login;

import base.SelenideBasePage;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class LoginPageSelenide extends SelenideBasePage
{
    private SelenideElement username = $("[name='Username']");
    private SelenideElement password = $("[name='Password']");
    private SelenideElement signIn = $(".login-btn");


    public static void highlightElement(SelenideElement element, boolean highlight) {
        String color = highlight ? "2px solid red" : "none";
        executeJavaScript("arguments[0].style.border='" + color + "'", element);
    }

    public void setUsername(String uname) {
        highlightElement(username, true);
        username.setValue(uname);
        highlightElement(username, false);
    }

    public void setPwd(String pwd) {
        highlightElement(password, true);
        password.setValue(pwd);
        highlightElement(password, false);
    }

    public void clkSignin() {
        highlightElement(signIn, true);
        signIn.click();
    }


}