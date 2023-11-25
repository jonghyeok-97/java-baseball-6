package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    public int pickAtRandom() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
