package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray{
    static final int INITIAL_CAPACITY = 10;
    public Object[] array;

    public BaseArray() {
        this.array = new Object[INITIAL_CAPACITY];
    }

    public BaseArray(Object[] array) {
        this.array = array;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size());
    }

    @Override
    public String operationDescription() {
        return "Base Array: Representation of and Object[] class";
    }

    @Override
    public int size() {
        return array.length;
    }
}
