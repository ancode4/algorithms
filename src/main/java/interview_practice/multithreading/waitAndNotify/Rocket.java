package interview_practice.multithreading.waitAndNotify;

public class Rocket {
    boolean counting = true;
    public synchronized void startCountDown(){
        int c = 3;
        while (c != 0) {
            System.out.println(c);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            c--;
        }
        System.out.println("!!! READY !!!");
        counting = false;
        notify();
    }

    public synchronized void launch(String n){
        try {
            while (counting) {
                wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(">>> LAUNCH <<<");
        System.out.println("By: "+n);
    }
}
