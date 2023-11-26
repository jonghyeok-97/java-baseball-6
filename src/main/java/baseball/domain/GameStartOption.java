package baseball.domain;

import java.util.stream.Stream;

public enum GameStartOption {

    RESTART("1"),
    END("2");

    private final String option;

    GameStartOption(String option) {
        this.option = option;
    }

    public static GameStartOption find(String input) {
        return Stream.of(values())
                .filter(startOption -> startOption.option.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("erroㄱ다"));
    }
}
