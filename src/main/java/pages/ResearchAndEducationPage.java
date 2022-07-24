package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class with elements from ResearchAndEducationPage.
 *
 * @author Anastasiia_Kovalenko
 */
public class ResearchAndEducationPage extends BasePage {
    public ResearchAndEducationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class='main_nav_research selected']/div[@style='display: block;']")
    private WebElement dropdownBlock;
    @FindBy(xpath = "//a[contains(text(),'Economic Calendar')]")
    private WebElement economicCalendar;

    public void clickOnEconomicCalendar() {
        economicCalendar.click();
    }

    public void checkThatDropdownBlockIsDisplayed() {
        dropdownBlock.isDisplayed();
    }
}
