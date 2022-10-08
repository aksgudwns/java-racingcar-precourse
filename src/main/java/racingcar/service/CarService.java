package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TrialRacingResultMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarService {

    private static final char CHAR_0 = 48;
    private static final char CHAR_9 = 57;

    public Cars getCars(String userInput) {
        List<Car> carList = new ArrayList<>();
        String[] carNames = userInput.split(",");
        for(String carName : carNames) {
            carList.add(new Car(carName));
        }
        return new Cars(carList);
    }

    public int getTryNumber(String userInput) {
        for(char ch : userInput.toCharArray())
            numberCheck(ch);
        return Integer.parseInt(userInput);
    }

    private void numberCheck(char ch) {
        if(ch < CHAR_0 || ch > CHAR_9) throw new IllegalArgumentException("숫자가 아닌 값이 들어왔습니다.");
    }

    public TrialRacingResultMap race(Cars cars, int tryNumber) {
        return cars.race(tryNumber);
    }

}
