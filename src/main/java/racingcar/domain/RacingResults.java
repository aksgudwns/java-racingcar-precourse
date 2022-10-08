package racingcar.domain;

import java.util.*;

public class RacingResults {

    List<RacingResult> racingResults;

    public RacingResults(List<RacingResult> racingResults) {
        this.racingResults = racingResults;
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int maxPosition = -1;
        for(RacingResult racingResult : racingResults) {
            winners = addWinner(racingResult, maxPosition, winners);
            maxPosition = racingResult.maxPosition(maxPosition);
        }
        return winners;
    }

    private List<String> addWinner(RacingResult racingResult, int maxPosition, List<String> winners) {
        if(racingResult.compareToPosition(maxPosition) > 0) {
            winners = new ArrayList<>();
            racingResult.addWinner(winners);
        }
        if(racingResult.compareToPosition(maxPosition) == 0) {
            racingResult.addWinner(winners);
        }
        return winners;
    }

    public RacingResult getByCarName(String name) {
        Map<String, RacingResult> map = new HashMap<>();
        for(RacingResult racingResult : racingResults) {
            map.put(racingResult.getCarName(), racingResult);
        }
        return map.get(name);
    }

    public RacingResults copyOf() {
        List<RacingResult> copyList = new ArrayList<>();
        for(RacingResult racingResult : racingResults) {
            copyList.add(racingResult.copyOf());
        }
        return new RacingResults(copyList);
    }

    @Override
    public String toString() {
        String printingResults = "";
        for(RacingResult racingResult : racingResults) {
            printingResults += (racingResult.toString());
        }
        return printingResults;
    }

}
