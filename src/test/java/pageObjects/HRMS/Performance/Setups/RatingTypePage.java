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
    ;

    @FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'])[1]")
    private WebElement label;

    @FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'])[2]")
    private WebElement score;

    @FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'])[3]")
    private WebElement description;

    @FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'])[4]")
    private WebElement distribution;

    //endregion

    //region Action Methods
    public void clickRatingType()
    {
        clickOnElement1(ratingTypeLink);
    }
    public void provideName(String rname)
    {
        clearAndProvide1(name, rname);
    }
    public void selectRatingType(String rratingType)
    {
        clickOnElement1(ratingType);
        selectDropdownValueOffice365(rratingType);
    }
    public void provideLabel(String value) throws InterruptedException
    {
        clearAndProvide2(label, value);
    }
    public void provideScore(String value) throws InterruptedException
    {
        clearAndProvide2(score, value);
    }
    public void provideDesc(String value) throws InterruptedException
    {
        clearAndProvide2(description, value);
    }
    public void provideDistribution(String value) throws InterruptedException
    {
        clearAndProvide2(distribution, value);
    }
    //endregion
}