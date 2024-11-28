class FactorialTask extends Thread {
    int num;
    
    public FactorialTask(int num) {
        this.num = num;
    }
    
    public void run() {
        int result = num;
        synchronized (this) {  
            for (int i = num - 1; i >= 1; i--) {
                System.out.println(result + "x" + i + "=" + (result *= i));
            }
        }
    }
}

class PowerTask extends Thread {
    int num;
    
    public PowerTask(int num) {
        this.num = num;
    }
    
    public void run() {
        synchronized (this) {  
            for (int i = 1; i <= 5; i++) {
                System.out.println(num + "^" + i + " = " + (int)Math.pow(num, i));
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int firstNonZeroDigit = 2; 
        
        FactorialTask factorialTask = new FactorialTask(firstNonZeroDigit);
        PowerTask powerTask = new PowerTask(firstNonZeroDigit);
        
        try {
            factorialTask.start();
            factorialTask.join();  
            
            powerTask.start();
            powerTask.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
