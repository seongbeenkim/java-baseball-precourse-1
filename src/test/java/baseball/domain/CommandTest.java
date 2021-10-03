package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CommandTest {

    @ParameterizedTest
    @CsvSource(value = {"1, START", "2, EXIT"})
    @DisplayName("전달받은 숫자에 해당하는 게임 명령어를 반환한다.")
    void of(int number, Command expectedCommand) {
        //when
        Command command = Command.of(number);

        //then
        assertThat(command).isEqualTo(expectedCommand);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("전달받은 숫자에 해당하는 명령어를 찾지 못할 경우, 예외가 발생한다.")
    void of_fail_invalid_number(int number) {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Command.of(number))
                .withMessage("%d에 해당하는 명령어를 찾을 수 없습니다.", number);
    }

    @ParameterizedTest
    @CsvSource(value = {"START, true", "EXIT, false"})
    @DisplayName("시작 명령어인지 확인한다.")
    void isStart(Command command, boolean expected) {
        //when
        boolean actual = command.isStart();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
