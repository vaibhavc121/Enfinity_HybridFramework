package base;

import java.awt.Robot;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import com.github.javafaker.Faker;

import pageObjects.HRMS.HRCore.EmployeePage;
import pageObjects.HRMS.HRCore.LoginPage;
import utilities.BrowserUtils;

public class BasePage
{
    public static WebDriver driver;
    Robot robot;

    //region Constructor
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //endregion

    //region For fake data generation
    Faker faker = new Faker();
    //endregion

    //region For Random data generation
    public String randomString()
    {
        String generatedString = RandomStringUtils.randomAlphabetic(6);
        return generatedString;
    }

    public String randomNumber()
    {
        String generatedNumber = RandomStringUtils.randomNumeric(4);
        return generatedNumber;
    }

    public String randomAlphaNumeric()
    {
        String alphanumeric = RandomStringUtils.randomAlphanumeric(10);
        return alphanumeric;
    }

    public String randomEmail()
    {
        String generatedString = RandomStringUtils.randomAlphabetic(6);
        String generatedNumber = RandomStringUtils.randomNumeric(3);
        return generatedString + generatedNumber + "@" + "gmail.com";
    }

    public String randomMblNum()
    {
        String generatedNumber = RandomStringUtils.randomNumeric(10);
        return generatedNumber;
    }
    //	public String randomAlphaNumeric()
    //	{
    //		String generatedString = RandomStringUtils.randomAlphabetic(3);
    //		String generatedNumber = RandomStringUtils.randomNumeric(3);
    //		return (generatedString + "@" + generatedNumer);
    //	}
    //endregion

    //region Listing Filters (Relative xpath)
    public static void filterByIndex(int columnIndex, String value)
    {
        // I expect the index to change dynamically
        String xpath = "(//input[@class='dx-texteditor-input'])[" + columnIndex + "]";
        waitForElement1(By.xpath(xpath)).clear();
        BaseTest.log("value cleared in filter box");
        waitForElement1(By.xpath(xpath)).sendKeys(value);
        BaseTest.log("provided filter value");
    }

    // other approach
    public static void filterValue(int columnIndex, String value)
    {
        String xpath = "(//tbody//tr)[11]//td[" + columnIndex + "]";
        waitForElement1(By.xpath(xpath)).sendKeys(value);
    }

    public static void filterDateByIndex(int columnIndex, String value)
    {
        String xpath = "(//input[@class='dx-texteditor-input'])[" + columnIndex + "]";
        waitForElement1(By.xpath(xpath)).clear();
        waitForElement1(By.xpath(xpath)).sendKeys(value);
        pressEnter();
    }

    public static void filterAndOpenTransaction(int filterIndex, int resultIndex, String expValue, String mode)
    {
        filterByIndex(filterIndex, expValue);
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        String actValue = resultValue(resultIndex);
        if (actValue.contains(expValue))
        {
            selectRow();
            if (mode.contains("view"))
            {
                clickOnView();
            } else
            {
                clickOnEdit();
            }
        } else
        {
            throw new RuntimeException("VRC- No matching record found");
        }
    }
    //endregion

    //region Listing result (Relative xpath)
    public static void selectRow()
    {
        // driver.findElement(By.xpath("(//tr)[12]//td[2]")).click();
        waitForElement1(By.xpath("(//tr)[12]//td[2]")).click();
    }

    public static String resultValue(int columnIndex)
    {
        // String result =
        // driver.findElement(By.xpath("(//tbody//tr)[12]//td[2]")).getText();
        // return result;
        String xpath = "(//tbody//tr)[12]//td[" + columnIndex + "]";
        try
        {
            String result = driver.findElement(By.xpath(xpath)).getText();
            return result;
        } catch (Exception e)
        {
            return "No matching record found";
        }
        //		String xpath = "(//tbody//tr)[12]//td[" + columnIndex + "]";
        //		String result = driver.findElement(By.xpath(xpath)).getText();
        //		return result;
    }
    //endregion

