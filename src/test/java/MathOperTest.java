import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MathOperTest {

    @BeforeEach
    public void initTest() {
        System.out.println("Test start");
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete");
    }

    @ParameterizedTest
    @MethodSource("sourceAdditionTest")
    public void additionTest(String a, String b, String expected) {

        MathOper sut = new MathOper();
        String result = sut.addition(a, b);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("sourceSubtractionTest")
    public void subtractionTest() {
        MathOper sut = new MathOper();
        String a = "10", b = "5", expected = "5";
        String result = null;
        try {
            result = sut.subtraction(a, b);
        } catch (Exception e) {

        }

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void subtractionTestThrowsException() {
        MathOper sut = new MathOper();
        String a = "V", b = "V";

        var expected = Exception.class;

        Assertions.assertThrows(expected, () -> sut.subtraction(a, b));
    }

    @ParameterizedTest
    @MethodSource("sourceDivisionTest")
    public void divisionTest() {
        MathOper sut = new MathOper();
        String a = "5", b = "5", expected = "1";
        String result = null;
        try {
            result = sut.division(a, b);
        } catch (Exception e) {

        }

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void divisionTestThrowsException() {
        MathOper sut = new MathOper();
        String a = "10", b = "0";

        var expected = Exception.class;

        Assertions.assertThrows(expected, () -> sut.division(a, b));
    }

    @ParameterizedTest
    @MethodSource("sourceMultiplicationTest")
    public void multiplicationTest(String a, String b, String expected) {

        MathOper sut = new MathOper();
        String result = null;
        try {
            result = sut.multiplication(a, b);
        } catch (Exception e) {

        }

        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> sourceAdditionTest() {
        return Stream.of(Arguments.of("10","10", "20"), Arguments.of("X", "X", "XX"),
                Arguments.of("3", "7", "10"), Arguments.of("III", "VII", "X"));
    }

    private static Stream<Arguments> sourceSubtractionTest() {
        return Stream.of(Arguments.of("10","9", "1"), Arguments.of("X", "IX", "I"),
                Arguments.of("3", "7", "-4"), Arguments.of("VII", "III", "IV"));
    }

    private static Stream<Arguments> sourceDivisionTest() {
        return Stream.of(Arguments.of("10","10", "1"), Arguments.of("X", "X", "I"),
                Arguments.of("7", "3", "2"), Arguments.of("VII", "III", "II"));
    }

    private static Stream<Arguments> sourceMultiplicationTest() {
        return Stream.of(Arguments.of("10","10", "100"), Arguments.of("X", "X", "C"),
                Arguments.of("3", "7", "21"), Arguments.of("III", "VII", "XXI"));
    }
}
