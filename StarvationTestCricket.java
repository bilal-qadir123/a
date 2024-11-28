class StarvationTestCricket {
    static class Fielder1 extends Thread {
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Fielder1: Stopping  the ball!");
            }
        }
    }

    static class Fielder2 extends Thread {
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Fielder2: Fielder1 always stops it, and Fielder2 rarely gets a chance!");
            }
        }
    }

    public static void main(String[] args) {
        Fielder1 fielder1 = new Fielder1();
        Fielder2 fielder2 = new Fielder2();

        fielder1.start();
        fielder2.start();
    }
}
