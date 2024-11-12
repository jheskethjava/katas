package katas.kata1.session2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringCalculatorTest {

    private StringCalculator testSubject = new StringCalculator();

    private static Stream<Arguments> shouldAdd() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("5", 5),
                Arguments.of("1,2", 3),
                Arguments.of("10, 5, 4, 2", 21),
                Arguments.of("1\n2,3", 6),
                Arguments.of("//;\n1;2", 3),
                Arguments.of("1001,2", 2));
    }

    @ParameterizedTest
    @MethodSource("shouldAdd")
    void shouldAdd(String numbers, Integer expected) {
        // Given

        // When
        Integer actual = testSubject.add(numbers);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> shouldThrowNegativeException() {
        return Stream.of(
                Arguments.of("10, -5, 4, -2", "-5,-2"),
                Arguments.of("2,-4,3,-5", "-4,-5"));
    }

    @ParameterizedTest
    @MethodSource("shouldThrowNegativeException")
    void shouldThrowNegativeException(String numbers, String expected) {
        // Given

        // When
        Throwable actual = catchThrowable(() -> testSubject.add(numbers));

        // Then
        assertThat(actual).hasMessage("Negatives not allowed: " + expected);
    }

}
