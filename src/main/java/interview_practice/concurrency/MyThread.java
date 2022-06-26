package interview_practice.concurrency;

//import java.util.Scanner;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Thread Running");
    }

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(i);*/
        MyThread thread = new MyThread();
        thread.start();
    }
}
