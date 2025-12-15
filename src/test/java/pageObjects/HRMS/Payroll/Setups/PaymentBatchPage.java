package pageObjects.HRMS.Payroll.Setups;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentBatchPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[text()='Payment Batch']")
    private WebElement paymentBatch;

    @FindBy(id = "PayrollPaymentBatch.Name_I")
    private WebElement name;

    @FindBy(id = "PayrollPaymentBatch.Type_I")
    private WebElement paymentBatchType;
    //endregion

    //region Action Methods
    public void clickPaymentBatch()
    {
        clickOnElement1(paymentBatch);
    }

    public void provideName(String value)
    {
        clearAndProvide1(name, value);
    }
    
    public void selectPaymentBatchType(String value)
    {
        clickOnElement1(paymentBatchType);
        selectDropdownValueOffice365(value);
    }
    //endregion
}