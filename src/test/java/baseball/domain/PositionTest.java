package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionTest {

    @Test
    @DisplayName("숫자를 입력받아 위치 객체를 생성한다.")
    void create() {
        //given
        int value = 1;

        //when
        Position position = new Position(value);

        //then
        assertThat(position).isEqualTo(new Position(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    @DisplayName("0 미만, 2 초과일 경우, 예외가 발생한다.")
    void create_fail_out_of_bound(int invalidPosition) {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Position(invalidPosition))
                .withMessage("위치의 값은 0 이상, 2 이하의 값이여야 합니다.");
    }
}
