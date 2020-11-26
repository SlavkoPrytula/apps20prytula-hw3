package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator
        implements MyComparator {

    public MyComparator cmp;
    public Object[] compareSmartArray;

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        this.cmp = cmp;
        this.compareSmartArray = Arrays.copyOf(smartArray.toArray(),
                smartArray.size());
        reduceNull();
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

    public void reduceNull() {
        Object[] temp = new Object[size()];
        int index = 0;
        for (Object obj : compareSmartArray) {
            if (obj != null) {
                temp[index] = obj;
                index++;
            }
        }
        compareSmartArray = Arrays.copyOf(temp, index);

    }
}
