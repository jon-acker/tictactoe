package tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Board {
    private List<String[]> grid;

    public Board(String boardRepresentation) {
        this.grid = Arrays.stream(boardRepresentation.split("\\n")).map(s -> s.split("")).toList();
    }

    public static Board fromString(String boardRepresentation) {
        return new Board(boardRepresentation);
    }

    public Winner determineWinner() {
        if (getCompleted(grid) == "O")
            return new WinnerO();

        if (getCompleted(grid) == "X")
            return new WinnerX();

        return new WinnerNone();
    }


    private String getCompleted(List<String[]> grid) {
        if (hasCompletedColumn(grid, "X") || hasCompletedRow(grid, "X")) {
            return "X";
        }

        if (hasCompletedColumn(grid, "O") || hasCompletedRow(grid, "O")) {
            return "O";
        }

        return null;
    }

    private boolean hasCompletedColumn(List<String[]> grid, String symbol) {
        return IntStream.range(0, grid.size()).anyMatch(
                i -> grid.stream().allMatch(row -> row[i].equals(symbol))
        );
    }

    private boolean hasCompletedRow(List<String[]> grid, String symbol) {
        return grid.stream().anyMatch(row -> rowIsComplete(row, symbol));
    }

    private boolean rowIsComplete(String[] row, String symbol) {
        return Arrays.stream(row).allMatch(s -> s.equals(symbol));
    }
}
