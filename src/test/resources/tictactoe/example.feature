Feature: Determining the winner of the game

  Scenario: No winner yet
    Given the board is in the following state:
    """
    ___
    _X_
    ___
    """
    When we determine the winner
    Then the response should be: "There is no winner yet"

  Scenario: X has won
    Given the board is in the following state:
    """
    XXX
    ___
    ___
    """
    When we determine the winner
    Then the response should be: "X has won!"

  Scenario: O has won
    Given the board is in the following state:
    """
    OOO
    ___
    ___
    """
    When we determine the winner
    Then the response should be: "O has won!"