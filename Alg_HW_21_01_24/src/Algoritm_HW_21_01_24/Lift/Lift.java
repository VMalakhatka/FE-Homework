package Algoritm_HW_21_01_24.Lift;

public class Lift {
    private int currentFloor;

    public Lift(int initialFloor) {
        this.currentFloor = initialFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveToFloor(int targetFloor) {
        System.out.println("Lift moving to floor " + targetFloor);
        this.currentFloor = targetFloor;
    }
}