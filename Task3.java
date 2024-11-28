class FactorialTask extends Thread {
    int num;
    
    public FactorialTask(int num) {
        this.num = num;
    }
    
    public void run() {
        int result = num;
        try {
            for (int i = num - 1; i >= 1; i--) {
                Thread.sleep(100);  
                System.out.println(result + "x" + i + "=" + (result *= i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PowerTask extends Thread {
    int num;
    
    public PowerTask(int num) {
        this.num = num;
    }
    
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                Thread.sleep(100);  
                System.out.println(num + "^" + i + " = " + (int)Math.pow(num, i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int firstNonZeroDigit = 2; 
        
        FactorialTask factorialTask = new FactorialTask(firstNonZeroDigit);
        PowerTask powerTask = new PowerTask(firstNonZeroDigit);
        
        factorialTask.start();
        powerTask.start();
    }
}
