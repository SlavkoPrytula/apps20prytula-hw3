package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator
        implements MyFunction {

    private final Object[] mapSmartArray;
    public MyFunction func;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.func = func;
        this.mapSmartArray = Arrays.copyOf(smartArray.toArray(),
                smartArray.size());
        apply(mapSmartArray);
    }

    @Override
    public Object apply(Object t) {
        for (int i = 0; i < size(); i++) {
            mapSmartArray[i] = func.apply(mapSmartArray[i]);
        }
        return t;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(mapSmartArray, size());
    }

    @Override
    public String operationDescription() {
        return "Maps each element of an array to "
                + "a new one applying certain modifications";
    }

    @Override
    public int size() {
        return mapSmartArray.length;
    }
}
