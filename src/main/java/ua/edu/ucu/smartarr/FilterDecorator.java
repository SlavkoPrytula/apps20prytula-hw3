package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator
        implements MyPredicate {

    private final MyPredicate predicate;
    private Object[] filterSmartArray;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;
        this.filterSmartArray = Arrays.copyOf(smartArray.toArray(),
                smartArray.size());
        test(filterSmartArray);
    }

    @Override
    public boolean test(Object t) {
        Object[] tempArray = new Object[size()];
        int index = 0;
        for (int i = 0; i < size(); i++) {
            if (predicate.test(filterSmartArray[i])) {
                tempArray[index] = filterSmartArray[i];
                index++;
            }
        }
        filterSmartArray = Arrays.copyOf(tempArray, index);
        smartArray = new BaseArray(filterSmartArray);
        return true;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(filterSmartArray, size());
    }

    @Override
    public String operationDescription() {
        return "Checks if the object is satisfies the predicate";
    }

    @Override
    public int size() {
        return filterSmartArray.length;
    }
}
