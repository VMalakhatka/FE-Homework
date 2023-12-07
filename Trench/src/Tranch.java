


class Trench {
    private int targetLength;
    private int currentLength;

    public Trench(int targetLength) {
        this.targetLength = targetLength;
        this.currentLength = 0;
    }

    public int getCurrentLength() {
        return currentLength;
    }

    public int getTargetLength() {
        return targetLength;
    }

    public void dig(int meters) {
        if (currentLength < targetLength) {
            currentLength += meters;
            System.out.println("Dug " + meters + " meters. Current length: " + currentLength + " meters.");
        } else {
            System.out.println("Trench is already at target length.");
        }
    }
}

class Excavator implements Runnable {
    private String name;
    private Trench trench;

    public Excavator(String name, Trench trench) {
        this.name = name;
        this.trench = trench;
    }

    public void setTrench(Trench trench) {
        this.trench = trench;
    }

    @Override
    public void run() {
        while (trench.getCurrentLength() < trench.getTargetLength()) {
            System.out.println(name);
            trench.dig(1);
            try {
                if(trench.getCurrentLength() < trench.getTargetLength())
                    Thread.sleep(10000); // Rest for 10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " finished digging.");
    }
}

