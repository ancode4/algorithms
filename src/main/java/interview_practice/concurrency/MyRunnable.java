package interview_practice.concurrency;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("MyRunnable running");
    }

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Lambda Runnable running");

        MyRunnable myRunnable = new MyRunnable();

        Thread normalThread = new Thread(myRunnable);
        Thread l = new Thread(runnable);

        normalThread.start();
        l.start();
    }
}
