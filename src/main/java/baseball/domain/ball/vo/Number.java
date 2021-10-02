package baseball.domain.ball.vo;

import java.util.Objects;

public class Number {

    private static final int MIN_THRESHOLD = 1;
    private static final int MAX_THRESHOLD = 9;

    private final int number;

    public Number(final int number) {
        validateThreshold(number);
        this.number = number;
    }

    private void validateThreshold(final int number) {
        if (number < MIN_THRESHOLD || number > MAX_THRESHOLD) {
            throw new IllegalArgumentException(
                    String.format("수의 값은 %d 이상, %d 이하의 값이여야 합니다.", MIN_THRESHOLD, MAX_THRESHOLD));
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
