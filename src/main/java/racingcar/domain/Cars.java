package racingcar.domain;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void carRace(int tryNumber) {
        while(tryNumber-- > 0) {
            carRace();
        }

    }

    public void carRace() {
        for(Car car : cars) {
            car.race();
        }
    }


    @Override
    public String toString() {
        String printString = "";
        for(Car car : this.cars) {
            printString += car.toString() + "\n";
        }
        return printString;
    }
}
