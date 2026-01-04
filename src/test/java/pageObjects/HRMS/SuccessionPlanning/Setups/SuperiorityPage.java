package pageObjects.HRMS.SuccessionPlanning.Setups;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuperiorityPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[normalize-space()='Superiority']")
    private WebElement superiority;

    @FindBy(id = "Superiority.Name_I")
    private WebElement name;

    @FindBy(id = "Superiority.FromPercentage_I")
    private WebElement fromPercentage;

    @FindBy(id = "Superiority.ToPercentage_I")
    private WebElement toPercentage;
    //endregion

    //region Action Methods
    public void clickSuperiority()
    {
        clickOnElement1(superiority);
    }
    public void provideName(String superiorityName)
    {
        clearAndProvide1(name, superiorityName);
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