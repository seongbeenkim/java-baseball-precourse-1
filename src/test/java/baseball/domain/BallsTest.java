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
}
