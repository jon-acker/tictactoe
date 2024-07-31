package tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Board {
    private List<String[]> grid;

    public Board(String boardRepresentation) {
        this.grid = Arrays.stream(boardRepresentation.split("\\n")).map(s -> s.split("")).toList();
    }

    public static Board fromString(String boardRepresentation) {
        return new Board(boardRepresentation);
    }

    public Winner determineWinner() {
        if (grid.stream().anyMatch(row -> isComplete(row, "O")))
            return new WinnerO();

        if (grid.stream().allMatch(row -> row[0].equals("X")))
            return new WinnerX();

        if (grid.stream().anyMatch(row -> isComplete(row, "X")))
            return new WinnerX();

        return new WinnerNone();
    }

    private boolean isComplete(String[] row, String symbol) {
        return Arrays.stream(row).allMatch(s -> s.equals(symbol));
    }


}
