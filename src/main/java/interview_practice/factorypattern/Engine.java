package interview_practice.factorypattern;
public class Engine {
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    private String model;

    public Engine(String model) {
        this.model = model;
    }

}
