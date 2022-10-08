package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public RacingResults race(int tryNumber) {
        List<RacingResult> racingResults = new ArrayList<>();
        for(Car car : cars) {
            racingResults.add(race(car, tryNumber));
        }
        return new RacingResults(racingResults);
    }

    private RacingResult race(Car car, int tryNumber) {
        RacingResult racingResult = new RacingResult(car.getName(), 0);
        while(tryNumber-- > 0) {
            racingResult.setPositionPlusOne(car.isForward());
        }
        return racingResult;
    }

}
