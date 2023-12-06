package pages.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;
import static org.junit.Assert.assertTrue;

public class BoardPage extends BaseTrelloPage {

    public BoardPage(WebDriver driver) {
        super(driver, "trello.boardPage");
    }


    public void assertListExists(String listName) {
        actions.waitForElementPresent("trello.boardPage.listByName", "New card");
    }

    public void assertAddListExists() {
        actions.waitForElementPresent("trello.boardPage.listWrapper");
    }


    public void assertCardExists(String newCard) {
        actions.waitForElementPresentWithText("trello.boardPage.firstCard", "New card");
    }


    public void assertCardIsMoved(String targetListXpath, String expectedCardName) {

        actions.waitForElementPresentWithText("trello.boardPage.targetListXpath", "New card");
    }


    public void moveCardToList(String cardName, String listName) {

        actions.waitForElementClickable("trello.boardPage.specificBoardXpath");
        actions.clickElement("trello.boardPage.specificBoardXpath");

        actions.waitForElementPresent("trello.boardPage.sourceCardXpath");
        actions.dragAndDropByXpath("trello.boardPage.sourceCardXpath", "trello.boardPage.targetListXpath");
    }

    public void clickOnBoard() {
        actions.waitForElementPresent("trello.boardPage.specificBoardXpath");
        actions.clickElement("trello.boardPage.specificBoardXpath");
    }

    public void addCardButton() {
        actions.waitForElementPresent("trello.boardPage.addCardButton");
        actions.clickElement("trello.boardPage.addCardButton");
    }

    public void typingNewCard() {
        actions.waitForElementPresent("trello.boardPage.cardNameInput");
        actions.typeValueInField("New Card", "trello.boardPage.cardNameInput");
        actions.clickElement("trello.boardPage.outsideClick");
    }

    public void assertNoBoards() {

        List<WebElement> boards = driver.findElements(By.xpath("trello.boardPage.specificBoardXpath"));
        assertTrue(boards.isEmpty());
    }

}









