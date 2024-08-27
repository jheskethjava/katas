package katas.kata1.session1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringCalculatorTest {
    StringCalculator testSubject = new StringCalculator();

    private static Stream<Arguments> TEST_STRINGS() {
        return Stream.of(
                Arguments.of("", 0),
                // Arguments.of("apple", 0),
                Arguments.of("0", 0),
                Arguments.of("1", 1),
                Arguments.of("1,2", 3),
                Arguments.of("1,2,3,4,5", 15),
                Arguments.of("1\n2,3", 6),
                Arguments.of("//;\n1;2", 3),
                Arguments.of("//[delimiter]\n1\n2[delimiter]3", 6));
    }

    @ParameterizedTest
    @MethodSource("TEST_STRINGS")
    void shouldAddStrings(String input, int expected) {
        // Given

        // When
        int actual = testSubject.add(input);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

}
