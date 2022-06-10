package interview_practice.factorypattern;

public class Dish {
    private String model;

    public Dish(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
