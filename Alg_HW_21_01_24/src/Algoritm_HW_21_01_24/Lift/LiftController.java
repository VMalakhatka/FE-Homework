package Algoritm_HW_21_01_24.Lift;

import java.util.List;

public class LiftController {
    private List<Lift> lifts;

    public LiftController(List<Lift> lifts) {
        this.lifts = lifts;
    }

    public Lift findNearestLift(int callingFloor) {
        Lift nearestLift = null;
        int minDistance = Integer.MAX_VALUE;

        for (Lift lift : lifts) {
            int distance = Math.abs(lift.getCurrentFloor() - callingFloor);
            if (distance < minDistance) {
                minDistance = distance;
                nearestLift = lift;
            }
        }

        return nearestLift;
    }
}