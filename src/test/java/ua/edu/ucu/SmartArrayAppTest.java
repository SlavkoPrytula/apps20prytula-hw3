package ua.edu.ucu;

import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

import java.awt.image.SampleModel;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 *
 * @author Andrii_Rodionov
 */
public class SmartArrayAppTest {

    @Test
    public void testFilterPositiveIntegersSortAndMultiplyBy2() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        
        Integer[] res = 
                SmartArrayApp.filterPositiveIntegersSortAndMultiplyBy2(integers);
        Integer[] expectedRes = {2, 4, 6};
        
        assertArrayEquals(expectedRes, res);        
    }

    @Test
    public void testFindDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname() {
        Student[] students = {
            new Student("Ivar", "Grimstad", 3.9, 2),
            new Student("Ittai", "Zeidman", 4.5, 1),
            new Student("Antons", "Kranga", 4.0, 2),
            new Student("Burr", "Sutter", 4.2, 2),
            new Student("Philipp", "Krenn", 4.3, 3),
            new Student("Tomasz", "Borek", 4.1, 2),
            new Student("Ittai", "Zeidman", 4.5, 1),
            new Student("Burr", "Sutter", 4.2, 2)};
        String[] studentNames = 
                SmartArrayApp.findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(students);
        String[] expectedStudentNames = {"Borek Tomasz", "Kranga Antons", "Sutter Burr"};

        assertArrayEquals(expectedStudentNames, studentNames);
    }

    @Test
    public void testOperationDescriptionBaseArray() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        SmartArray ints = new BaseArray(integers);

        String expectedStr = "Base Array: Representation of and Object[] class";
        String resultStr = ints.operationDescription();
        assertEquals(expectedStr, resultStr);
    }

    @Test
    public void testOperationDescriptionFilterDecorator() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        SmartArray ints = new BaseArray(integers);

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        ints = new FilterDecorator(ints, pr);

        String expectedStr = "Checks if the object is satisfies the predicate";
        String resultStr = ints.operationDescription();
        assertEquals(expectedStr, resultStr);
    }

    @Test
    public void testOperationDescriptionDistinctDecorator() {
        Integer[] integers = {-1, -1, 2, 2, 0, 0, 1, -5, 3, 0};
        SmartArray ints = new BaseArray(integers);

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer)o1 - (Integer)o2;
            }
        };

        ints = new DistinctDecorator(ints, cmp);

        String expectedStr = "Delete all duplicates in an given array";
        String resultStr = ints.operationDescription();
        assertEquals(expectedStr, resultStr);
    }

    @Test
    public void testOperationDescriptionMapDecorator() {
        Integer[] integers = {-1, -1, 2, 2, 0, 0, 1, -5, 3, 0};
        SmartArray ints = new BaseArray(integers);

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        ints = new MapDecorator(ints, func);

        String expectedStr = "Maps each element of an array to " +
                "a new one applying certain modifications";
        String resultStr = ints.operationDescription();
        assertEquals(expectedStr, resultStr);
    }

    @Test
    public void testOperationDescriptionSortDecorator() {
        Integer[] integers = {-1, -1, 2, 2, 0, 0, 1, -5, 3, 0};
        SmartArray ints = new BaseArray(integers);

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        ints = new SortDecorator(ints, cmp);

        String expectedStr = "Sorts the given array";
        String resultStr = ints.operationDescription();
        assertEquals(expectedStr, resultStr);
    }

    // -------------------------------------------------------------

    @Test
    public void testFilterDecorator() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        SmartArray ints = new BaseArray(integers);

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        ints = new FilterDecorator(ints, pr);

        Object[] expectedStr = new BaseArray(new Integer[]{2, 1, 3}).toArray();
        Object[] resultArr = ints.toArray();
        assertArrayEquals(expectedStr, resultArr);
    }

    @Test
    public void testDistinctDecorator() {
        Integer[] integers = {-1, -1, 2, 2, 0, 0, 1, -5, 3, 0};
        SmartArray ints = new BaseArray(integers);

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer)o1 - (Integer)o2;
            }
        };

        ints = new DistinctDecorator(ints, cmp);

        Object[] expectedStr = new BaseArray(new Integer[]{-1, 2, 0, 1, -5, 3}).toArray();
        Object[] resultArr = ints.toArray();
        assertArrayEquals(expectedStr, resultArr);
    }

    @Test
    public void testMapDecorator() {
        Integer[] integers = {-1, -1, 2, 2, 0, 0, 1, -5, 3, 0};
        SmartArray ints = new BaseArray(integers);

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        ints = new MapDecorator(ints, func);

        Object[] expectedStr = new BaseArray(new Integer[]{-2, -2, 4, 4, 0, 0, 2, -10, 6, 0}).toArray();
        Object[] resultArr = ints.toArray();
        assertArrayEquals(expectedStr, resultArr);
    }

    @Test
    public void testSortDecorator() {
        Integer[] integers = {-1, -1, 2, 2, 0, 0, 1, -5, 3, 0};
        SmartArray ints = new BaseArray(integers);

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        ints = new SortDecorator(ints, cmp);

        Object[] expectedStr = new BaseArray(new Integer[]{-5, -1, -1, 0, 0, 0, 1, 2, 2, 3}).toArray();
        Object[] resultArr = ints.toArray();
        assertArrayEquals(expectedStr, resultArr);
    }

    // -------------------------------------------------------------

    @Test
    public void testEmptyArray() {
        BaseArray integers = new BaseArray();
        integers.array[0] = 0;
        integers.array[1] = 11;
        integers.array[3] = -1;
        integers.array[2] = -51;
        integers.array[4] = 0;

        SmartArray ints = integers;

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        ints = new SortDecorator(ints, cmp);

        Object[] expectedStr = new BaseArray(new Integer[]{-51, -1, 0, 0, 11}).toArray();
        Object[] resultArr = ints.toArray();
        assertArrayEquals(expectedStr, resultArr);
    }

    @Test
    public void testStudentData() {
        Student students = new Student("Ivar", "Grimstad", 3.9, 2);

        String resultStudentData = students.toString();
        String expectedStudentData = "Student{name=Ivar, surname=Grimstad, GPA=3.9, year=2}";

        assertEquals(expectedStudentData, resultStudentData);
    }
}