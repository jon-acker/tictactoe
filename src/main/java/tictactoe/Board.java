package tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
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
        return getCompleted(grid)
                .map(winner -> winner.equals("O") ?
                        new WinnerO() :
                        new WinnerX()
                )
                .orElseGet(WinnerNone::new);
    }


    private Optional<String> getCompleted(List<String[]> grid) {

        return Stream.of("X", "O")
                .filter(symbol -> (hasCompletedColumn(grid, symbol) || hasCompletedRow(grid, symbol)))
                .findFirst();
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
