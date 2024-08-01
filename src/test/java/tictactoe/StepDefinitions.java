package tictactoe;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;
import static tictactoe.Board.determineWinner;

public class StepDefinitions {

    private Board board;

    private Player winner;

    @Given("the board is in the following state:")
    public void the_board_is_in_the_following_state(String boardRepresentation) {
        board = Board.fromString(boardRepresentation);
    }

    @When("we determine the winner")
    public void we_determine_the_winner() {
           winner = determineWinner(board);
    }

    @Then("the response should be: {string}")
    public void the_response_should_be(String message) {
        assertEquals(message, winner.message());
    }

    @Given("the board is has one complete row of X:")
    public void the_board_is_has_one_complete_row_of_x(String boardRepresentation) {
        board = Board.fromString(boardRepresentation);
    }

    @Given("the board is in the state: {string}")
    public void the_board_is_in_the_state(String boardRepresentation) {
        // Write code here that turns the phrase above into concrete actions
        board = Board.fromString(boardRepresentation);
    }
}
