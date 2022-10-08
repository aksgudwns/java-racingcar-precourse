package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

public class CarsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_출력_테스트() {
        Cars cars = new Cars(Arrays.asList(
                new Car("Audi"), new Car("Benz"), new Car("Ford"), new Car("Volvo")));
        Assertions.assertThat(cars.race(0).toString())
                .contains("Audi : \nBenz : \nFord : \nVolvo : ");
    }

    @Test
    void 자동차_1회경주_후_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Cars cars = new Cars(Arrays.asList(
                            new Car("Audi"), new Car("Benz"), new Car("Ford"), new Car("Volvo")));
                    Assertions.assertThat(cars.race(1).toString())
                            .contains("Audi : -\nBenz : \nFord : -\nVolvo : -");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_2회경주_후_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Cars cars = new Cars(Arrays.asList(
                            new Car("Audi"), new Car("Benz"), new Car("Ford"), new Car("Volvo")));
                    Assertions.assertThat(cars.race(2).toString())
                            .contains("Audi : -\nBenz : --\nFord : -\nVolvo : ");
                },
                MOVING_FORWARD, STOP,               //Audi
                MOVING_FORWARD, MOVING_FORWARD,     //Benz
                STOP, MOVING_FORWARD,               //Ford
                STOP, STOP                          //Volvo
        );
    }
}
