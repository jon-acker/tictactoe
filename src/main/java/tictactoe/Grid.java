package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Grid {

    private final List<List<String>> grid;

    public Grid(List<List<String>> grid) {
        this.grid = grid;
    }

    public boolean hasAnyCompletedColumn(String symbol) {
        return IntStream.range(0, grid.size()).anyMatch(
                i -> grid.stream().allMatch(row -> row.get(i).equals(symbol))
        );
    }

    public boolean hasAnyCompletedRow(String symbol) {
        return grid.stream().anyMatch(row -> rowIsComplete(row, symbol));
    }

    private boolean rowIsComplete(List<String> row, String symbol) {
        return row.stream().allMatch(s -> s.equals(symbol));
    }

    public boolean isFull() {
        return grid.stream().noneMatch(g -> g.contains("_"));
    }
}
