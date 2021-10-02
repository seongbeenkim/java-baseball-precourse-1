package baseball.domain.ball.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberTest {

    @Test
    @DisplayName("숫자를 입력받아 숫자 객체를 생성한다.")
    void create() {
        //given
        int value = 1;

        //when
        Number number = new Number(value);

        //then
        assertThat(number).isEqualTo(new Number(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    @DisplayName("1 미만, 9 초과일 경우, 예외가 발생한다.")
    void create_fail_out_of_bound(int invalidNumber) {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Number(invalidNumber))
                .withMessage("수의 값은 1 이상, 9 이하의 값이여야 합니다.");
    }
}
