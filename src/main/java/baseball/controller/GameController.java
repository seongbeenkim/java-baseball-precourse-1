package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Command;
import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.NoSuchElementException;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        playGame();
        decideToReStart();
    }

    private void playGame() {
        Computer computer = new Computer();
        Result result;

        do {
            Balls userBalls = createUserBalls();
            result = computer.match(userBalls);
            outputView.printResult(result);
        } while (result.isNotThreeStrike());

        outputView.printGameEndingMessage();
    }

    private Balls createUserBalls() {
        try {
            List<Integer> ballNumbers = inputView.getBallNumbers();
            return new Balls(ballNumbers);
        } catch (NoSuchElementException e) {
            outputView.printError(e.getMessage());
            throw e;
        } catch (Exception e) {
            outputView.printError(e.getMessage());
            return createUserBalls();
        }
    }

    private void decideToReStart() {
        Command command = getCommand();

        if (command.isStart()) {
            run();
        }
    }

    private Command getCommand() {
        try {
            int commandNumber = inputView.getCommandNumber();
            return Command.findByNumber(commandNumber);
        } catch (Exception e) {
            outputView.printError(e.getMessage());
            return getCommand();
        }
    }
}
