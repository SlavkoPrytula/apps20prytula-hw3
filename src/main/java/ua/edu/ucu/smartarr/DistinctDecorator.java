package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.ArrayList;
import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator implements MyComparator {
    public Object[] distinctSmartArray;

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        this.distinctSmartArray = smartArray.toArray();
    }

    public void remove() {
        int index = 0;
        boolean cmp;
        Object[] tempArray = new Object[size()];
        Arrays.sort(distinctSmartArray);

        for (int i = 0; i < size() - 1; i++) {
            // compares current object and next one in the array
            cmp = compare(distinctSmartArray[i], distinctSmartArray[i + 1]) > 0;
            if (!cmp) {
                tempArray[index] = distinctSmartArray[i];
                index++;
            }
        }
        distinctSmartArray = tempArray;
    }

    @Override
    public Object[] toArray() {
        return distinctSmartArray;
    }

    @Override
    public String operationDescription() {
        return "Delete all duplicates";
    }

    @Override
    public int size() {
        return distinctSmartArray.length;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return o1.equals(o2) ? 1 : 0;
    }
}
