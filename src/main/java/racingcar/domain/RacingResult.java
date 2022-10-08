package racingcar.domain;

public class RacingResult {

    private String carName;
    private int position;

    public RacingResult(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public void setPositionPlusOne(boolean isForward) {
        this.position += isForward ? 1 : 0;
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