package interview_practice.multithreading.executors;

import java.util.concurrent.Callable;

public class CallableFactorial implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int fact = 1;
        int number = 10;
        for(int count = number; count > 1; count--) {
            Thread.sleep(1000);
            System.out.println(fact);
            fact = fact * count;
        }
        return fact;
    }
}
