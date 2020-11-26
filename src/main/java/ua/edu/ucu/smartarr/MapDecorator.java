package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator implements MyFunction {
    public Object[] mapSmartArray;

    public MapDecorator(SmartArray smartArray) {
        super(smartArray);
        this.mapSmartArray = smartArray.toArray();
    }

    @Override
    public Object apply(Object t) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(mapSmartArray, size());
    }

    @Override
    public String operationDescription() {
        return "Maps each element of an array to a new type"; // ??
    }

    @Override
    public int size() {
        return mapSmartArray.length;
    }
}
