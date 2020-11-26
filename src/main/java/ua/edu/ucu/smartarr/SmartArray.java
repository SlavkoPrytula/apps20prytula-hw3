package ua.edu.ucu.smartarr;

public interface SmartArray {
    // return array with SmartArray elements
    Object[] toArray();

    // return current operation name applied to SmartArray
    String operationDescription();

    // return SmartArray size
    int size();
   
}
