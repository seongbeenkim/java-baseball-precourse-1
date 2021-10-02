package baseball.domain.ball;

import baseball.domain.ball.vo.Number;
import baseball.domain.ball.vo.Position;

import java.util.Objects;

public class Ball {

    private final Position position;
    private final Number number;

    public Ball(final int position, final int number) {
        this.position = new Position(position);
        this.number = new Number(number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Ball ball = (Ball) o;
        return Objects.equals(position, ball.position) && Objects.equals(number, ball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}
