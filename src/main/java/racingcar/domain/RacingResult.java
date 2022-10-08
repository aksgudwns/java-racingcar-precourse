package racingcar.domain;

import racingcar.utils.NumberRule;

import java.util.List;

public class RacingResult {

    private String carName;
    private int position;

    public RacingResult(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public void forwardPosition(boolean isForward) {
        this.position += isForward ? NumberRule.FORWARD_NUMBER.getValue() : 0;
    }

    public int compareToPosition(int maxPosition) {
        return this.position - maxPosition;
    }

    public void addWinner(List<String> winners) {
        winners.add(this.carName);
    }

    public int maxPosition(int maxPosition) {
        return this.position > maxPosition ? this.position : maxPosition;
    }

    public String getCarName() {
        return this.carName;
    }

    public RacingResult copyOf() {
        return new RacingResult(this.carName, this.position);
    }

    @Override
    public String toString() {
        String printPosition = "";
        int printNumber = this.position;
        while(printNumber-- > 0) {
            printPosition += "-";
        }
        return carName + " : " + printPosition + "\n";
    }
}
