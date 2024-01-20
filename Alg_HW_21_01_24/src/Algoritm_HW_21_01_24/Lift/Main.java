package Algoritm_HW_21_01_24.Lift;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Lift liftA = new Lift(0);
        Lift liftB = new Lift(8);

        List<Lift> lifts = new ArrayList<>();
        lifts.add(liftA);
        lifts.add(liftB);

        LiftController liftController = new LiftController(lifts);

        int callingFloor = 1;
        Lift nearestLift = liftController.findNearestLift(callingFloor);

        if (nearestLift != null) {
            nearestLift.moveToFloor(callingFloor);
        } else {
            System.out.println("No available lifts.");
        }
    }
}