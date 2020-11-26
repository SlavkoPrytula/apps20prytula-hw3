package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;
import java.util.Collections;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator implements MyComparator {
    public MyComparator cmp;
    public Object[] compareSmartArray;

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        this.cmp = cmp;
        this.compareSmartArray = Arrays.copyOf(smartArray.toArray(), smartArray.size());
        Arrays.sort(compareSmartArray);
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0; // ???? why do we need this
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(compareSmartArray, size());
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return compareSmartArray.length;
    }
}
