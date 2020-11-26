package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
        SmartArray sa = new BaseArray(integers);

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
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
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(
                    Student[] students) {
        SmartArray sd = new BaseArray(students);

        MyComparator cmp_name = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student) o1).getName().compareTo(
                        ((Student)o2).getName());
            }
        };

        MyPredicate pr_year = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student)t).getYear() == 2;
            }
        };

        MyPredicate pr_gpa = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student)t).getGPA() >= 4;
            }
        };

        MyComparator cmp_surname = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student)o1).getSurname().compareTo(
                        ((Student)o2).getSurname());
            }
        };

        sd = new SortDecorator(
                new FilterDecorator(
                        new FilterDecorator(
                                new DistinctDecorator(sd, cmp_name),
                                pr_year),
                        pr_gpa),
                cmp_surname);

        String[] result = new String[sd.size()];
        int index = 0;
        for (Object st : sd.toArray()) {
            result[index++] = ((Student)st).getSurname()
                    + " " + ((Student)st).getName();
        }
        return Arrays.copyOf(result, result.length);
    }
}
