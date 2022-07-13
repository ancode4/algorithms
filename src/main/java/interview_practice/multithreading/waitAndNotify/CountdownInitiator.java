package interview_practice.multithreading.waitAndNotify;

public class CountdownInitiator implements Runnable{
    private Rocket rocket;

    public CountdownInitiator(Rocket c) {
        this.rocket = c;
    }

    @Override
    public void run() {
        rocket.startCountDown();
    }
}
