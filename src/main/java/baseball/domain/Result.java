package baseball.domain;

public class Result {

    private static final int NO_COUNT = 0;
    private static final int ADD_UNIT = 1;

    private final int strikeCount;
    private final int ballCount;

    public Result() {
        this(NO_COUNT, NO_COUNT);
    }

    public Result(final int strikeCount, final int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isNotThreeStrike() {
        return strikeCount != 3;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public Result add(final Status status) {
        if (status.isStrike()) {
            return new Result(strikeCount + ADD_UNIT, ballCount);
        }

        if (status.isBall()) {
            return new Result(strikeCount, ballCount + ADD_UNIT);
        }

        return this;
    }

    public boolean isNothing() {
        return strikeCount == NO_COUNT && ballCount == NO_COUNT;
    }
}
