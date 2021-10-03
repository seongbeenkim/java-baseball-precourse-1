package baseball.domain;

public class Result {

    private final int strikeCount;
    private final int ballCount;

    public Result(final int strikeCount, final int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isAllStrike() {
        return strikeCount == 3;
    }
}
