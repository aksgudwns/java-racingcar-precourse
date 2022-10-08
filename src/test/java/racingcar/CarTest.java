package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_이름_5자이하_유효성_테스트() {
        assertThatThrownBy(() -> new Car("hyndai")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_0자이상_유효성_테스트() {
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_달리기_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("audi");
                    car.race();
                    Assertions.assertThat(car.toString()).contains("audi : -");
                },
                MOVING_FORWARD
        );
    }


    @Test
    void 자동차_멈춤_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("audi");
                    car.race();
                    Assertions.assertThat(car.toString()).contains("audi : ");
                },
                STOP
        );
    }
}
