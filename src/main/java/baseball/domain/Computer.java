package baseball.domain;

public class Computer {

    private final Balls balls;

    public Computer() {
        this.balls = new Balls();
    }

    public Result match(final Balls balls) {
        return this.balls.matchAll(balls);
    }
}
