package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Grid extends ArrayList<String[]> {

    private final List<String[]> grid;

    public Grid(List<String[]> grid) {
        this.grid = grid;
    }

    public boolean hasCompletedColumn(String symbol) {
        return IntStream.range(0, grid.size()).anyMatch(
                i -> grid.stream().allMatch(row -> row[i].equals(symbol))
        );
    }

    public boolean hasCompletedRow(String symbol) {
        return grid.stream().anyMatch(row -> rowIsComplete(row, symbol));
    }

    private boolean rowIsComplete(String[] row, String symbol) {
        return Arrays.stream(row).allMatch(s -> s.equals(symbol));
    }
}
