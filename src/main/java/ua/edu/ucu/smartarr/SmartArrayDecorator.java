package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {
    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        super();
        this.smartArray = smartArray;
    }

}
