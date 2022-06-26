package interview_practice.factorypattern;

public class NotificationMk1 implements Notification {
    private Engine engine;
    private Dish dish;

    public NotificationMk1(Engine engine, Dish dish) {
        this.engine = engine;
        System.out.println("Powering up the Mk.1 Raptor Engine");

        this.dish = dish;
        System.out.println("Activating the Mk.1 Satellite Dish");
    }

    @Override
    public void notifyUser() {

    }
}