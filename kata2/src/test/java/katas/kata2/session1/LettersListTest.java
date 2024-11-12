package katas.kata2.session1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LettersListTest {
    LettersList testSubject = new LettersList();

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of("cat", "act: [cat]"),
                Arguments.of("cat, act, at, tea, ate, tact",
                        """
                                act: [act, cat, tact]
                                aet: [ate, tea]
                                at: [at]"""));
    }

    @ParameterizedTest
    @MethodSource("testInput")
    void shouldListLetters(String input, String expected) {
        // Given

        // When
        String actual = testSubject.listLetters(input);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

}
