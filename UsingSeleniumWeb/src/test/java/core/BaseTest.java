package core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import souce.LoginTest;

import java.time.Duration;

public class BaseTest {
    public static final String INPUT_DATA_TEST_USERNAME = "//input[@data-test='username']";
    public static final String INPUT_DATA_TEST_PASSWORD = "//input[@data-test='password']";
    public static final String INPUT_DATA_TEST_LOGIN_BUTTON_LOCATION = "//input[@data-test='login-button']";
    public static final String APP_LOGO_LOCATION = "//div[@class='app_logo']";
    public static final String LOGO_ASSERT_TEXT = "Swag Labs";
    public static final String PASSWORD = "secret_sauce";
    public static final String USERNAME = "standard_user";
    public static final String BASE_URL = "https://www.saucedemo.com/";

    public static WebDriver driver;
    public static WebDriverWait wait;
    public enum BrowserTypes{
        CHROME,
        CHROME_HEADLESS,
        FIREFOX,
        FIREFOX_HEADLESS

    }

    @BeforeAll
    public static void baseSetup() {
    }
    @AfterAll
    public static void classClose() {
    }
    public static WebDriver startBrowser(LoginTest.BrowserTypes browserType) {
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
    protected static void userAuticentedWhenValidCredentionsProvided(String username, String passwordName) {
        driver.get(BASE_URL);

        WebElement userName = driver.findElement(By.xpath(INPUT_DATA_TEST_USERNAME));
        userName.sendKeys(USERNAME);

        WebElement password = driver.findElement(By.xpath(INPUT_DATA_TEST_PASSWORD));
        password.sendKeys(PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath(INPUT_DATA_TEST_LOGIN_BUTTON_LOCATION));
        loginButton.click();

        WebElement inventoryPageTitle = driver.findElement(By.xpath(APP_LOGO_LOCATION));
        wait.until(ExpectedConditions.visibilityOf(inventoryPageTitle));
        Assertions.assertTrue(inventoryPageTitle.getText().contains(LOGO_ASSERT_TEXT));
    }

}
