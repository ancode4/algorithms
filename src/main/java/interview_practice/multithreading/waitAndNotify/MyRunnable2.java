package interview_practice.multithreading.waitAndNotify;

public class MyRunnable2 {
    public static void main(String[] args) throws InterruptedException {
        Rocket r = new Rocket();
        Thread c = new Thread(new CountdownInitiator(r));
        Thread l1 = new Thread(new Launcher(r, "l1"));
        Thread l2 = new Thread(new Launcher(r, "l2"));

        c.start();
        l1.start();
        l2.start();
    }

}
