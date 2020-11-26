package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.SortDecorator;
import ua.edu.ucu.smartarr.DistinctDecorator;
import ua.edu.ucu.smartarr.MapDecorator;

public class SmartArrayApp {
    static final int NUM_MULTIPLIER = 2;
    static final int YEAR = 2;
    static final double GPA = 4.0;

    public static Object[]
    filterPositiveIntegersSortAndMultiplyByTwo(Object[] integers) {
        SmartArray sa = new BaseArray(integers);

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o, Object a) {
                return ((Integer) o) - ((Integer) a);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return NUM_MULTIPLIER * ((Integer) t);
            }
        };


        sa = new MapDecorator(
                new SortDecorator(
                        new FilterDecorator(sa, pr),
                        cmp),
                func);

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFromSecondYearWithGPAgtFourAndOrderedBySurname(
                    Student[] students) {
        SmartArray sd = new BaseArray(students);

        MyComparator cmpName = new MyComparator() {
            @Override
            public int compare(Object o, Object a) {
                return ((Student) o).getName().compareTo(
                        ((Student) a).getName());
            }
        };

        MyPredicate prYear = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() == YEAR;
            }
        };

        MyPredicate prGpa = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getGPA() >= GPA;
            }
        };

        MyComparator cmpSurname = new MyComparator() {
            @Override
            public int compare(Object o, Object a) {
                return ((Student) o).getSurname().compareTo(
                        ((Student) a).getSurname());
            }
        };

        sd = new SortDecorator(
                new FilterDecorator(
                        new FilterDecorator(
                                new DistinctDecorator(sd, cmpName),
                                prYear),
                        prGpa),
                cmpSurname);

        String[] result = new String[sd.size()];
        int index = 0;
        for (Object st : sd.toArray()) {
            result[index++] = ((Student) st).getSurname()
                    + " " + ((Student) st).getName();
        }
        return Arrays.copyOf(result, result.length);
    }
}
