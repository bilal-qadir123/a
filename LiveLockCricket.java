class LivelockCricket {
    static class Fielder1 extends Thread {
        public void run() {
            synchronized (this) {
                System.out.println("Fielder1: Running to catch the ball...");
                try { 
                  Thread.sleep(50); } catch (InterruptedException e) {}
                System.out.println("Fielder1: Moving to avoid Fielder2...");
            }
        }
    }

    static class Fielder2 extends Thread {
        public void run() {
            synchronized (this) {
                System.out.println("Fielder2: Running to catch the ball...");
                try { Thread.sleep(50); } catch (InterruptedException e) {}
                System.out.println("Fielder2: Moving to avoid Fielder1...");
            }
        }
    }

    public static void main(String[] args) {
        Thread fielder1 = new Fielder1();
        Thread fielder2 = new Fielder2();
        
        fielder1.start();
        fielder2.start();
    }
}
