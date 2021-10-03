package baseball.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class ComputerTest {

    @Test
    @DisplayName("사용자의 공 집합과 비교한 결과를 반환한다.")
    void match() {
        try (MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            //given
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 2, 3);
            Balls balls = new Balls(Arrays.asList(1, 2, 3));
            Computer computer = new Computer();

            //when
            Result result = computer.match(balls);

            //then
            assertAll(
                    () -> assertThat(result.getStrikeCount()).isEqualTo(3),
                    () -> assertThat(result.getBallCount()).isEqualTo(0)
            );
        }
    }
}
