public class TrenchDemo {
    public static void main(String[] args) {
        Trench trench = new Trench(10); // Target length is 10 meters
        Thread excavator1 = new Thread(new Excavator("Excavator 1", trench));


        long startTime1 = System.currentTimeMillis();
        System.out.println("Start ex2");
        excavator1.start();
        try {
            excavator1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("Time taken by Excavator 1: " + (endTime1 - startTime1) + " milliseconds");

        trench = new Trench(10); // Reset trench for the second excavator

        Thread excavator2 = new Thread(new Excavator("Excavator 2", trench));
        Thread excavator3 = new Thread(new Excavator("Excavator 3", trench));

        long startTime2 = System.currentTimeMillis();
        System.out.println("Start ex3");
        excavator3.start();
        System.out.println("Start ex2");
        excavator2.start();
        try {
            excavator3.join();
            excavator2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("Time taken by Excavators 3 and 2 together: " + (endTime2 - startTime2) + " milliseconds");
    }
}
