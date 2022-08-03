package interview_practice.multithreading.executors;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadExecEg {
    public static void main(String[] args) throws Exception {
        CallableFactorial factCallable = new CallableFactorial();
        ExecutorService service = Executors.newSingleThreadExecutor();
        /*Future<Integer> fact = service.submit(() -> {
            int factorial = 1;
            int number = 10;
            for(int count = number; count > 1; count--) {
                Thread.sleep(1000);
                System.out.println(factorial);
                factorial = factorial * count;
            }
            return factorial;
        });*/
        Future<Integer> fact = service.submit(factCallable);

        System.out.println("Value: "+fact.get());
    }
}
