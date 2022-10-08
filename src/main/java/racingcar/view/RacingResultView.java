package racingcar.view;

import racingcar.domain.RacingResultMap;

public class RacingResultView {

    public void print(RacingResultMap racingResult) {
        System.out.print("실행 결과 \n" + racingResult);
        String winners = "";
        for(String winner : racingResult.getFinalRacingResult().getWinner()) {
            winners += winner +", ";
        }
        System.out.println("최종 우승자 : " + winners.substring(0,winners.length()-2));
    }
}
