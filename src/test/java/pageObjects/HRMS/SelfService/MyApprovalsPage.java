package pageObjects.HRMS.SelfService;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyApprovalsPage extends BasePage
{
    public MyApprovalsPage(WebDriver driver)
    {
        super(driver);
    }

    //region Locators
    @FindBy(xpath = "(//span[@class='dx-button-text'][normalize-space()='Approve'])[1]")
    private WebElement approve;

    //endregion

    //region Action Methods
    public void bulkApproveRequest(String empName)
    {
        for (int i = 1; i <= 2; i++)
        {
            String currentName = waitForElement1(
                    By.xpath("(//div[contains(text(),'" + empName + "')])[" + i + "]")
            ).getText();
            BaseTest.log("Extracted name of " + i + " employee: " + currentName);

            if (currentName.contains(empName))
            {
                waitForElement1(
                        By.xpath("//tbody/tr[" + i + "]//span[@class='dx-checkbox-icon']")
                ).click();
                BaseTest.log("Clicked on checkbox for employee: " + currentName);
            }
        }
        waitForElement(approve).click();
        waitTS(3);
        BaseTest.log("Clicked on Approve button");
        BasePage.pressEnter();
        BaseTest.log("pressed Enter to confirm approval");
    }

    public boolean isApproveButtonDisplay()
    {
        boolean status;
        try
        {
            status = waitForElement1(By.xpath("(//span[@class='dx-button-text'][normalize-space()='Approve'])[2]")).isDisplayed();
        } catch (Exception e)
        {
            status = false;
        }

        if (!status)
        {
            BaseTest.log("Approve button is not displayed, indicating that the transactions are bulk approved successfully.");
            return true;
        } else
        {
            BaseTest.log("Approve button is still displayed, indicating that the bulk approval failed.");
            return false;
        }
    }

    //endregion
}