    //region Transaction form related Action Methods
    public static void clickOnHamburgerMenu()
    {
        waitForElement1(By.id("leftAreaMenu_DXI0_")).click();
    }

    public static void clickOnOk()
    {
        waitForElement1(By.xpath("//span[normalize-space()='OK']")).click();
    }

    public static void clickOnSave()
    {
        waitForElement1(By.xpath("//span[normalize-space()='Save']")).click();
    }

    public void clickSaveSubmit()
    {
        waitForElement1(By.xpath("//span[text()='Save and Submit']")).click();
    }

    public static void clickSaveAndBack()
    {
        waitForElement1(By.xpath("//span[normalize-space()='Save']")).click();
        driver.navigate().back();
    }

    public static void clickOnView()
    {
        waitForElement1(By.xpath("//span[normalize-space()='View']")).click();
    }

    public static void clickOnApprove()
    {
        waitForElement1(By.xpath("//span[normalize-space()='Approve']")).click();
    }

    public static void clickOnViewApproveBack()
    {
        waitForElement1(By.xpath("//span[normalize-space()='View']")).click();
        waitTS(1);
        waitForElement1(By.xpath("//span[normalize-space()='Approve']")).click();
        waitTS(1);
        driver.navigate().back();
    }

    public static void clickReject()
    {
        waitForElement1(By.xpath("//span[normalize-space()='Reject']")).click();
    }

    public static void clickRevise()
    {
        waitForElement1(By.xpath("//span[normalize-space()='Revise']")).click();
    }

    public static void clickAttachFile()
    {
        waitForElement1(By.xpath("//span[normalize-space()='Attach Files']")).click();
    }

    public static void clickViewAndBack()
    {
        waitForElement1(By.xpath("//span[normalize-space()='View']")).click();
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        clickOnEdit();
        clickOnView();
        driver.navigate().back();
    }

    public static void clickOnEdit()
    {
        waitForElement1(By.xpath("//span[normalize-space()='Edit']")).click();
    }

    public static void clickApproveAndBack()
    {
        waitForElement1(By.xpath("//span[normalize-space()='Approve']")).click();
        driver.navigate().back();
    }

    public static void clickOnNew()
    {
        waitForElement1(By.xpath("//span[normalize-space()='New']")).click();
    }

    public static void selectDropdownOption(String expectedValue)
    {
        List<WebElement> dropdownList = driver.findElements(By.xpath("//div[@class='dx-item dx-list-item']"));
        for (WebElement dropdownElement : dropdownList)
        {
            String actualValue = dropdownElement.getText();
            if (actualValue.contains(expectedValue))
            {
                dropdownElement.click();
                break;
            }
        }
    }

