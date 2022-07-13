package interview_practice.multithreading.waitAndNotify;

public class Launcher implements Runnable {
    private Rocket rocket;
    private String name;

    public Launcher(Rocket c, String name) {
        this.rocket = c;
        this.name = name;
    }

    @Override
    public void run() {
        rocket.launch(name);
    }
}
