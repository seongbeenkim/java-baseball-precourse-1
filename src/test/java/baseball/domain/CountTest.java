package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CountTest {

    @Test
    @DisplayName("1을 증가시킨 새로운 카운트 객체를 반환한다.")
    void increase() {
        //given
        Count count = new Count(0);

        //when
        Count increasedCount = count.increase();

        //then
        assertThat(increasedCount).isEqualTo(new Count(1));
    }

    @ParameterizedTest
    @CsvSource(value = {"1, false", "2, true"})
    @DisplayName("전달된 값보다 현재 카운트 값이 작은지 비교한다.")
    void isLessThan(int value, boolean expected) {
        //given
        Count count = new Count(1);

        //when
        boolean actual = count.isLessThan(value);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("음수일 경우, 예외가 발생한다.")
    void validateNegative() {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Count(-1))
                .withMessage("카운트는 최소 0 이상이여야 합니다.");
    }
}
