package interview_practice.multithreading.executors;

import java.util.concurrent.Callable;

public class CallableFactorial implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int factorial = 1;
        int number = 10;
        for(int count = number; count > 1; count--) {
            Thread.sleep(1000);
            System.out.println(factorial);
            factorial = factorial * count;
        }
        return factorial;
    }
}
