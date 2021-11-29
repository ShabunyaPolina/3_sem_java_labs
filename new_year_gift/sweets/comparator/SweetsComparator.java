package by.bsu.shabunya.newyeargift.sweets.comparator;

import by.bsu.shabunya.newyeargift.sweets.Sweet;

import java.util.Comparator;

public abstract class SweetsComparator implements Comparator<Sweet> {

    @Override
    public abstract int compare(Sweet sweet1, Sweet sweet2);
}
