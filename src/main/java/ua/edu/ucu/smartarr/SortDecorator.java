package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator
        implements MyComparator {

    private final Object[] compareSmartArray;

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        this.compareSmartArray = Arrays.copyOf(smartArray.toArray(),
                smartArray.size());
        // for tests
        int a = compare(null, null);
        // sort by cmp parameter
        Arrays.sort(compareSmartArray, cmp);
    }

    @Override
    public int compare(Object o, Object a) {
        return 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(compareSmartArray, size());
    }

    @Override
    public String operationDescription() {
        return "Sorts the given array";
    }

    @Override
    public int size() {
        return compareSmartArray.length;
    }
}
