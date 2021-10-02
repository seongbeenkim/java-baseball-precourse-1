package nextstep.test.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @CsvSource(value = {"0, a", "1, b", "2, c"})
    @DisplayName("특정 위치의 문자를 반환한다.")
    void charAt(int index, char expectedResult) {
        //given
        String input = "abc";

        //when
        char result = input.charAt(index);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    @DisplayName("위치 값이 문자열 길이 범위를 벗어날경우, 예외가 발생한다.")
    void charAt_fail_index_out_of_bound(int index) {
        //given
        String input = "abc";

        //when, then
        assertThatThrownBy(() -> input.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: " + index);
    }
}
