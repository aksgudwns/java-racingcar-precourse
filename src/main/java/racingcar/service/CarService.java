package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingResultMap;
import racingcar.utils.RacingCarStringUtils;
import racingcar.utils.RacingCarUtils;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    public Cars getCars(String userInput) {
        validateGetCarInput(userInput);
        List<Car> carList = new ArrayList<>();
        String[] carNames = userInput.split(",");
        for(String carName : carNames) {
            carList.add(new Car(carName));
        }
        return new Cars(carList);
    }

    private void validateGetCarInput(String userInput) {
        RacingCarStringUtils.checkNotEmpty(userInput);
        String[] carNames = userInput.split(",");
        RacingCarStringUtils.checkNotDuplicate(carNames);
        RacingCarUtils.checkValidCarLength(carNames.length);
    }

    public int getTryNumber(String userInput) {
        validateGEtTryNumberInput(userInput);
        return Integer.parseInt(userInput);
    }

    private void validateGEtTryNumberInput(String userInput) {
        RacingCarStringUtils.checkNotEmpty(userInput);
        RacingCarStringUtils.checkNumberFormat(userInput);
        RacingCarUtils.checkMinTryNumber(Integer.parseInt(userInput));
    }


    public RacingResultMap race(Cars cars, int tryNumber) {
        return cars.race(tryNumber);
    }

}
