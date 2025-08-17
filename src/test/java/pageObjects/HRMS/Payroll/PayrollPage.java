package pageObjects.HRMS.Payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.JavaScriptUtils;

public class PayrollPage extends BasePage
{

    public PayrollPage(WebDriver driver)
    {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    @FindBy(xpath = "//i[@class='payroll-module-single-color-icon']")
    static WebElement payroll;

    @FindBy(xpath = "//div[normalize-space()='Transactions']")
    WebElement transactions;

    @FindBy(xpath = "//span[normalize-space()='Reports']")
    WebElement reports;

    public static void clkPayroll()
    {
        // waitForElement(payroll);
        BasePage.clickMenuIcon();
        JavaScriptUtils.clickElementByJavaScript(driver, payroll);
        waitTS(1);
    }

    public void clkTxn()
    {
        JavaScriptUtils.clickElementByJavaScript(driver, transactions);
    }

    public void clickReports()
    {
        reports.click();
    }
}