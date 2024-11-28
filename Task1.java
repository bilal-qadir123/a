class FactorialTask extends Thread {
    int num;
    
    public FactorialTask(int num) {
        this.num = num;
    }
    
    public void run() {
        int result = num;
        System.out.println("Factorial of " + num + ":");
        for (int i = num - 1; i >= 1; i--) {
            result *= i;
            System.out.println(result + "x" + i + "=" + result);
        }
    }
}

class PowerTask extends Thread {
    int num;
    
    public PowerTask(int num) {
        this.num = num;
    }
    
    public void run() {
        System.out.println("Powers of " + num + ":");
        for (int i = 1; i <= 5; i++) {
            System.out.println(num + "^" + i + " = " + (int)Math.pow(num, i));
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
