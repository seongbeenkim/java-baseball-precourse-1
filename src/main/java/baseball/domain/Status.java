package baseball.domain;

public enum Status {
    STRIKE, BALL, NOTHING;

    public boolean isNothing() {
        return this == NOTHING;
    }
}
