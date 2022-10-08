package racingcar.domain;

import java.util.List;

public class RacingResults {
    List<RacingResult> racingResults;

    public RacingResults(List<RacingResult> racingResults) {
        this.racingResults = racingResults;
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
