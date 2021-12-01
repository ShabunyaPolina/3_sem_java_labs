package by.bsu.shabunya.lab9.toy;

public class Toy {
    private String name;
    private int price;
    private AgeLimit ageLimit;

    public Toy(String name, int price, int lowerBound, int upperBound) {
        this.name = name;
        this.price = price;
        this.ageLimit = new AgeLimit(lowerBound, upperBound);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public AgeLimit getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(AgeLimit ageLimit) {
        this.ageLimit = ageLimit;
    }

    @Override
    public String toString() {
        return name + ": price = " + price +
                ", ageLimit-" + ageLimit;
    }
}
