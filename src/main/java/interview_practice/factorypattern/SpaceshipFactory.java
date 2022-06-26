package interview_practice.factorypattern;
public class SpaceshipFactory {
    public Notification getSpaceship(Engine engine, Dish dish) {
        if (engine.getModel().equals("Mk.2") && dish.getModel().equals("Mk.2")) {
            return new NotificationMk2(engine, dish);
        } else if (engine.getModel().equals("Mk.1") && dish.getModel().equals("Mk.1")) {
            return new NotificationMk1(engine, dish);
        } else {
            System.out.println("Incompatible models of engine and satellite dish.");
        }
        return null;
    }

    public static void main(String[] args){
        SpaceshipFactory factory = new SpaceshipFactory();

        Engine engineMk1 = new Engine("Mk.1");
        Dish dishMk1 = new Dish("Mk.1");

        Engine engineMk2 = new Engine("Mk.2");
        Dish dishMk2 = new Dish("Mk.2");

        Notification notificationMk1 = factory.getSpaceship(engineMk1, dishMk1);
        Notification notificationMk2 = factory.getSpaceship(engineMk2, dishMk2);
        Notification notificationMkHybrid = factory.getSpaceship(engineMk1, dishMk2);
    }
}