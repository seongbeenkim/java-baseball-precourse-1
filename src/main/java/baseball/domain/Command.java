package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public enum Command {
    START(1),
    EXIT(2);

    private static final Map<Integer, Command> COMMANDS = createCommands();

    private static Map<Integer, Command> createCommands() {
        Map<Integer, Command> commands = new HashMap<>();

        for (Command command : values()) {
            commands.put(command.number, command);
        }

        return commands;
    }

    private final int number;

    Command(final int number) {
        this.number = number;
    }

    public static Command of(final int number) {
        Command command = COMMANDS.get(number);

        if (command == null) {
            throw new IllegalArgumentException(String.format("%d에 해당하는 명령어를 찾을 수 없습니다.", number));
        }

        return command;
    }
}
