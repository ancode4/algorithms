package interview_practice.concurrency;

public class MyRunnable {

    private static class RunnableExample implements Runnable {
        @Override
        public void run() {
            System.out.println("RunnableExample running");
        }
    }

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Lambda Runnable running");

        RunnableExample myRunnable = new RunnableExample();

        Thread normalThread = new Thread(myRunnable);
        Thread lambdaThread = new Thread(runnable);

        normalThread.start();
        lambdaThread.start();
    }
}
