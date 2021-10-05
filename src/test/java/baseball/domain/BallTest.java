package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private Ball positionZeroAndNumberOneBall;

    @BeforeEach
    void setUp() {
        positionZeroAndNumberOneBall = new Ball(0, 1);
    }

    @Test
    @DisplayName("공의 위치, 숫자를 입력받아 공 객체를 생성한다.")
    void create() {
        //given
        int position = 0;
        int number = 1;

        //when
        Ball ball = new Ball(position, number);

        //then
        assertThat(ball).isEqualTo(new Ball(position, number));
    }

    @Test
    @DisplayName("위치, 숫자 값 모두 일치할 경우, 스트라이크를 반환한다.")
    void compareTo_return_strike() {
        //given
        Ball ball = new Ball(0, 1);

        //when
        Status status = positionZeroAndNumberOneBall.compareTo(ball);

        //then
        assertThat(status).isEqualTo(Status.STRIKE);
    }

    @Test
    @DisplayName("숫자 값만 일치할 경우, 볼을 반환한다.")
    void compareTo_return_ball() {
        //given
        Ball ballToCompare = new Ball(1, 1);

        //when
        Status status = positionZeroAndNumberOneBall.compareTo(ballToCompare);

        //then
        assertThat(status).isEqualTo(Status.BALL);
    }

    @Test
    @DisplayName("위치, 숫자 값 모두 일치하지 않을 경우, 낫싱을 반환한다.")
    void compareTo_return_nothing() {
        //given
        Ball ballToCompare = new Ball(1, 2);

        //when
        Status status = positionZeroAndNumberOneBall.compareTo(ballToCompare);

        //then
        assertThat(status).isEqualTo(Status.NOTHING);
    }
}
