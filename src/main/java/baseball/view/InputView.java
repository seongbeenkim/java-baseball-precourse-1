package baseball.view;

import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<Integer> getBallNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String numbers = readLine();
        String[] splitNumbers = numbers.split("");
        return toIntegers(splitNumbers);
    }

    public int getCommandNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요 : ");
        String gameCommandNumber = readLine();
        return toInteger(gameCommandNumber);
    }

    private String readLine() {
        String input = Console.readLine();
        validateBlank(input);
        return input;
    }

    private void validateBlank(final String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않으셨습니다.");
        }
    }

    private List<Integer> toIntegers(final String[] tokens) {
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            int number = toInteger(token);
            numbers.add(number);
        }

        return numbers;
    }

    private int toInteger(final String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("'%s'를 정수로 변환할 수 없습니다.", token));
        }
    }
}
