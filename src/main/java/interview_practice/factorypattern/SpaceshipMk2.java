package interview_practice.factorypattern;

public class SpaceshipMk2 implements Spaceship {
    private Engine engine;
    private Dish dish;

    public SpaceshipMk2(Engine engine, Dish dish) {
        this.engine = engine;
        System.out.println("Powering up the Mk.2 Raptor Engine");

        this.dish = dish;
        System.out.println("Activating the Mk.2 Satellite Dish");
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