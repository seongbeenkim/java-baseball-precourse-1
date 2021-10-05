package baseball.domain;

import java.util.Objects;

public class Count {

    private static final int MIN_THRESHOLD = 0;
    private static final int INCREASE_UNIT = 1;

    private final int count;

    public Count() {
        this(MIN_THRESHOLD);
    }

    public Count(final int count) {
        validateNegative(count);
        this.count = count;
    }

    private void validateNegative(final int count) {
        if (count < MIN_THRESHOLD) {
            throw new IllegalArgumentException(String.format("카운트는 최소 %d 이상이여야 합니다.", MIN_THRESHOLD));
        }
    }

    public int getCount() {
        return count;
    }

    public Count increase() {
        return new Count(count + INCREASE_UNIT);
    }

    public boolean isLessThan(final int value) {
        return count < value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Count count1 = (Count) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
