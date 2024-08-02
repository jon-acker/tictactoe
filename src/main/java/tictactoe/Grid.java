package tictactoe;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Grid {

    private final List<List<String>> grid;

    public Grid(List<List<String>> grid) {
        this.grid = grid;
    }

    public boolean hasAnyCompletedDiagonal(String symbol) {
        return forwardDiagonalComplete(symbol) || backwardDiagonalComplete(symbol);
    }

    private boolean forwardDiagonalComplete(String symbol) {
        boolean result = true;
        for (int i = 0; i < grid.size(); i++) {
            result &= grid.get(i).get(i).equals(symbol);
        }
        return result;
    }

    private boolean backwardDiagonalComplete(String symbol) {
        boolean result = true;
        for (int i = 0; i < grid.size(); i++) {
            result &= grid.get(i).get(grid.size() - 1 - i).equals(symbol);
        }
        return result;
    }

    public boolean hasAnyCompletedColumn(String symbol) {
        return IntStream
                .range(0, grid.size())
                .anyMatch(columnIsComplete(symbol));
    }

    public boolean hasAnyCompletedRow(String symbol) {
        return grid.stream().anyMatch(rowIsComplete(symbol));
    }

    private Predicate<List<String>> rowIsComplete(String symbol) {
        return row -> row.stream().allMatch(s -> s.equals(symbol));
    }

    private IntPredicate columnIsComplete(String symbol) {
        return col -> grid.stream().allMatch(row -> row.get(col).equals(symbol));
    }

    public boolean isFull() {
        return grid.stream().noneMatch(g -> g.contains("_"));
    }
}
