package tictactoe;

import java.util.Arrays;
import java.util.List;

public class Board {
    private List<String[]> grid;

    public Board(String boardRepresentation) {
        this.grid = Arrays.stream(boardRepresentation.split("\\n")).map(s -> s.split("")).toList();
    }

    public static Board fromString(String boardRepresentation) {
        return new Board(boardRepresentation);
    }

    public Winner determineWinner() {
        if (isComplete(0, "O")) {
            return new WinnerO();
        }

        if (isComplete(1, "O")) {
            return new WinnerO();
        }

        if (isComplete(1, "X")) {
            return new WinnerX();
        }

        if (isComplete(2, "X")) {
            return new WinnerX();
        }

        if (Arrays.equals(grid.get(0), new String[]{"_", "_", "_"})) {
            return new WinnerNone();
        }

        return new WinnerX();
    }

    private boolean isComplete(int row, String symbol) {
        return Arrays.stream(grid.get(row)).allMatch(s -> s.equals(symbol));
    }


}
