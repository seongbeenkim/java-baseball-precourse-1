package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BallsTest {

    @Test
    @DisplayName("숫자 목록를 입력받아 공 집합 객체를 생성한다.")
    void create() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        //when
        Balls balls = new Balls(numbers);

        //then
        assertThat(balls).isEqualTo(new Balls(numbers));
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2", "1, 2, 3, 4"})
    @DisplayName("3개의 숫자가 아닐 경우, 예외가 발생한다.")
    void create_fail_with_invalid_size(String input) {
        //given
        String[] splitNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String splitNumber : splitNumbers) {
            int number = Integer.parseInt(splitNumber);
            numbers.add(number);
        }

        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Balls(numbers))
                .withMessage("총 3개의 서로 다른 수로 구성되어야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 1, 2", "1, 2, 2", "1, 2, 1"})
    @DisplayName("중복된 숫자가 존재할 경우, 예외가 발생한다.")
    void create_fail_with_duplicated_numbers(int number1, int number2, int number3) {
        //given
        List<Integer> numbers = Arrays.asList(number1, number2, number3);

        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Balls(numbers))
                .withMessage("총 3개의 서로 다른 수로 구성되어야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 1", "1, 2", "2, 3"})
    @DisplayName("위치, 값이 일치한 공일 경우, 스트라이크를 반환한다.")
    void match_return_strike(int position, int number) {
        //given
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Ball ball = new Ball(position, number);

        //when
        Status status = balls.match(ball);

        //then
        assertThat(status).isEqualTo(Status.STRIKE);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 2", "1, 3", "2, 1"})
    @DisplayName("값만 일치한 공일 경우, 볼을 반환한다.")
    void match_return_ball(int position, int number) {
        //given
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Ball ball = new Ball(position, number);

        //when
        Status status = balls.match(ball);

        //then
        assertThat(status).isEqualTo(Status.BALL);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 4", "1, 5", "2, 6"})
    @DisplayName("어떠한 값도 일치하지 않은 공일 경우, 낫싱을 반환한다.")
    void match_return_nothing(int position, int number) {
        //given
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Ball ball = new Ball(position, number);

        //when
        Status status = balls.match(ball);

        //then
        assertThat(status).isEqualTo(Status.NOTHING);
    }
}
