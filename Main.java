import java.util.ArrayList;
sealed class Student permits CollegeStudents {
    protected int id;
    protected String fname, lname;
    protected int age;

    Student (int id, String fname, String lname, int age) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }
}
final class CollegeStudents extends Student{
    private Grades grades;
    CollegeStudents (int id, String fname,String lname, int age, Grades grades) {
        super(id, fname,lname, age);
        this.grades = grades;
    }
    public void saveInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + lname + ", " + fname);
        System.out.println("Age: " + age);
        System.out.println("===== General Average =====");
        System.out.println(String.format("%.1f", grades.average()));
    }
}
record Grades(double prelimGrades,double midtermGrades,double finalGrades) {
    public double average() {
        return (prelimGrades * .3) + (midtermGrades * .3) + (finalGrades * .4);
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<CollegeStudents> student = new ArrayList<>();
        student.add(new CollegeStudents(1, "Andrew", "San Antonio", 20, new Grades(2.25, 1.5, 1.75) ));
        student.add(new CollegeStudents(2, "John Marcus", "Lomio", 20, new Grades(2.15, 1.25, 1.75) ));

        for (CollegeStudents students : student) {
            students.saveInfo();
        }
    }
}