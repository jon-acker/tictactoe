package tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Board {
    private Grid grid;

    public Board(String boardRepresentation) {
        this.grid = new Grid(Arrays.stream(boardRepresentation.split("\\n")).map(s -> s.split("")).toList());
    }

    public static Board fromString(String boardRepresentation) {
        return new Board(boardRepresentation);
    }

    public Winner determineWinner() {
        return getCompleted(grid)
                .map(winner -> winner.equals("O") ?
                        new WinnerO() :
                        new WinnerX()
                )
                .orElseGet(WinnerNone::new);
    }


    private Optional<String> getCompleted(Grid grid) {

        return Stream.of("X", "O")
                .filter(symbol -> (grid.hasCompletedColumn(symbol) || grid.hasCompletedRow(symbol)))
                .findFirst();
    }
}
