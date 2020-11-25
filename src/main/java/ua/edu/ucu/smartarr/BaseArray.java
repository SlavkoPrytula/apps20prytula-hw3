package ua.edu.ucu.smartarr;

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
        return new Object[0];
    }

    @Override
    public String operationDescription() {
        return null; // ??
    }

    @Override
    public int size() {
        return INITIAL_CAPACITY;
    }
}
