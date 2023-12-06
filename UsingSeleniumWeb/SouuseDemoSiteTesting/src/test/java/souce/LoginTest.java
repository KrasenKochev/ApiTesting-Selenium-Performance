package souce;

import core.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest extends BaseTest {



    @BeforeAll
    public static void baseSetup(){
        driver = startBrowser(LoginTest.BrowserTypes.CHROME);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get(BASE_URL);
    }
    @AfterAll
    public static void classClose() {
        driver.close();
    }
    @Test
    public void successfulLogin_when_validCredentials() throws InterruptedException {
        userAuticentedWhenValidCredentionsProvided(USERNAME,PASSWORD);
    }
}
