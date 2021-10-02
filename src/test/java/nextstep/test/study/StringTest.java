package nextstep.test.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

public class StringTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2 : 1 : 2",
            "12,34 : 12 : 34",
            "123,456 : 123 : 456"}, delimiter = ':')
    @DisplayName("','를 기준으로 문자열을 분리한다.")
    void split(String input, String expectedFirstToken, String expectedSecondToken) {
        //when
        String[] splitStrings = input.split(",");

        //then
        assertThat(splitStrings).containsExactly(expectedFirstToken, expectedSecondToken);
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "하", "!", "A"})
    @DisplayName("한 글자 문자열을 ','를 기준으로 분리한다.")
    void split_single_letter_string(String input) {
        //when
        String[] splitStrings = input.split(",");

        //then
        assertThat(splitStrings).containsExactly(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"(1,2) : 1,2", "(1,2,3) : 1,2,3"}, delimiter = ':')
    @DisplayName("일정 구간의 문자열을 반환한다.")
    void substring(String input, String expectedResult) {
        //given
        int secondLetterIndex = 1;
        int lastLetterIndex = input.length() - 1;

        //when
        String result = input.substring(secondLetterIndex, lastLetterIndex);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }
}
