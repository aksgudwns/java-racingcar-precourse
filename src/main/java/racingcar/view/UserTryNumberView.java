package racingcar.view;

public class UserTryNumberView extends UserCarView {
    @Override
    public void print() {
        super.print();
        System.out.println("시도할 회수는 몇회인가요?");
    }

}