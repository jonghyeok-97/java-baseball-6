package baseball.view;

import baseball.domain.Result;

public final class OutputView {

    public static void print(Result result) {
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

        printCounts(ballCount, strikeCount);
    }

    private static void printCounts(int ball, int strike) {
        if (ball != 0 && strike != 0) {
            System.out.printf("%d볼 %d스트라이크", ball, strike);
        }
        if (ball == 0 && strike != 0) {
            System.out.printf("%d스트라이크", strike);
        }
        if (ball != 0 && strike == 0) {
            System.out.printf("%d볼", ball);
        }
        if (ball == 0 && strike == 0) {
            System.out.printf("낫싱");
        }


    }
}
