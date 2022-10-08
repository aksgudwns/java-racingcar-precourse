package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;

    private static final int NAME_LENGTH_LIMIT = 5;

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_MOVING_FORWARD_RANDOM_NUMBER = 4;

    public Car(String name) {
        if(name == null || "".equals(name))
            throw new IllegalArgumentException("이름을 입력해주세요");
        if(name.length() > NAME_LENGTH_LIMIT)
            throw new IllegalArgumentException("숫자는 최대5자입니다.");
        this.name = name;
    }


    public boolean isForward() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        if(randomNumber >= MIN_MOVING_FORWARD_RANDOM_NUMBER) return true;
        return false;
    }

    public String getName() {
        return this.name;
    }
}
