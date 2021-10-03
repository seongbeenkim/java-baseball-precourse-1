package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @ParameterizedTest
    @CsvSource(value = {"3, 0, true", "2, 1, false"})
    @DisplayName("모두 스트라이크인지 확인한다.")
    void isAllStrike(int strikeCount, int ballCount, boolean expected) {
        //given
        Result result = new Result(strikeCount, ballCount);

        //when
        boolean isAllStrike = result.isAllStrike();

        //then
        assertThat(isAllStrike).isEqualTo(expected);
    }
}
