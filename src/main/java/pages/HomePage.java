package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class with elements from HomePage.
 *
 * @author Anastasiia_Kovalenko
 */
public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[contains(@class, 'main_nav_research')]/a[@href='#']")
    private WebElement researchEducation;

    @FindBy(xpath = "(//div[@class='col-sm-5'])[2]")
    private WebElement acceptCookiesBtn;

    @FindBy(xpath = "(//img[@alt='XM Logo'])[2]")
    private WebElement logo;

    public void clickOnResearchEducation() {
        researchEducation.click();
    }

    public void clickOnAcceptCookiesBtn() {
        acceptCookiesBtn.click();
    }

    public void checkThatLogoIsDisplayed() {
        Assert.isTrue(logo.isDisplayed(), String.format("Expected logo is displayed, but actual is %s",
                logo.isDisplayed()));
    }
}
