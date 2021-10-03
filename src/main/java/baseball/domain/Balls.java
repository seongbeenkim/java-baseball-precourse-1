package baseball.domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Balls {

    private static final int STANDARD_SIZE = 3;

    private final List<Ball> balls;

    public Balls() {
        this(createAutoBalls());
    }

    private static List<Integer> createAutoBalls() {
        Set<Integer> balls = new HashSet<>();

        while (isInvalidSize(balls)) {
            int randomNumber = Randoms.pickNumberInRange(Number.MIN_THRESHOLD, Number.MAX_THRESHOLD);
            balls.add(randomNumber);
        }

        return new ArrayList<>(balls);
    }

    private static boolean isInvalidSize(final Collection<Integer> balls) {
        return STANDARD_SIZE != balls.size();
    }

    public Balls(final List<Integer> numbers) {
        validateDuplication(numbers);
        this.balls = createBallsFrom(numbers);
    }

    private void validateDuplication(final List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (isInvalidSize(distinctNumbers)) {
            throw new IllegalArgumentException(String.format("총 %d개의 서로 다른 수로 구성되어야 합니다.", STANDARD_SIZE));
        }
    }

    private List<Ball> createBallsFrom(final List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            Ball ball = new Ball(i, numbers.get(i));
            balls.add(ball);
        }

        return balls;
    }

    public Result matchAll(final Balls balls) {
        Result result = new Result();

        for (Ball ball : this.balls) {
            Status status = balls.match(ball);
            result = result.add(status);
        }

        return result;
    }

    public Status match(final Ball ballToFind) {
        Count count = new Count();
        Status status = Status.NOTHING;

        while (status.isNothing() && count.isLessThan(balls.size())) {
            int currentCount = count.getCount();
            Ball ball = balls.get(currentCount);
            status = ball.compareTo(ballToFind);
            count = count.increase();
        }
        return status;
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
