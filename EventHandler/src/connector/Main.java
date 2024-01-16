package connector;

public class Main {
    public static void main(String[] args) {


        Thread videoThread = new Thread(new Exchanger("VideoExchanger"));
        Thread audioThread = new Thread(new Exchanger("AudioExchanger"));
        Thread gameThread = new Thread(new Exchanger("GameExchanger"));

        videoThread.start();
        audioThread.start();
        gameThread.start();
    }
}