package pageObjects.HRMS.Performance.Setups;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RatingTypePage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[text()='Rating Type']")
    private WebElement ratingTypeLink;

    @FindBy(xpath = "//input[@id='RatingType.Name_I']")
    private WebElement name;

    @FindBy(id = "RatingType.RatingType_I")
    private WebElement ratingType;
    //endregion

    //region Action Methods

    //endregion
}