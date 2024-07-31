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
        if (Arrays.equals(grid.get(0), new String[]{"O", "O", "O"})) {
            return new WinnerO();
        }

        if (Arrays.equals(grid.get(0), new String[]{"_", "_", "_"})) {
            return new WinnerNone();
        }



        return new WinnerX();
    }
}
