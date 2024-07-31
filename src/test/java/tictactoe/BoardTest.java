package tictactoe;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BoardTest {

    private Stream<Arguments> boardExamples() {
        return Stream.of(
                Arguments.of("""
                        ___
                        _X_
                        ___
                        """, "There is no winner yet"),

                Arguments.of("""
                        XXX
                        ___
                        ___
                        """, "X has won!"),

                Arguments.of("""
                        OOO
                        ___
                        ___
                        """, "O has won!")
                );
    }


    @ParameterizedTest
    @MethodSource("boardExamples")
    void testSumTextBlock(String board, String expectedResponse) {
        assertEquals(expectedResponse, Board.fromString(board).determineWinner().message());
    }
}
