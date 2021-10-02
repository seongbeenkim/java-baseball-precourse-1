package nextstep.test.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
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
}
