package pageObjects.HRMS.SuccessionPlanning.Setups;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReadinessPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[text()='Readiness']")
    private WebElement readiness;

    @FindBy(id = "Readiness.Name_I")
    private WebElement name;

    @FindBy(id = "Readiness.FromPercentage_I")
    private WebElement fromPercentage;

    @FindBy(id = "Readiness.ToPercentage_I")
    private WebElement toPercentage;
    //endregion

    //region Action Methods
    public void clickReadiness()
    {
        clickOnElement1(readiness);
    }
    public void provideName(String readinessName)
    {
        clearAndProvide1(name, readinessName);
    }
    public void provideFromPercentage(String fromPercent)
    {
        clearAndProvide1(fromPercentage, fromPercent);
    }
    public void provideToPercentage(String toPercent)
    {
        clearAndProvide1(toPercentage, toPercent);
    }
    //endregion
}