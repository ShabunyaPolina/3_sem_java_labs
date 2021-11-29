package by.bsu.shabunya.newyeargift.sweets;

public abstract class Sweet {

    private String name;
    private final int weight;
    private final int sugarWeight;

    public Sweet(String name, int weight, int sugarWeight) {
        this.name = name;
        this.weight = weight;
        this.sugarWeight = sugarWeight;
    }

    public int getWeight() {
        return weight;
    }

    public int getSugarWeight() {
        return sugarWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " [" + weight + " g, sugar: " + sugarWeight + " g]";
    }
}
