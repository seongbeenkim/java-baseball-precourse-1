package baseball.domain;

public class Result {

    private final int strikeCount;
    private final int ballCount;

    public Result() {
        this(0, 0);
    }

    public Result(final int strikeCount, final int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isAllStrike() {
        return strikeCount == 3;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public Result add(final Status status) {
        if (status.isStrike()) {
            return new Result(strikeCount + 1, ballCount);
        }

        if (status.isBall()) {
            return new Result(strikeCount, ballCount + 1);
        }

        return this;
    }
}
