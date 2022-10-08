package racingcar.domain;

import racingcar.utils.NumberRule;

import java.util.List;

public class RacingResultByCar {

    private String carName;
    private int position;

    public RacingResultByCar(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public void setPositionPlusOne(boolean isForward) {
        this.position += isForward ? NumberRule.FORWARD_NUMBER.getValue() : 0;
    }

    public int compareToPosition(int maxPosition) {
        return this.position - maxPosition;
    }

    public void addWinner(List<String> winners) {
        winners.add(this.carName);
    }

    public int getMaxPosition(int maxPosition) {
        return this.position > maxPosition ? this.position : maxPosition;
    }

    public String getCarName() {
        return this.carName;
    }

    public RacingResultByCar copyOf() {
        return new RacingResultByCar(this.carName, this.position);
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
