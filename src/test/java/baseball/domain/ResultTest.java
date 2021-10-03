package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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
}
