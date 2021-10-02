package baseball.domain.ball.vo;

import java.util.Objects;

public class Position {

    private static final int MIN_THRESHOLD = 0;
    private static final int MAX_THRESHOLD = 2;

    private final int position;

    public Position(final int position) {
        validateThreshold(position);
        this.position = position;
    }

    private void validateThreshold(final int position) {
        if (position < MIN_THRESHOLD || position > MAX_THRESHOLD) {
            throw new IllegalArgumentException(
                    String.format("위치의 값은 %d 이상, %d 이하의 값이여야 합니다.", MIN_THRESHOLD, MAX_THRESHOLD));
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
