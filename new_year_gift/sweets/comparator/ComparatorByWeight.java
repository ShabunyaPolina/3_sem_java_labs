package by.bsu.shabunya.newyeargift.sweets.comparator;

import by.bsu.shabunya.newyeargift.sweets.Sweet;

public class ComparatorByWeight extends SweetsComparator{
    @Override
    public int compare(Sweet sweet1, Sweet sweet2) {
        return sweet1.getWeight() - sweet2.getWeight();
    }
}
