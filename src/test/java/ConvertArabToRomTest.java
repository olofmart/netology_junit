import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ConvertArabToRomTest {
    ConvertArabToRom sut;

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
    public void convertTest (int a, String expected) {

        sut = new ConvertArabToRom();
        String result = sut.convert(a);

        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(10, "X"), Arguments.of(50, "L"),
                Arguments.of(100, "C"), Arguments.of(8, "VIII"));
    }
}
