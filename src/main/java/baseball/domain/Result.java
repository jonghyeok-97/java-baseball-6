package baseball.domain;

public class Result {
    private final int ballCount;
    private final int strikeCount;

    private Result(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public static Result of(int ballCount, int strikeCount) {
        return new Result(ballCount, strikeCount);
    }


    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isAllStrike() {
        return strikeCount == 3;
    }
}
