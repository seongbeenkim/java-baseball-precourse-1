package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StatusTest {

    @ParameterizedTest
    @CsvSource(value = {"STRIKE, false", "BALL, false", "NOTHING, true"})
    @DisplayName("낫싱 여부를 반환한다.")
    void isNothing(Status status, boolean expected) {
        //when
        boolean actual = status.isNothing();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"STRIKE, true", "BALL, false", "NOTHING, false"})
    @DisplayName("스트라이크 여부를 반환한다.")
    void isStrike(Status status, boolean expected) {
        //when
        boolean actual = status.isStrike();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"STRIKE, false", "BALL, true", "NOTHING, false"})
    @DisplayName("볼 여부를 반환한다.")
    void isBall(Status status, boolean expected) {
        //when
        boolean actual = status.isNothing();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
