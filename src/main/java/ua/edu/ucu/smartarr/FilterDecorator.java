package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator implements MyPredicate {
    public Object[] filterSmartArray;

    public FilterDecorator(SmartArray smartArray) {
        super(smartArray);
        this.filterSmartArray = smartArray.toArray();
    }

    @Override
    public boolean test(Object t) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(filterSmartArray ,size());
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
