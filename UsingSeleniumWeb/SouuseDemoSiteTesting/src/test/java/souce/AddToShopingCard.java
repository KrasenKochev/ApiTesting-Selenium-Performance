package souce;

import core.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToShopingCard extends BaseTest {
    @BeforeAll
    public static void baseSetup() {
        driver = startBrowser(LoginTest.BrowserTypes.CHROME);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get(BASE_URL);
    }
    @AfterAll
    public static void classClose() {
        driver.close();
    }
    @Test
    public void productAddedToShoppingCart_when_addToCart() {

        userAuticentedWhenValidCredentionsProvided(USERNAME,PASSWORD);

        WebElement addBackpack = driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']"));
        addBackpack.click();

        WebElement addTshirt = driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']"));
        addTshirt.click();

        WebElement shoppingCartLink = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shoppingCartLink.click();

        WebElement backpackName = driver.findElement(By.xpath("//a[@id='item_4_title_link']"));
        Assertions.assertTrue(backpackName.getText().contains("Sauce Labs Backpack"));

        WebElement tshirtName = driver.findElement(By.xpath("//a[@id='item_1_title_link']"));
        Assertions.assertTrue(tshirtName.getText().contains("Sauce Labs Bolt T-Shirt"));

        var items = driver.findElements(By.className("inventory_item_name"));

        Assertions.assertEquals(2, items.size(), "Items count not as expected");


    }
}
