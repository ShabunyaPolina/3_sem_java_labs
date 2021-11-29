package by.bsu.shabunya.newyeargift.sweets.comparator;

import by.bsu.shabunya.newyeargift.sweets.Sweet;

public class ComparatorBySugarWeight extends SweetsComparator{
    @Override
    public int compare(Sweet sweet1, Sweet sweet2) {
        return sweet1.getSugarWeight() - sweet2.getSugarWeight();
    }
}
