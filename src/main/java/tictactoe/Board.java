package tictactoe;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private List<String[]> grid;

    public Board(String boardRepresentation) {
        this.grid = Arrays.stream(boardRepresentation.split("\\n")).map(s -> s.split("")).toList();
    }

    public static Board fromString(String boardRepresentation) {
        return new Board(boardRepresentation);
    }

    public Winner determineWinner() {
        if (Arrays.equals(grid.get(0), new String[]{"_", "_", "_"})) {
            return new Winner("There is no winner yet");
        }

        return new Winner("X has won!");
    }
}
