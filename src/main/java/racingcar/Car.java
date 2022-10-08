package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int position;

    private static final int NAME_LENGTH_LIMIT = 5;

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_MOVING_FORWARD_RANDOM_NUMBER = 4;

    private static final int START_POSITION = 0;

    public Car(String name) {
        if(name == null || "".equals(name))
            throw new IllegalArgumentException();
        if(name.length() > NAME_LENGTH_LIMIT)
            throw new IllegalArgumentException();
        this.name = name;
        this.position = START_POSITION;
    }


    public void race() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        if(randomNumber >= MIN_MOVING_FORWARD_RANDOM_NUMBER) this.position++;
    }

    @Override
    public String toString() {
        String positionString = "";
        while(this.position-- > 0) {
            positionString += "-";
        }
        return name + " : " + positionString;
    }
}
