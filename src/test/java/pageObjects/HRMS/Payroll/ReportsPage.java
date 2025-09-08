package pageObjects.HRMS.Payroll;

import org.apache.poi.ss.formula.functions.FinanceFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.WaitUtils;

public class ReportsPage extends BasePage
{

    @FindBy(xpath = "(//input[@class='dx-texteditor-input'])[2]")
    WebElement filtercolumn;

    //    @FindBy(xpath = "//td[normalize-space()='Ticket Balance']")
//    WebElement resultcolumn;
    //(//tbody//tr)[6]
    @FindBy(xpath = "(//td[@role='gridcell'])[5]")
    WebElement resultcolumn;

    @FindBy(xpath = "//img[@id='MainMenu_DXI2_Img']")
    WebElement preview;

    @FindBy(xpath = "//input[contains(@id,'EmployeeId')]")
    WebElement empdd;

    @FindBy(xpath = "//span[@class='dx-button-text']")
    WebElement submit;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/main[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[6]/div[1]")
    WebElement availableTicket;

    @FindBy(xpath = "//div[contains(text(),'Available Days')]//following::td[11]")
    private WebElement availableIndemnity;

    @FindBy(xpath = "//input[contains(@id,'AsOnDate')]")
    private WebElement asOnDatefield;

    @FindBy(xpath = "//input[contains(@id,'GratuityId')]")
    private WebElement indemnitydd;

    public void openReport(String value)
    {
        //filtercolumn.sendKeys(value);
        clearAndProvide1(filtercolumn, value);
        waitTS(2);
        resultcolumn.click();
        waitTS(2);
        preview.click();
        WaitUtils.waitTS(2);
        switchTab();
        WaitUtils.waitTS(2);
    }

    public double getTicketBalance(String emp)
    {
        provideAndEnter(empdd, emp);
        //submit.click();
        String bal = availableTicket.getText();
        double expBal = Double.parseDouble(bal);
        return expBal;
    }

    public double getIndemnityBalance(String emp, String asOnDate, String indemnityType)
    {
        clearAndProvide1(asOnDatefield, asOnDate);
        provideAndEnter(indemnitydd, indemnityType);
        //clearAndProvide1(empdd, emp);
        //submit.click();
        String bal = availableIndemnity.getText();
        double expBal = Double.parseDouble(bal);
        return expBal;
    }
}