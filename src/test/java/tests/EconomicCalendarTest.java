package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EconomicCalendarPage;
import pages.HomePage;
import pages.ResearchAndEducationPage;
import properties.ConfProperties;
import steps.EconomicCalendarSteps;

import static enums.Day.THIS_WEEK;
import static enums.Day.TODAY;
import static enums.Day.TOMORROW;
import static enums.Day.YESTERDAY;

public class EconomicCalendarTest {
    public static WebDriver driver;
    public HomePage homePage;
    public ResearchAndEducationPage researchAndEducationPage;
    public EconomicCalendarPage economicCalendarPage;
    public EconomicCalendarSteps economicCalendarSteps = new EconomicCalendarSteps();

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("url"));
        homePage = new HomePage(driver);
        homePage.clickOnAcceptCookiesBtn();
        researchAndEducationPage = new ResearchAndEducationPage(driver);
        economicCalendarPage = new EconomicCalendarPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    void verifyGeneralBlockOnEconomicCalendarPage() {
        homePage.checkThatLogoIsDisplayed();
        homePage.clickOnResearchEducation();
        researchAndEducationPage.checkThatDropdownBlockIsDisplayed();
        researchAndEducationPage.clickOnEconomicCalendar();
        economicCalendarPage.checkThatCalendarBlockIsDisplayed();
        economicCalendarPage.clickOnYesterdayBtn();
        economicCalendarSteps.checkThatDateIsCorrect(economicCalendarPage.getTheDay(), YESTERDAY);
        economicCalendarPage.clickOnTodayBtn();
        economicCalendarSteps.checkThatDateIsCorrect(economicCalendarPage.getTheDay(), TODAY);
        economicCalendarPage.clickOnTomorrowBtn();
        economicCalendarSteps.checkThatDateIsCorrect(economicCalendarPage.getTheDay(), TOMORROW);
        economicCalendarPage.clickOnThisWeekBtn();
        economicCalendarSteps.checkThatDateIsCorrect(economicCalendarPage.getTheDay(), THIS_WEEK);
        economicCalendarPage.clickOnRiskWarning();
        economicCalendarPage.clickOnRiskDisclosureBtn();
        economicCalendarPage.checkThatRiskDisclosureWasOpenedInNewTab();
    }
}
