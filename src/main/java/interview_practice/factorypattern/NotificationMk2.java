package interview_practice.factorypattern;

public class NotificationMk2 implements Notification {
    private Engine engine;
    private Dish dish;

    public NotificationMk2(Engine engine, Dish dish) {
        this.engine = engine;
        System.out.println("Powering up the Mk.2 Raptor Engine");

        this.dish = dish;
        System.out.println("Activating the Mk.2 Satellite Dish");
    }

    @Override
    public void notifyUser() {

    }
}