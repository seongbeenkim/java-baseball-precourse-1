package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StatusTest {

    @ParameterizedTest
    @CsvSource(value = {"STRIKE, false", "BALL, false", "NOTHING, true"})
    @DisplayName("")
    void isNothing(Status status, boolean expected) {
        //when
        boolean actual = status.isNothing();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
