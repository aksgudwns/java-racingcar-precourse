package racingcar.domain;

import java.util.Map;

public class TrialRacingResultMap {

    private Map<Integer, RacingResult> racingResultTrialMap;

    public TrialRacingResultMap(Map<Integer, RacingResult> map) {
        this.racingResultTrialMap = map;
    }

    public RacingResult getFinalRacingResult() {
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
