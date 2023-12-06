package bingsearches;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BingAndGoogleSearches {


    private static final String SURCH_FIELD_BING = "//input[@id='sb_form_q']";
    private static final String SEARCH_TEXT = "Telerik Academy Alpha";
    private static final String EXPECTED_TEXT_RESULT = "IT Career Start in 6 Months - Telerik Academy Alpha";
    private static final String EXPECTED_TEXT_RESULT_SECOND_VAR_BECAUSE_BING = "Telerik Academy Alpha";
    private static final String BING_URL = "https://bing.com";
    private static final String GOOGLE_URL = "https://google.com";
    private static final String BING_PATH_TEXT_VALIDATION = "//h2[@class=' b_topTitle']";
    private static final String GOOGLE_PATH_TEXT_VALIDATION = "(//a/h3)[1]";
    private static final String SEARCH_BUTTON_BING = "//label[@id='search_icon']";
    private static final String AGREE_BUTTON_GOOGLE = "//button[@id='L2AGLb']";
    private static final String SEARCH_FIELD_INPUT_TEXT_GOOGLE = "//textarea[@type='search']";
    private static final String CLICK_FIELD_GOOGLE = "//textarea[@id='APjFqb']";
    private static final String SEARCH_FIELD_GOOGLE = "(//input[@type='submit' and @name='btnK'])[1]";


    private static WebDriver driver;
    private static WebDriverWait wait;
    public enum BrowserTypes{
        CHROME,
        CHROME_HEADLESS,
        FIREFOX,
        FIREFOX_HEADLESS

    }

   @BeforeAll
   public static void classSetup() {
       driver = startBrowser(BrowserTypes.CHROME);
       wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    @AfterAll
    public static void classClose() {
        driver.close();
    }

    @Test
    public void resultFound_when_searchTermProvidedWithBing() throws InterruptedException {
        driver.get(BING_URL);

        WebElement searchField = driver.findElement(By.xpath(SURCH_FIELD_BING));


        searchField.sendKeys(SEARCH_TEXT);

        WebElement searchButton = driver.findElement(By.xpath(SEARCH_BUTTON_BING));
        searchButton.click();

        WebElement firstResult = driver.findElement(By.xpath(BING_PATH_TEXT_VALIDATION));
        Assertions.assertTrue(firstResult.getText().contains(EXPECTED_TEXT_RESULT_SECOND_VAR_BECAUSE_BING), "Search result not found" );

    }


    @Test
    public void resultFound_when_searchTermProvidedWithGoogle(){
        driver.get(GOOGLE_URL);

        WebElement agreeButton = driver.findElement(By.xpath(AGREE_BUTTON_GOOGLE));
        agreeButton.click();

        WebElement searchField = driver.findElement(By.xpath(SEARCH_FIELD_INPUT_TEXT_GOOGLE));
        searchField.sendKeys(SEARCH_TEXT);

        WebElement clickField = driver.findElement(By.xpath(CLICK_FIELD_GOOGLE));
        clickField.click();

        WebElement searchButton = driver.findElement(By.xpath(SEARCH_FIELD_GOOGLE));
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();

        WebElement firstResult = driver.findElement(By.xpath(GOOGLE_PATH_TEXT_VALIDATION));
        Assertions.assertTrue(firstResult.getText().contains(EXPECTED_TEXT_RESULT), "Search result not found" );

    }
    public static WebDriver startBrowser(BrowserTypes browserType) {
        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new FirefoxDriver(firefoxOptions);
            case CHROME_HEADLESS:
                ChromeOptions chromeOptions1 = new ChromeOptions();
                chromeOptions1.addArguments("--headless");
                return new ChromeDriver(chromeOptions1);
            case FIREFOX_HEADLESS:
                FirefoxOptions firefoxOptions1 = new FirefoxOptions();
                firefoxOptions1.addArguments("--headless");
                return new FirefoxDriver(firefoxOptions1);
        }
        return null;
    }
}
