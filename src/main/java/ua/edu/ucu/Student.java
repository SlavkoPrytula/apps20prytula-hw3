package ua.edu.ucu;


public class Student {

    private final double gpa;
    private final int year;
    private final String name;
    private final String surname;

    public Student(String name, String surname, double gpa, int year) {
        this.gpa = gpa;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return gpa;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name
                + ", surname=" + surname
                + ", " + "GPA=" + gpa
                + ", year=" + year + '}';
    }

}
