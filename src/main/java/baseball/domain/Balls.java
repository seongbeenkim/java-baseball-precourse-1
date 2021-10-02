package baseball.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Balls {

    private static final int STANDARD_SIZE = 3;

    private final Set<Ball> balls;

    public Balls(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.balls = createBallsFrom(numbers);
    }


    private void validateSize(final List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException(String.format("총 %d개의 숫자가 존재해야합니다", STANDARD_SIZE));
        }
    }

    private boolean isInvalidSize(final Collection<Integer> numbers) {
        return STANDARD_SIZE != numbers.size();
    }

    private void validateDuplication(final List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (isInvalidSize(distinctNumbers)) {
            throw new IllegalArgumentException("서로 다른 수로 구성되어야합니다.");
        }
    }

    private Set<Ball> createBallsFrom(final List<Integer> numbers) {
        Set<Ball> balls = new HashSet<>();

        for (int i = 0; i < numbers.size(); i++) {
            Ball ball = new Ball(i, numbers.get(i));
            balls.add(ball);
        }

        return balls;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Balls balls1 = (Balls) o;
        return Objects.equals(balls, balls1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
