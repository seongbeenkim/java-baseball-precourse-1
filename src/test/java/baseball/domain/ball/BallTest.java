package baseball.domain.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

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
}
