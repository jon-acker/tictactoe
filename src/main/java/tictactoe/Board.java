package tictactoe;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Board {
    private final Grid grid;

    public Board(String boardRepresentation) {
        this.grid = new Grid(
                Stream
                        .of(boardRepresentation.split("\\n"))
                        .map(s -> Arrays.stream(s.split("")).toList())
                        .toList()
        );
    }

    public static Board fromString(String boardRepresentation) {
        return new Board(boardRepresentation);
    }

    public static Player determineWinner(Board board) {
        return getCompletedPlayer(board.grid)
                .map(winner -> winner.equals("O") ?
                        new WinnerO() :
                        new WinnerX()
                )
                .orElseGet(() -> {
                    if (board.isFull()) {
                        return new Draw();
                    }

                    return new WinnerNone();
                });
    }

    private boolean isFull() {
        return grid.isFull();
    }


    private static Optional<String> getCompletedPlayer(Grid grid) {

        return Stream.of("X", "O")
                .filter(symbol ->
                        grid.hasAnyCompletedColumn(symbol) ||
                        grid.hasAnyCompletedRow(symbol) ||
                        grid.hasAnyCompletedDiagonal(symbol)
                )
                .findFirst();
    }
}
