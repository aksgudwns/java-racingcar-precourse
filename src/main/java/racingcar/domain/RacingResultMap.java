package racingcar.domain;

import java.util.Map;

/**
 * 시도횟수 별 레이싱결과를 표현하는 Map
 */
public class RacingResultMap {

    private Map<Integer, RacingResults> racingResultTrialMap;

    public RacingResultMap(Map<Integer, RacingResults> map) {
        this.racingResultTrialMap = map;
    }

    public RacingResults getFinalRacingResult() {
        int maxTrialNumber = -1;
        for(Integer trialNumber : racingResultTrialMap.keySet())
            maxTrialNumber = maxTrialNumber > trialNumber ? maxTrialNumber : trialNumber;
        return racingResultTrialMap.get(maxTrialNumber);
    }

    @Override
    public String toString() {
        String allRacingResult = "";
        for(Integer trialNumber : racingResultTrialMap.keySet()) {
            allRacingResult += racingResultTrialMap.get(trialNumber).toString() + "\n";
        }
        return allRacingResult;
    }

}
