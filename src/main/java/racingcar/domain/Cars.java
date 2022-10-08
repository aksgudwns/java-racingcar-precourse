package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public TrialRacingResultMap race(int tryNumber) {
        Map<Integer, RacingResult> trialRacingResultMap = new HashMap<>();
        RacingResult racingResult = initializeRacingResult();
        int trialNumber = 0;
        while(trialNumber++ < tryNumber) {
            RacingResult beforeRacingResult = racingResult;
            racingResult = race(beforeRacingResult);
            trialRacingResultMap.put(trialNumber, racingResult.copyOf());
        }
        return new TrialRacingResultMap(trialRacingResultMap);
    }

    private RacingResult initializeRacingResult() {
        List<RacingResultByCar> racingResultByCars = new ArrayList<>();
        for(Car car : cars)
            racingResultByCars.add(new RacingResultByCar(car.getName(), 0));
        return new RacingResult(racingResultByCars);
    }

    public RacingResult race(RacingResult racingResult) {
        for(Car car : cars) {
            RacingResultByCar racingResultByCar = racingResult.getByCarName(car.getName());
            racingResultByCar.setPositionPlusOne(car.isForward());
        }
        return racingResult;
    }

}
