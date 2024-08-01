package tictactoe;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tictactoe.Board.determineWinner;

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
                        ___
                        XXX
                        ___
                        """, "X has won!"),

                Arguments.of("""
                        ___
                        ___
                        XXX
                        """, "X has won!"),

                Arguments.of("""
                        X__
                        X__
                        X__
                        """, "X has won!"),

                Arguments.of("""
                        _X_
                        _X_
                        _X_
                        """, "X has won!"),

                Arguments.of("""
                        __X
                        __X
                        __X
                        """, "X has won!"),

                Arguments.of("""
                        OOO
                        ___
                        ___
                        """, "O has won!"),

                Arguments.of("""
                        ___
                        OOO
                        ___
                        """, "O has won!"),

                Arguments.of("""
                        ___
                        ___
                        OOO
                        """, "O has won!"),

                Arguments.of("""
                        O__
                        O__
                        O__
                        """, "O has won!"),

                Arguments.of("""
                        _O_
                        _O_
                        _O_
                        """, "O has won!"),

                Arguments.of("""
                        __O
                        __O
                        __O
                        """, "O has won!"),
                Arguments.of("""
                        OXX
                        XOO
                        OOX
                        """, "It's a draw!")
                );
    }


    @ParameterizedTest
    @MethodSource("boardExamples")
    void testSumTextBlock(String board, String expectedResponse) {
        assertEquals(expectedResponse, determineWinner(Board.fromString(board)).message());
    }
}
