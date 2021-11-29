package by.bsu.shabunya.newyeargift.gift;

import by.bsu.shabunya.newyeargift.sweets.Sweet;
import by.bsu.shabunya.newyeargift.sweets.comparator.ComparatorBySugarWeight;
import by.bsu.shabunya.newyeargift.sweets.comparator.ComparatorByWeight;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class NewYearGift {
    private ArrayList<Sweet> sweets = new ArrayList<>();

    public NewYearGift() {}

    public NewYearGift(ArrayList<Sweet> sweets) {
        this.sweets = sweets;
    }

    public ArrayList<Sweet> getSweets() {
        return sweets;
    }

    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    public int calculateWeight() {
        return sweets.stream().mapToInt(Sweet::getWeight).sum();
    }

    public void sortSweetsByWeight() {
        sweets.sort(new ComparatorByWeight());
    }

    public void sortSweetsBySugarWeight() {
        sweets.sort(new ComparatorBySugarWeight());
    }

    public ArrayList<Sweet> findSweets(int sugarWeightMin, int sugarWeightMax) {
        return sweets.stream()
                .filter(x -> x.getSugarWeight() >= sugarWeightMin)
                .filter(x -> x.getSugarWeight() <= sugarWeightMax)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
