package pageObjects.HRMS.Payroll.Setups;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinancialIntegrationGroupsPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[text()='Financial Integration Group']")
    private WebElement financialIntegrationGroup;
    //endregion

    //region Action Methods

    //endregion
}