package interview_practice.multithreading;

public class MyThread extends Thread{
    @Override
    public void run(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("MyThread Running");
    }

    public static void main(String[] args) throws InterruptedException {
        /*Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(i);*/
        MyThread mythread = new MyThread();
        mythread.start();
        //mythread.join(); // will cause main thread to stop until mythread is finished
        System.out.println("Continuing main()");
    }
}
