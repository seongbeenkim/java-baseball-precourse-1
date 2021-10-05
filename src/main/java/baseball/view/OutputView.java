package baseball.view;

import baseball.domain.Result;

public class OutputView {

    private static final int NO_COUNT = 0;
    private static final String EMPTY = "";
    private static final String DELIMITER = " ";

    public void printError(final String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printResult(final Result result) {
        if (result.isNothing()) {
            System.out.println("낫싱");
            return;
        }

        String strikeCountFormat = createStrikeCountFormat(result.getStrikeCount());
        String ballCountFormat = createBallCountFormat(result.getBallCount());
        String resultFormat = String.join(DELIMITER, strikeCountFormat, ballCountFormat).trim();
        System.out.println(resultFormat);
    }

    private String createStrikeCountFormat(final int strikeCount) {
        if (strikeCount == NO_COUNT) {
            return EMPTY;
        }

        return strikeCount + "스트라이크";
    }

    private String createBallCountFormat(final int ballCount) {
        if (ballCount == NO_COUNT) {
            return EMPTY;
        }

        return ballCount + "볼";
    }

    public void printGameEndingMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
}
