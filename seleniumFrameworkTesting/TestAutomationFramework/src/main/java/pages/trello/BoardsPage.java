package pages.trello;

import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class BoardsPage extends BaseTrelloPage {

    public BoardsPage(WebDriver driver) {
        super(driver, "trello.boardsPage");
    }

    public void createBoard() {

        String boardName = getUIMappingByKey("trello.boardName");

        actions.waitForElementClickable("trello.header.create.menuButton");
        actions.clickElement("trello.header.create.menuButton");

        actions.waitForElementClickable("trello.header.createBoard.dropDownButton");
        actions.clickElement("trello.header.createBoard.dropDownButton");

        actions.waitForElementClickable("trello.createBoard.titleInput");
        actions.typeValueInField(boardName, "trello.createBoard.titleInput");

        actions.waitForElementClickable("trello.create.board.submitButton");
        actions.clickElement("trello.create.board.submitButton");
    }

    public void deleteBoard() {
        actions.waitForElementPresent("trello.boardPage.specificBoardXpath");
        actions.clickElement("trello.boardPage.specificBoardXpath");

        actions.waitForElementClickable("trello.boardPage.boardMenuButtonXpath");
        actions.clickElement("trello.boardPage.boardMenuButtonXpath");

        actions.waitForElementClickable("trello.boardPage.moreButtonXpath");
        actions.clickElement("trello.boardPage.moreButtonXpath");

        actions.waitForElementClickable("trello.boardPage.closeBoardButtonXpath");
        actions.clickElement("trello.boardPage.closeBoardButtonXpath");

        actions.waitForElementClickable("trello.boardPage.confirmCloseBoardButtonXpath");
        actions.clickElement("trello.boardPage.confirmCloseBoardButtonXpath");

        actions.waitForElementClickable("trello.boardPage.permanentlyDeleteBoardButtonXpath");
        actions.clickElement("trello.boardPage.permanentlyDeleteBoardButtonXpath");

        actions.waitForElementClickable("trello.boardPage.confirmDeleteBoardButtonXpath");
        actions.clickElement("trello.boardPage.confirmDeleteBoardButtonXpath");
    }
}





