package test.cases.trello;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.trello.BoardPage;
import pages.trello.BoardsPage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardTest extends BaseTest {
    @Test
    public void test_1_createBoardWhenCreateBoardClicked() {

        login();

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.assertAddListExists();
    }


    @Test
    public void test_2_createNewCardInExistingBoardWhenCreateCardClicked() {

        login();


        BoardPage boardPage = new BoardPage(actions.getDriver());

        boardPage.clickOnBoard();
        boardPage.addCardButton();
        boardPage.typingNewCard();
        boardPage.assertCardExists("New card");


    }

    @Test
    public void test_3_moveCardBetweenStatesWhenDragAndDropIsUsed() {


        login();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.moveCardToList("New Card", "Doing");
        boardPage.assertCardIsMoved("trello.boardPage.cardList", "New card");


    }


    @Test
    public void test_4_deleteBoardWhenDeleteButtonIsClicked() {
        login();


        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.deleteBoard();
        BoardPage boardPage = new BoardPage(actions.getDriver());

        boardPage.assertNoBoards();


    }


}