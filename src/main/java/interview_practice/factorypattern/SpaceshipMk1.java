package interview_practice.factorypattern;

public class SpaceshipMk1 implements Spaceship {
    private Engine engine;
    private Dish dish;

    public SpaceshipMk1(Engine engine, Dish dish) {
        this.engine = engine;
        System.out.println("Powering up the Mk.1 Raptor Engine");

        this.dish = dish;
        System.out.println("Activating the Mk.1 Satellite Dish");
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setDish(Dish dish) {
        this.dish = dish;
    }
}