    public static void selectDropdownValue(String value)
    {
        while (true)
        {
            List<WebElement> valuesList = driver.findElements(By.xpath("//div[@class='grid-row-template']"));
            for (WebElement valueElement : valuesList)
            {
                String actualValue = valueElement.getText();
                if (actualValue.contains(value))
                {
                    valueElement.click();
                    return;
                }
            }
            driver.findElement(By.xpath("//i[@class='dx-icon dx-icon-next-icon']")).click();
            try
            {
                Thread.sleep(3000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void selectDropdownValueOffice365(String value)
    {
        List<WebElement> valuesList = driver.findElements(By.xpath("//tr[@class='dxeListBoxItemRow_Office365']"));
        for (WebElement valueElement : valuesList)
        {
            String actualValue = valueElement.getText();
            if (actualValue.contains(value))
            {
                valueElement.click();
                break;
            }
        }
    }

    public static void clearAndProvide(By locator, String value)
    {
        WebElement element = waitForElement1(locator);
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public static void clearAndProvide1(WebElement locator, String value)
    {
        WebElement element = waitForElement(locator);
        element.click();
        Actions actions = new Actions(driver);
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        element.sendKeys(value);
    }

    public static void clearAndProvide2(WebElement locator, String value) throws InterruptedException
    {
        WebElement element = waitForElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().doubleClick().sendKeys(value).build().perform();
        Thread.sleep(1000);
    }

    public static void provideAndEnter(WebElement locator, String value)
    {
        WebElement element = waitForElement(locator);
        element.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        element.sendKeys(value);
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        element.sendKeys(Keys.ENTER);
    }

    public static void provideValue(WebElement locator, String value)
    {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = waitForElement(locator);
        jsExecutor.executeScript("arguments[0].value='" + value + "';", element);
    }

    public void provideDescription(String value)
    {
        By description = By.xpath("//textarea[contains(@id,'Description')]");
        clearAndProvide(description, value);
    }

    public static void globalSearch(String value)
    {
        WebElement globalSearchInput = waitForElement1(By.id("GlobalSearch"));
        globalSearchInput.click();
        WebElement comboBoxInput = waitForElement1(By.xpath("//input[@role='combobox']"));
        comboBoxInput.sendKeys(value);
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        selectDropdownOption(value);
    }

    public static void scrollDownWebPageSample()
    {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = waitForElement1(By.xpath("//input[contains(@id,'OldContractSalary')]"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollDownWebPage(WebElement locator)
    {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = waitForElement(locator);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void clickOnNewLine()
    {
        waitForElement1(By.xpath("//i[@class='dx-icon dx-icon-new-icon']")).click();
    }

    public static void hoverAndClick(WebElement locator, WebElement locator1)
    {
        WebElement elementToHover = waitForElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        waitForElement(locator1).click();
    }

    public static void deleteTxn(int index, String value)
    {
        filterByIndex(index, value);
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        try
        {
            waitForElement1(By.xpath("(//tr)[12]//td[2]")).click();
            BaseTest.log("row selected");
        } catch (Exception e)
        {
            Assert.fail("Vaibhav- There is no active records..");
            System.exit(1);
        }
        try
        {
            clickOnView();
            BaseTest.log("clickOnView");
        } catch (Exception e)
        {
            clickOnEdit();
            BaseTest.log("clickOnEdit");
        }
        try
        {
            Thread.sleep(5000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        waitForElement1(By.xpath("(//img[@class='dxWeb_mAdaptiveMenu_Office365 dxm-pImage'])[8]")).click();
        BaseTest.log("clciked on setting");
        waitForElement1(By.xpath("//span[normalize-space()='Delete']")).click();
        BaseTest.log("clicked on delete");
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        pressKey("enter");
        BaseTest.log("enter pressed");
        driver.navigate().back();
        BaseTest.log("went back to listing");
    }

    public static void performAction(int index, String value, String action)
    {
        filterByIndex(index, value);
        waitTS(2);
        try
        {
            // Need to select row to click on view
            waitForElement1(By.xpath("(//tr)[12]//td[2]")).click();
        } catch (Exception e)
        {
            Assert.fail("Vaibhav - There are no active records.");
            System.exit(1); // Exit application
        }
        try
        {
            clickOnView();
        } catch (Exception e)
        {
            clickOnEdit();
        }
        waitTS(5);
        // Click on menu image icon
        waitForElement1(By.xpath("(//img[@class='dxWeb_mAdaptiveMenu_Office365 dxm-pImage'])[8]")).click();
        // Click the action (e.g., Delete, View, Edit)
        waitForElement1(By.xpath("//span[normalize-space()='" + action + "']")).click();
        waitTS(1);
        pressKey("enter");
        // Delete the transaction again (possibly confirm step)
        waitForElement1(By.xpath("(//img[@class='dxWeb_mAdaptiveMenu_Office365 dxm-pImage'])[8]")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Delete']")).click();
        waitTS(1);
        pressKey("enter");
        BrowserUtils.navigateBack(driver);
    }

    public static void deleteHrCoreTxn(int ColumnIndex, String value)
    {
        filterByIndex(ColumnIndex, value);
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        try
        {
            if (ColumnIndex == 2)
            {
                waitForElement1(By.xpath("(//tr)[12]//td[1]")).click();
            } else
            {
                waitForElement1(By.xpath("(//tr)[12]//td[2]")).click();
            }
        } catch (Exception e)
        {
            Assert.fail("Vaibhav- There is no active records..");
            System.exit(1);
        }
        try
        {
            clickOnView();
        } catch (Exception e)
        {
            clickOnEdit();
        }
        try
        {
            Thread.sleep(5000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        waitForElement1(By.xpath("(//img[@class='dxWeb_mAdaptiveMenu_Office365 dxm-pImage'])[8]")).click();
        waitForElement1(By.xpath("//span[normalize-space()='Delete']")).click();
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        pressKey("enter");
        driver.navigate().back();
    }

    public static void clickOnContextMenu()
    {
        waitForElement1(By.id("MainMenu_DXI11_P")).click();
    }
    //endregion

    //region Employee listing
    public static void filterEmployee(String value)
    {
        // driver.findElement(By.id("//input[@aria-describedby='dx-col-4']")).sendKeys(value);
        waitForElement1(By.id("//input[@aria-describedby='dx-col-4']")).sendKeys(value);
    }

    public static String resultEmployee()
    {
        // String result = driver.findElement(By.xpath(
        // "/html[1]/body[1]/div[6]/div[2]/div[1]/div[2]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/p[1]/span[1]/a[1]")).getText();
        String result = waitForElement1(By.xpath(
                "/html[1]/body[1]/div[6]/div[2]/div[1]/div[2]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/p[1]/span[1]/a[1]"))
                .getText();
        return result;
    }

    public static String result()
    {
        // String result = driver.findElement(By.xpath("//td[@class='list-hyperlink
        // dx-cell-focus-disabled']")).getText();
        String result = waitForElement1(By.xpath("//td[@class='list-hyperlink dx-cell-focus-disabled']")).getText();
        return result;
    }

    public static void clickResult(String value)
    {
        // WebElement employee =
        // driver.findElement(By.xpath("//td[@class='list-hyperlink
        // dx-cell-focus-disabled']"));
        WebElement employee = waitForElement1(By.xpath("//td[@class='list-hyperlink dx-cell-focus-disabled']"));
        String result = employee.getText();
        if (result.contains(value))
        {
            employee.click();
        }
    }

    public static void navigateToEmployee(String value)
    {
        // selectFilterAll();
        filterByIndex(2, value);
        BaseTest.log("value filtered");
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        String employee = resultValue(1);
        // Thread.sleep(2000);
        if (employee.contains(value))
        {
            selectRow();
            clickOnView();
        } else
        {
            throw new RuntimeException("VRC- No matching record found");
        }
    }

    public static void switchTab()
    {
        String originalWindow = driver.getWindowHandle();
        // Get all window handles
        Set<String> allWindows = driver.getWindowHandles();
        // Iterate through the window handles
        for (String windowHandle : allWindows)
        {
            if (!windowHandle.equals(originalWindow))
            {
                // Switch to the new window
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void closeTab()
    {
        String originalWindow = driver.getWindowHandle();
        // Get all window handles
        Set<String> allWindows = driver.getWindowHandles();
        // Iterate through the window handles
        for (String windowHandle : allWindows)
        {
            if (!windowHandle.equals(originalWindow))
            {
                // Switch to the new window
                driver.switchTo().window(windowHandle);
                driver.close();
                break;
            }
        }
    }
    //endregion

    //region Common Actions
    public static void logoutAndLogin(String username, String pwd)
    {
        EmployeePage ep = new EmployeePage(driver);
        ep.clickRightAreaMenu();
        ep.clicklogOff();
        LoginPage lp = new LoginPage(driver);
        lp.login(username, pwd);
    }

    public static void selectFilterAll()
    {
        // driver.findElement(By.id("//img[@id='ListingViews_B-1Img']")).click();
//		WebElement element = driver.findElement(By.id("//input[@name='ListingViews']"));
//		clickElementByJavaScript(driver, element);
        By locator = By.id("//img[@id='ListingViews_B-1Img']");
        waitForElement1(locator).click();
        selectDropdownValueOffice365("All");
    }
    //endregion

    //region Keyboard Actions

    public static void pause(String key)
    {
        Actions actions = new Actions(driver);
        actions.pause(Duration.ofSeconds(2)).perform(); // wait for 2 seconds
    }

    public static void enterKey(String key)
    {
        Actions actions = new Actions(driver);
        actions.sendKeys(key).perform();
    }

    public static void enterCapitalKey(String key)
    {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(key).keyUp(Keys.SHIFT).perform();
    }

    public static void pressKey(String key)
    {
        Actions actions = new Actions(driver);
        actions.sendKeys(getKeyFromString(key)).perform();
    }

    public static Keys getKeyFromString(String key)
    {
        switch (key.toLowerCase())
        {
            // Editing keys
            case "enter":
                return Keys.ENTER;
            case "tab":
                return Keys.TAB;
            case "escape":
                return Keys.ESCAPE;
            case "backspace":
                return Keys.BACK_SPACE;
            case "delete":
                return Keys.DELETE;
            case "insert":
                return Keys.INSERT;
            case "space":
                return Keys.SPACE;
            // Modifier keys
            case "shift":
                return Keys.SHIFT;
            case "control":
                return Keys.CONTROL;
            case "alt":
                return Keys.ALT;
            // Navigation keys
            case "arrowup":
                return Keys.ARROW_UP;
            case "arrowdown":
                return Keys.ARROW_DOWN;
            case "arrowleft":
                return Keys.ARROW_LEFT;
            case "arrowright":
                return Keys.ARROW_RIGHT;
            case "home":
                return Keys.HOME;
            case "end":
                return Keys.END;
            case "pageup":
                return Keys.PAGE_UP;
            case "pagedown":
                return Keys.PAGE_DOWN;
            // Function keys
            case "f1":
                return Keys.F1;
            case "f2":
                return Keys.F2;
            case "f3":
                return Keys.F3;
            case "f4":
                return Keys.F4;
            // Separator and control keys
            case "add":
                return Keys.ADD;
            case "subtract":
                return Keys.SUBTRACT;
            case "multiply":
                return Keys.MULTIPLY;
            case "divide":
                return Keys.DIVIDE;
            case "decimal":
                return Keys.DECIMAL;
            default:
                throw new IllegalArgumentException("Invalid key name");
        }
    }

    public static void pressTab()
    {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
    }

    public static void pressEnter()
    {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }
    //endregion

    //region Waits

    public static void waitUntil(By locator)
    {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        WebElement element = fluentWait.until(driver ->
        {
            WebElement el = driver.findElement(locator);
            return (el.isDisplayed() || el.isEnabled()) ? el : null;
        });
        element.click();
    }

    public static WebElement waitForElement(WebElement element)
    {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        return fluentWait.until(driver ->
        {
            WebElement el = element;
            return (el.isDisplayed() || el.isEnabled()) ? el : null;
        });
    }

    public static WebElement waitForElement1(By locator)
    {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        return fluentWait.until(driver ->
        {
            WebElement el = driver.findElement(locator);
            return (el.isDisplayed() || el.isEnabled()) ? el : null;
        });
    }

    public static void wait(int seconds)
    {
        try
        {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }

    public static void waitTS(int seconds)
    {
        try
        {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
    //endregion

    //region Validations
    public static boolean isValuePresent(List<WebElement> element, String value)
    {
        List<WebElement> valuesList = element;
        for (WebElement valueElement : valuesList)
        {
            String actualValue = valueElement.getText();
            if (actualValue.contains(value))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isTransactionCreated()
    {
        String message = waitForElement1(By.xpath("//div[@class='dx-toast-message']")).getText();
        if (message.contains("created successfully"))
        {
            return true;
        } else
        {
            return false;
        }
    }

    public static boolean isEmployeeDeleted()
    {
        String message = waitForElement1(By.xpath("//div[@class='dx-toast-message']")).getText();
        if (message.contains("deleted successfully"))
        {
            return true;
        } else
        {
            return false;
        }
    }

    public static void validation(String expectedMessage)
    {
        WebElement element = waitForElement1(By.className("dx-toast-message"));
        String actualMessage = element.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    public static boolean validateListing(String value, int filterIndex, int resultIndex)
    {
        filterByIndex(filterIndex, value);
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        String actualValue = resultValue(resultIndex);
        if (actualValue.contains(value))
        {
            return true;
        } else
        {
            return false;
        }
    }

    public static boolean validateListing2Fields(String value1, int filterIndex1, int resultIndex1, String value2,
                                                 int filterIndex2, int resultIndex2)
    {
        // Apply first filter
        filterByIndex(filterIndex1, value1);
        waitTS(2);
        // Apply second filter
        filterByIndex(filterIndex2, value2);
        waitTS(2);
        // Get results
        String actualValue1 = resultValue(resultIndex1);
        String actualValue2 = resultValue(resultIndex2);
        // Validate results
        boolean isValid1 = actualValue1.contains(value1);
        boolean isValid2 = actualValue2.contains(value2);
        return isValid1 && isValid2;
    }

    public static boolean validateListing1(String expDate, String expEmp, String expStatus)
    {
        if (expDate != null && !expDate.isEmpty())
        {
            filterDateByIndex(2, expDate);
            try
            {
                Thread.sleep(2000);
            } catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }
        if (expEmp != null && !expEmp.isEmpty())
        {
            filterByIndex(2, expEmp);
            try
            {
                Thread.sleep(2000);
            } catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }
        if (expStatus != null && !expStatus.isEmpty())
        {
            filterByIndex(7, expStatus);
            try
            {
                Thread.sleep(2000);
            } catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }
        boolean isMatch = true;
        if (expDate != null && !expDate.isEmpty())
        {
            String actualDate = resultValue(2);
            isMatch &= actualDate.contains(expDate);
        }
        if (expEmp != null && !expEmp.isEmpty())
        {
            String actualEmp = resultValue(1);
            isMatch &= actualEmp.contains(expEmp);
        }
        if (expStatus != null && !expStatus.isEmpty())
        {
            String actualStatus = resultValue(7);
            isMatch &= actualStatus.contains(expStatus);
        }
        return isMatch;
        // IsTransactionCreated(expDate: "2025-04-15"); // Only check date
        // IsTransactionCreated(expEmp: "John", expStatus: "Completed"); // Check
        // employee and status
        // IsTransactionCreated("2025-04-15", "John", "Completed"); // Check all three
    }
    //endregion

    //region Alert Handling
    public static void acceptAlert(WebDriver driver)
    {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(WebDriver driver)
    {
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText(WebDriver driver)
    {
        return driver.switchTo().alert().getText();
    }

    public void sendKeysToAlert(WebDriver driver, String text)
    {
        driver.switchTo().alert().sendKeys(text);
    }
    //endregion

    //region JavaScript Executor
    public static void executeScript(WebDriver driver, String script, Object... args)
    {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(script, args);
    }

    public Object executeScriptWithReturn(WebDriver driver, String script, Object... args)
    {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(script, args);
    }

    public void scrollToBottom(WebDriver driver)
    {
        executeScript(driver, "window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollToTop(WebDriver driver)
    {
        executeScript(driver, "window.scrollTo(0, 0);");
    }

    public void scrollIntoView(WebDriver driver, WebElement element)
    {
        executeScript(driver, "arguments[0].scrollIntoView(true);", element);
    }

    public static void clickElementByJavaScript(WebDriver driver, WebElement element)
    {
        executeScript(driver, "arguments[0].click();", element);
    }

    public void setAttribute(WebDriver driver, WebElement element, String attributeName, String attributeValue)
    {
        executeScript(driver, "arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", element);
    }

    public String getAttribute(WebDriver driver, WebElement element, String attributeName)
    {
        return (String) executeScriptWithReturn(driver, "return arguments[0].getAttribute('" + attributeName + "');",
                element);
    }

    public void highlightElement1(WebDriver driver, WebElement element)
    {
        executeScript(driver, "arguments[0].style.border='3px solid red'", element);
    }

    public static void highlightElement(WebDriver driver, WebElement element, boolean highlight)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (highlight)
        {
            // Add a red border to highlight the element
            js.executeScript("arguments[0].style.border='3px solid red'", element);
        } else
        {
            // Remove the border to unhighlight the element
            js.executeScript("arguments[0].style.border=''", element);
        }
    }

    public void refreshBrowserUsingJS(WebDriver driver)
    {
        executeScript(driver, "history.go(0);");
    }

    public void openNewTabUsingJS(WebDriver driver)
    {
        executeScript(driver, "window.open();");
    }
    //endregion

    //region Frame Handling
    public void switchToFrameByIndex(int index)
    {
        driver.switchTo().frame(index);
    }

    public void switchToFrameByNameOrId(String nameOrId)
    {
        driver.switchTo().frame(nameOrId);
    }

    public void switchToFrameByElement(WebElement element)
    {
        WebElement frameElement = element;
        driver.switchTo().frame(frameElement);
    }

    public void switchToDefaultContent()
    {
        driver.switchTo().defaultContent();
    }

    public void switchToParentFrame()
    {
        driver.switchTo().parentFrame();
    }
    //endregion

    //region Mouse Actions
    public void hoverOverElement(WebElement locator)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(locator).perform();
    }

    public void dragAndDrop1(WebElement sourceLocator, WebElement targetLocator)
    {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(waitForElement(sourceLocator), waitForElement(targetLocator)).perform();
    }

    public static void moveToElement(WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void clickAndHold(WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).perform();
    }

    public static void release()
    {
        Actions actions = new Actions(driver);
        actions.release().perform();
    }

    public static void doubleClick(WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public static void contextClick(WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public static void dragAndDrop(WebElement source, WebElement target)
    {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    public static void dragAndDropByOffset(WebElement element, int xOffset, int yOffset)
    {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, xOffset, yOffset).perform();
    }

    public static void moveSliderByOffset(WebElement locator, int xOffset)
    {
        Actions move = new Actions(driver);
        move.clickAndHold(waitForElement(locator)).moveByOffset(xOffset, 0) // Move right horizontally; adjust pixel
                // value as per
                // your slider
                .release().perform();
    }

    public void scrollToElement(WebDriver driver, WebElement element)
    {
        WheelInput.ScrollOrigin origin = WheelInput.ScrollOrigin.fromElement(element);
        Actions actions = new Actions(driver);
        actions.scrollFromOrigin(origin, 0, 0).perform();
    }

    public void moveToLocation(WebDriver driver, int x, int y)
    {
        Actions actions = new Actions(driver);
        actions.moveByOffset(x, y).perform();
    }

    public void scrollByAmount(WebDriver driver, int deltaX, int deltaY)
    {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(deltaX, deltaY).perform();
    }

    public void scrollFromOrigin(WebDriver driver, WheelInput.ScrollOrigin origin, int deltaX, int deltaY)
    {
        Actions actions = new Actions(driver);
        actions.scrollFromOrigin(origin, deltaX, deltaY).perform();
    }
    //endregion

    //region File Upload
    public void uploadFile(WebElement locator, String filePath)
    {
        waitForElement(locator).sendKeys(filePath);
    }
    //endregion
}