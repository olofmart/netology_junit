import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ConvertRomToArabTest {
    ConverRomToArab sut;

    @BeforeEach
    public void initTest() {
        System.out.println("Test start");
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete");
    }

    @ParameterizedTest
    @MethodSource("source")
    public void convertTest (String a, int expected) {

        sut = new ConverRomToArab();
        int result = sut.convert(a);

        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of("X", 10), Arguments.of("IV", 4),
                Arguments.of("II", 2), Arguments.of("VIII", 8));
    }
}
