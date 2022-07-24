package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Class with elements from EconomicCalendarPage.
 *
 * @author Anastasiia_Kovalenko
 */
public class EconomicCalendarPage extends BasePage {
    public EconomicCalendarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='economic-calendar']")
    private WebElement calendarBlock;
    @FindBy(xpath = "//a[@id='timeFrame_yesterday']")
    private WebElement yesterdayBtn;
    @FindBy(xpath = "//a[@id='timeFrame_today']")
    private WebElement todayBtn;

    @FindBy(xpath = "//a[@id='timeFrame_tomorrow']")
    private WebElement tomorrowBtn;

    @FindBy(xpath = "//a[@id='timeFrame_thisWeek']")
    private WebElement thisWeekBtn;

    @FindBy(xpath = "//div[@id='widgetFieldDateRange']")
    private WebElement theDay;

    @FindBy(xpath = "(//a[contains(text(),'Risk Disclosure')])[2]")
    private WebElement riskDisclosureBtn;

    public void clickOnYesterdayBtn() {
        driver.switchTo().frame("");
        yesterdayBtn.click();
    }

    public void clickOnTodayBtn() {
        todayBtn.click();
    }

    public void clickOnTomorrowBtn() {
        tomorrowBtn.click();
    }

    public void clickOnThisWeekBtn() {
        thisWeekBtn.click();
    }

    public void clickOnRiskWarning() {
        WebElement hereBtn = (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return this.$(\"a:contains('here'):visible\").get(0)");
        hereBtn.click();
    }

    public String getTheDay() {
        return theDay.getText();
    }

    public void clickOnRiskDisclosureBtn() {
        riskDisclosureBtn.click();
    }

    public void checkThatCalendarBlockIsDisplayed() {
        Assert.assertTrue(calendarBlock.isDisplayed());
    }

    public void checkThatRiskDisclosureWasOpenedInNewTab() {
        Assert.assertEquals(driver.getWindowHandles().size(), 2);
    }
}
