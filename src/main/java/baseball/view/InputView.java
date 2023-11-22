package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int readNumber() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException error) {
            System.out.println("[ERROR] 숫자로만 입력해 주세요.");
            return readNumber();
        }
    }
}
