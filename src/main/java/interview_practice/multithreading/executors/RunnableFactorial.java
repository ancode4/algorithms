package interview_practice.multithreading.executors;

public class RunnableFactorial implements Runnable{
    @Override
    public void run() {
        int factorial = 1;
        int number = 10;
        for(int count = number; count > 1; count--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(factorial);
            factorial = factorial * count;
        }
        //return factorial;
    }
}
