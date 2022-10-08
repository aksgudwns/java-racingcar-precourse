package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResults {
    List<RacingResult> racingResults;

    public RacingResults(List<RacingResult> racingResults) {
        this.racingResults = racingResults;
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int maxPosition = -1;
        for(RacingResult racingResult : racingResults) {
            winners = setWinner(racingResult, maxPosition, winners);
            maxPosition = racingResult.getMaxPosition(maxPosition);
        }
        return winners;
    }

    private List<String> setWinner(RacingResult racingResult, int maxPosition, List<String> winners) {
        if(racingResult.compareToPosition(maxPosition) > 0) {
            winners = new ArrayList<String>();
            racingResult.addWinner(winners);
        }
        if(racingResult.compareToPosition(maxPosition) == 0) {
            racingResult.addWinner(winners);
        }
        return winners;
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
