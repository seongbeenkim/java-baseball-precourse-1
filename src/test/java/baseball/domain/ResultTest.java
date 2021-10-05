package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ResultTest {

    @ParameterizedTest
    @CsvSource(value = {"2, 1, true", "3, 0, false"})
    @DisplayName("3 스트라이크가 아닌지 확인한다.")
    void isNotThreeStrike(int strikeCount, int ballCount, boolean expected) {
        //given
        Result result = new Result(strikeCount, ballCount);

        //when
        boolean isNotThreeStrike = result.isNotThreeStrike();

        //then
        assertThat(isNotThreeStrike).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"STRIKE, 1, 0", "BALL, 0, 1"})
    @DisplayName("전달받은 상태를 추가한 새로운 결과 객체를 반환한다.")
    void add(Status status, int strikeCount, int ballCount) {
        //given
        Result result = new Result();

        //when
        Result addedResult = result.add(status);

        //then
        assertAll(
                () -> assertThat(addedResult.getStrikeCount()).isEqualTo(strikeCount),
                () -> assertThat(addedResult.getBallCount()).isEqualTo(ballCount)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 0, true", "1, 0, false", "0, 1, false"})
    @DisplayName("낫싱인지 확인한다.")
    void isNothing(int strikeCount, int ballCount, boolean expected) {
        //given
        Result result = new Result(strikeCount, ballCount);

        //when
        boolean isNothing = result.isNothing();

        //then
        assertThat(isNothing).isEqualTo(expected);
    }
}
