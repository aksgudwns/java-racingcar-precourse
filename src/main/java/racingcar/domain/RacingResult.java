package racingcar.domain;

import java.util.*;

public class RacingResult {

    List<RacingResultByCar> racingResultByCars;

    public RacingResult(List<RacingResultByCar> racingResultByCars) {
        this.racingResultByCars = racingResultByCars;
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int maxPosition = -1;
        for(RacingResultByCar racingResultByCar : racingResultByCars) {
            winners = addWinner(racingResultByCar, maxPosition, winners);
            maxPosition = racingResultByCar.getMaxPosition(maxPosition);
        }
        return winners;
    }

    private List<String> addWinner(RacingResultByCar racingResultByCar, int maxPosition, List<String> winners) {
        if(racingResultByCar.compareToPosition(maxPosition) > 0) {
            winners = new ArrayList<>();
            racingResultByCar.addWinner(winners);
        }
        if(racingResultByCar.compareToPosition(maxPosition) == 0) {
            racingResultByCar.addWinner(winners);
        }
        return winners;
    }

    public RacingResultByCar getByCarName(String name) {
        Map<String, RacingResultByCar> map = new HashMap<>();
        for(RacingResultByCar racingResultByCar : racingResultByCars) {
            map.put(racingResultByCar.getCarName(), racingResultByCar);
        }
        return map.get(name);
    }

    public RacingResult copyOf() {
        List<RacingResultByCar> copyList = new ArrayList<>();
        for(RacingResultByCar racingResultByCar : racingResultByCars) {
            copyList.add(racingResultByCar.copyOf());
        }
        return new RacingResult(copyList);
    }

    @Override
    public String toString() {
        String printingResults = "";
        for(RacingResultByCar racingResultByCar : racingResultByCars) {
            printingResults += (racingResultByCar.toString());
        }
        return printingResults;
    }

}
