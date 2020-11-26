package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator
        implements MyComparator {

    public Object[] distinctSmartArray;
    public MyComparator cmp;

    public DistinctDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        this.distinctSmartArray = Arrays.copyOf(smartArray.toArray(),
                smartArray.size());
        this.cmp = cmp;
        remove();
    }

    public void remove() {
        int index = 0;
        Object[] tempArray = new Object[size()];

        for (int i = 0; i < size() - 1; i++) {
            // compares current object and the rest and denotes
            // same ones as null
            if (distinctSmartArray[i] != null) {
                tempArray[index] = distinctSmartArray[i];
                index++;
            }
            for (int j = i + 1; j < size() - 2; j++) {
                if (distinctSmartArray[j] != null
                        && distinctSmartArray[i] != null
                        && compare(distinctSmartArray[i],
                        distinctSmartArray[j]) != 0) {
                    distinctSmartArray[j] = null;
                }
            }
        }
        distinctSmartArray = Arrays.copyOf(tempArray, index); // cut
        smartArray = new BaseArray(distinctSmartArray);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(distinctSmartArray, size());
    }

    @Override
    public String operationDescription() {
        return "Delete all duplicates in an given array";
    }

    @Override
    public int size() {
        return distinctSmartArray.length;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if (cmp.compare(o1, o2) != 0) {
            return 0;
        }
        return 1;
    }
}
